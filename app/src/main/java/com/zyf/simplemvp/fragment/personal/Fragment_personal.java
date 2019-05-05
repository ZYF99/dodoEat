package com.zyf.simplemvp.fragment.personal;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zhengsr.viewpagerlib.indicator.TabIndicator;
import com.zhengsr.viewpagerlib.view.GlideViewPager;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.common.common.widget.StickyScrollView;
import com.zyf.factory.presenter.personal.Contract_personal;
import com.zyf.factory.presenter.personal.Presenter_personal;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.activity.FansActivity;
import com.zyf.simplemvp.fragment.MPagerAdapter;
import com.zyf.simplemvp.fragment.personal.frag_personal_inner.Fragment_personal_inner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_personal extends PresenterFragment<Contract_personal.Presenter> implements Contract_personal.View, ViewPager.OnPageChangeListener {


    @BindView(R.id.stickyscrollview)
    StickyScrollView stickyScrollView;


    @BindView(R.id.personal_viewpager)
    GlideViewPager viewPager;
    @BindView(R.id.header_line_indicator)
    TabIndicator tabIndicator;
    @BindView(R.id.personal_icon)
    CircleImageView icon;
    @BindView(R.id.num_following)
    TextView tv_num_following;
    @BindView(R.id.num_fans)
    TextView tv_num_fans;
    @BindView(R.id.num_likesorcollect)
    TextView tv_num_likesorcollect;

    @OnClick(R.id.btn_myfans)
    void onFansClick() {
        Intent intent = new Intent(getContext(), FansActivity.class);
        FansActivity.show(Objects.requireNonNull(getContext()), intent);

    }

    public Fragment_personal() {
        // Required empty public constructor
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);


        //顶部指示器列表
        List<String> titles = new ArrayList<>();

        //Fragment实体
        List<com.zyf.common.common.app.Fragment> items = new ArrayList<>();
        titles.add("笔记");
        titles.add("收藏");
        titles.add("赞过");
        for (String s : titles) {
            items.add(Fragment_personal_inner.newInstance(s));
        }


        //ViewPager设置
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getFragmentManager(), items);
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setCurrentItem(0);


        tabIndicator.setTabData(viewPager, titles, new TabIndicator.TabClickListener() {
            @Override
            public void onClick(int position) {
                //顶部点击的方法公布出来
                viewPager.setCurrentItem(position);
            }
        });

        stickyScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int i, int i1, int i2, int i3) {
                if (stickyScrollView.isClippingToPadding()) {
                    ((Fragment_personal_inner) items.get(viewPager.getCurrentItem())).recyclerView.setNestedScrollingEnabled(true);
                } else {
                    ((Fragment_personal_inner) items.get(viewPager.getCurrentItem())).recyclerView.setNestedScrollingEnabled(false);
                }
            }
        });

    }

    @Override
    public void fun1Callback() {

    }

    @Override
    protected Contract_personal.Presenter initPresenter() {
        return new Presenter_personal(this);
    }


    //****************************************VirePager相关*****************************************
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
