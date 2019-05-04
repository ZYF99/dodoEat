package com.zyf.simplemvp.fragment.shop;


import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.zhengsr.viewpagerlib.indicator.TabIndicator;
import com.zhengsr.viewpagerlib.view.GlideViewPager;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.factory.presenter.shop.Contract_shop;
import com.zyf.factory.presenter.shop.Presenter_shop;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.fragment.MPagerAdapter;
import com.zyf.simplemvp.fragment.shop.frag_shop_inner.Fragment_shop_inner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_shop extends PresenterFragment<Contract_shop.Presenter> implements ViewPager.OnPageChangeListener, Contract_shop.View {

    @BindView(R.id.shop_indicator)
    TabIndicator tabIndicator;

    @BindView(R.id.shop_viewpager)
    GlideViewPager viewPager;

    public Fragment_shop() {
        // Required empty public constructor
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        //顶部指示器列表
        List<String> titles = new ArrayList<>();
        //Fragment实体
        List<com.zyf.common.common.app.Fragment> items = new ArrayList<>();
        titles.add("火锅");
        titles.add("饮品");
        titles.add("日料");
        titles.add("西餐");
        titles.add("自助");
        titles.add("串串");
        titles.add("烧烤");
        titles.add("粤菜");
        titles.add("湘菜");
        titles.add("汤粥");
        titles.add("其他");
        for (String s : titles) {
            items.add(Fragment_shop_inner.newInstance(s));
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
    }

    //viewPager的滑动监听
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void fun1Callback() {

    }

    @Override
    protected Contract_shop.Presenter initPresenter() {
        return new Presenter_shop(this);
    }

}
