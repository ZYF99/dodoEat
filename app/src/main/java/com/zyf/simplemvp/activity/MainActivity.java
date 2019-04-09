package com.zyf.simplemvp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.zyf.common.common.app.Activity;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.fragment.Fragment1;
import com.zyf.simplemvp.fragment.Fragment2;
import com.zyf.simplemvp.fragment.Fragment3;
import com.zyf.simplemvp.helper.NavHelper;

import butterknife.BindView;


public class MainActivity extends Activity implements BottomNavigationView.OnNavigationItemSelectedListener, NavHelper.OnTabChangedListener<Integer> {
    //底部导航栏辅助工具
    private NavHelper<Integer> mNavHelper;

    //顶部applbar
    @BindView(R.id.appbar)
    View mLayAppBar;

    //顶部title
    @BindView(R.id.txt_title)
    TextView title;

    //底部导航栏
    @BindView(R.id.navigation)
    BottomNavigationViewEx mNavigation;


    public static void show(Context context) {
        //MainActivity显示的入口
        context.startActivity(new Intent(context, MainActivity.class));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();

        //初始化底部辅助工具类
        mNavHelper = new NavHelper<>(this, R.id.lay_container, getSupportFragmentManager(), this);

        //添加Fragment页面
        mNavHelper.add(R.id.nav_1, new NavHelper.Tab<Integer>(Fragment1.class, R.string.page1))
                .add(R.id.nav_2, new NavHelper.Tab<Integer>(Fragment2.class, R.string.page2))
                .add(R.id.nav_3, new NavHelper.Tab<Integer>(Fragment3.class, R.string.page3));


        //添加对底部按钮点击的监听
        mNavigation.setOnNavigationItemSelectedListener(this);
        mNavigation.enableAnimation(false);
        mNavigation.enableShiftingMode(false);
        mNavigation.enableItemShiftingMode(false);
        mNavigation.setIconVisibility(false);
        //toolbar初始化
        Glide.with(this).load(R.drawable.default_banner_chat).
                centerCrop().into(new ViewTarget<View, GlideDrawable>(mLayAppBar) {
            //图片加载成功的回调
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super
                    GlideDrawable> glideAnimation) {
                this.view.setBackground(resource.getCurrent());
            }
        });
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
        title.setText(newTab.extra);
    }


}
