package com.zyf.simplemvp.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import com.zyf.common.common.app.Activity;
import com.zyf.common.common.app.Application;
import com.zyf.common.common.app.statushelper.StatusBarUtil;
import com.zyf.simplemvp.App;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.fragment.homepage.Fragment_homepage;
import com.zyf.simplemvp.fragment.shop.Fragment_shop;
import com.zyf.simplemvp.fragment.message.Fragment_message;
import com.zyf.simplemvp.fragment.personal.Fragment_personal;
import com.zyf.simplemvp.helper.NavHelper;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends Activity implements BottomNavigationView.OnNavigationItemSelectedListener, NavHelper.OnTabChangedListener<Integer> {

    private static final int REQUEST_CODE_CHOOSE = 0;
    private static final int REQUEST_CODE_CHOOSE_PHOTO_ALBUM = 1;

    private static final int REQUEST_CODE_PERMISSION = 2;



    // 要申请的权限
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA};

    //获取权限提示弹窗
    AlertDialog dialog;

    //底部导航栏辅助工具
    private NavHelper<Integer> mNavHelper;
    //顶部applbar
    @BindView(R.id.appbar)
    View mLayAppBar;


    //底部导航栏
    @BindView(R.id.navigation)
    BottomNavigationViewEx mNavigation;


    //底部发布按钮的点击事件
    @OnClick(R.id.navigation_center_image)
    void onBtn_centerClick() {

        //检查权限
        checkPermission();

    }

    //MainActivity显示的入口
    public static void show(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        //状态栏字体黑色
        StatusBarUtil.setStatusTextColor(true, this);
        //初始化主活动的ViewPager（首页，店铺，消息，我的三个大功能界面）
        initViewPager();

/*        //toolbar背景初始化
        Glide.with(this).load(R.drawable.default_banner_chat).
                centerCrop().into(new ViewTarget<View, GlideDrawable>(mLayAppBar) {
            //图片加载成功的回调
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super
                    GlideDrawable> glideAnimation) {
                this.view.setBackground(resource.getCurrent());
            }
        });*/
    }


    /*
     *初始化主活动的ViewPager（首页，消息，我的三个大功能界面）
     *
     * */

    protected void initViewPager() {
        //初始化底部辅助工具类
        mNavHelper = new NavHelper<>(this, R.id.lay_container, getSupportFragmentManager(), this);

        //添加Fragment页面
        mNavHelper.add(R.id.nav_1, new NavHelper.Tab<Integer>(Fragment_homepage.class, R.string.page1))
                .add(R.id.nav_2, new NavHelper.Tab<Integer>(Fragment_shop.class, R.string.page2))
                .add(R.id.nav_3, new NavHelper.Tab<Integer>(Fragment_message.class, R.string.page3))
                .add(R.id.nav_4, new NavHelper.Tab<Integer>(Fragment_personal.class, R.string.page4));


        //底部导航栏初始化
        mNavigation.setLargeTextSize(16);
        mNavigation.setOnNavigationItemSelectedListener(this);
        mNavigation.enableAnimation(true);
        mNavigation.enableShiftingMode(false);
        mNavigation.enableItemShiftingMode(false);
        mNavigation.setIconVisibility(false);
    }


    //初始化控件之后初始化数据
    @Override
    protected void initData() {
        super.initData();
        //从底部导航中接管Menu，然后手动的触发第一次点击
        Menu menu = mNavigation.getMenu();
        menu.performIdentifierAction(R.id.nav_1, 0);

    }

    //导航栏切换事件
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //转接事件流到工具类中
        return mNavHelper.performClickMenu(menuItem.getItemId());
    }

    /**
     * NavHelper处理后回调的方法
     *
     * @param newTab 新的Tab
     * @param oldTab 旧的Tab
     */
    @Override
    public void onTabChanged(NavHelper.Tab<Integer> newTab, NavHelper.Tab<Integer> oldTab) {

    }


    //1 图片画廊 2 设置界面 的返回
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_CHOOSE_PHOTO_ALBUM:
                if (resultCode == RESULT_OK) {
                    //图片路径 同样视频地址也是这个 根据requestCode
                    List<Uri> pathList = Matisse.obtainResult(data);
                    Application.showToast(pathList.toString());
                }
                break;

            case REQUEST_CODE_PERMISSION:
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                     // 检查该权限是否已经获取
                                     int i = ContextCompat.checkSelfPermission(this, permissions[0]);
                                     int j = ContextCompat.checkSelfPermission(this, permissions[1]);
                                     // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝jjj
                                     if (i != PackageManager.PERMISSION_GRANTED || j != PackageManager.PERMISSION_GRANTED) {
                                             // 提示用户应该去应用设置界面手动开启权限
                                             showDialogTipUserGoToAppSettting();
                                         } else {
                                             if (dialog != null && dialog.isShowing()) {
                                                     dialog.dismiss();
                                                 }
                                         Application.showToast("权限获取成功");
                                         }
                                 }

                break;
        }

    }

    //检查权限
    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //检查权限是否获取
            int i = ContextCompat.checkSelfPermission(this, permissions[0]);
            int j = ContextCompat.checkSelfPermission(this, permissions[1]);
            if (i != PackageManager.PERMISSION_GRANTED || j != PackageManager.PERMISSION_GRANTED) {
                //未授权 提示用户去授权
                showDialogTipUserRequestPermission();
            } else {
                //已授权 显示图片画廊
                showImageGallery();
            }

        }
    }

    // 提示用户该请求权限的弹出框
    private void showDialogTipUserRequestPermission() {
        new AlertDialog.Builder(this)
                .setTitle("存储或相机权限不可用")
                .setMessage("吃货需要获取本地相册，请开启内存及相机权限；\n否则，您将无法正常使用吃货")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startRequestPermission();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setCancelable(false).show();
    }

    // 开始提交请求权限
    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_PERMISSION);
    }

    //展示图片选择画廊
    private void showImageGallery() {
        Matisse.from(MainActivity.this)

/*                //选择视频和图片
                .choose(MimeType.ofAll())*/

                //选择图片
                .choose(MimeType.ofImage())

/*                //选择视频
                .choose(MimeType.ofVideo())*//*

         */
/*                //自定义选择选择的类型
                .choose(MimeType.of(MimeType.JPEG,MimeType.AVI))*/

                    //是否只显示选择的类型的缩略图，就不会把所有图片视频都放在一起，而是需要什么展示什么
                    .showSingleMediaType(true)
                    //这两行要连用 是否在选择图片中展示照相 和适配安卓7.0 FileProvider
                    .capture(true)
                    .captureStrategy(new CaptureStrategy(true, "PhotoPicker"))
                    //有序选择图片 123456...
                    .countable(true)
                    //最大选择数量为9
                    .maxSelectable(9)
                    //选择方向
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                    //界面中缩略图的质量
                    .thumbnailScale(0.8f)
                    //蓝色主题
                .theme(R.style.Matisse_Zhihu)

/*                //黑色主题
                .theme(R.style.Matisse_Dracula)*/

                //Glide加载方式
                .imageEngine(new GlideEngine())
                //请求码
                .forResult(REQUEST_CODE_CHOOSE);

    }

    //权限申请后的回调方法
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // 判断用户是否点击了不再提醒(检测该权限是否还可以申请)
                    boolean b = shouldShowRequestPermissionRationale(permissions[0]);
                    boolean c = shouldShowRequestPermissionRationale(permissions[1]);
                    if (!b||!c) {
                        //用户还是想用这个App的
                        //提示他龟儿自己去设置里手动开启
                        showDialogTipUserGoToAppSettting();
                    }else {
                        showImageGallery();
                    }
                }

            }
        }
    }

    // 提示用户去应用设置界面手动开启权限
    private void showDialogTipUserGoToAppSettting() {
        dialog = new AlertDialog.Builder(this)
                .setTitle("存储或相机权限不可用")
                .setMessage("请在-应用设置-权限-中，允许吃货使用存储及相机权限来读取相册")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 跳转到应用设置界面
                        goToAppSetting();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setCancelable(false).show();
    }

    //跳转到当前应用的设置界面
    private void goToAppSetting(){
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",getPackageName(),null);
        intent.setData(uri);
        startActivity(intent);
    }
}
