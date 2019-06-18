package com.zyf.simplemvp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.zyf.common.common.app.Activity;
import com.zyf.common.common.app.Application;
import com.zyf.common.common.app.statushelper.StatusBarUtil;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.fragment.homepage.Fragment_homepage;
import com.zyf.simplemvp.fragment.shop.Fragment_shop;
import com.zyf.simplemvp.fragment.message.Fragment_message;
import com.zyf.simplemvp.fragment.personal.Fragment_personal;
import com.zyf.simplemvp.helper.NavHelper;
import butterknife.BindView;


public class MainActivity extends Activity implements BottomNavigationView.OnNavigationItemSelectedListener, NavHelper.OnTabChangedListener<Integer> {
    //底部导航栏辅助工具
    private NavHelper<Integer> mNavHelper;
    //顶部applbar
    @BindView(R.id.appbar)
    View mLayAppBar;


    //底部导航栏
    @BindView(R.id.navigation)
    BottomNavigationViewEx mNavigation;

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
        StatusBarUtil.setStatusTextColor(true,this);
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


}
