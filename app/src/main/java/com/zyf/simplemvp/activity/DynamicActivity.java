package com.zyf.simplemvp.activity;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zhengsr.viewpagerlib.anim.MzTransformer;
import com.zhengsr.viewpagerlib.bean.PageBean;
import com.zhengsr.viewpagerlib.callback.PageHelperListener;
import com.zhengsr.viewpagerlib.indicator.ZoomIndicator;
import com.zhengsr.viewpagerlib.view.BannerViewPager;
import com.zyf.common.common.app.Activity;
import com.zyf.common.common.app.statushelper.StatusBarUtil;
import com.zyf.factory.model.homepage.Dynamic;
import com.zyf.simplemvp.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class DynamicActivity extends Activity implements Serializable {

    final static String TAG ="**DynamicActivity**";

    @BindView(R.id.dynamic_portrait)
    CircleImageView portraitView;
    @BindView(R.id.dynamic_name)
    TextView tv_name;
    @BindView(R.id.dynamic_btn_follow)
    Button btn_follow;
    @BindView(R.id.btn_like)
    ImageView btn_like;
    @BindView(R.id.btn_collect)
    ImageView btn_collect;
    @BindView(R.id.btn_comment)
    ImageView btn_comment;
    @BindView(R.id.dynamic_banner)
    BannerViewPager viewPager;
    @BindView(R.id.dynamic_arc)
    ZoomIndicator zoomIndicator;
    @BindView(R.id.toolbar_back)
    ImageView btn_back;
    @BindView(R.id.personal_name)
    TextView tv_title;
    @BindView(R.id.dynamic_content)
    TextView tv_content;
    @BindView(R.id.tv_pagenum)
    TextView tv_pagenum;
    private static Dynamic dynamic;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_dynamic;
    }


    //抛给外界的启动activity的方法
    public static void show(Context context, Intent intent) {
        context.startActivity(intent);
    }




    //初始化界面前的参数获取
    @Override
    protected void initBefore() {
        super.initBefore();
        //接收前一活动序列化传来的动态详情对象
        dynamic = (Dynamic)getIntent().getSerializableExtra("dynamic_data");
        Log.d(TAG, "show: "+dynamic.toString());
    }


    @Override
    protected void initWidget() {
        super.initWidget();
        //状态栏字体黑色
        StatusBarUtil.setStatusTextColor(true,this);
        //toolbar中的标题加载
        tv_title.setText(dynamic.getAuthor().getName());
        //头像加载
        Glide.with(this).load(dynamic.getAuthor().getImageUrl()).placeholder(R.drawable.bg_placeholder).crossFade().into(portraitView);
        //作者名
        tv_name.setText(dynamic.getAuthor().getName());
        //内容
        tv_content.setText(dynamic.getContent());

        List<Banner_Item> loopBeens = new ArrayList<>();
        for (String url : dynamic.getImgUrlList()) {
            Banner_Item bean = new Banner_Item(url);
            loopBeens.add(bean);
        }
        PageBean bean = new PageBean.Builder<Banner_Item>()
                .setDataObjects(loopBeens)
                .setIndicator(zoomIndicator)
                .builder();
        viewPager.setPageTransformer(false, new MzTransformer());
        viewPager.setPageListener(bean, R.layout.image, new PageHelperListener() {
            @Override
            public void getItemView(View view, Object data) {
                ImageView imageView = view.findViewById(R.id.img);
                Banner_Item bean = (Banner_Item) data;
                Glide.with(DynamicActivity.this).load(bean.url).into(imageView);
            }
        });
        //监听图片滑动，页数改变
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                tv_pagenum.setText(i+1+"/"+loopBeens.size());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @OnClick(R.id.dynamic_btn_follow)
    void OnFollowClick() {

    }

    @OnClick(R.id.btn_like)
    void onLikeClick(){
        showHeartAnim(btn_like);
    }

    @OnClick(R.id.toolbar_back)
    void OnBackClick() {
        finish();
    }




    class Banner_Item {
        String url;

        public Banner_Item(String url) {
            this.url = url;
        }

    }

    //点了爱心的动画
    void showHeartAnim(View heartView) {
        Animation heart_in = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        Animation heart_out = AnimationUtils.loadAnimation(this, R.anim.anim_scale_out);
        heartView.startAnimation(heart_in);
        ((ImageView) heartView).setImageResource(R.drawable.ic_heart_pressed);
        heartView.startAnimation(heart_out);
    }

}
