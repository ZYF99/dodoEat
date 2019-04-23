package com.zyf.simplemvp.fragment.homepage;


import android.support.v4.view.ViewPager;
import android.view.View;
import com.zhengsr.viewpagerlib.indicator.TabIndicator;
import com.zhengsr.viewpagerlib.view.GlideViewPager;
import com.zyf.common.common.app.Fragment;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.factory.presenter.homepage.Presenter_homepage;
import com.zyf.factory.presenter.homepage.Contract_homepage;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.fragment.MPagerAdapter;
import com.zyf.simplemvp.fragment.frag_homepage_inner.Fragment_homepage_inner;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


public class Fragment_homepage extends PresenterFragment<Contract_homepage.Presenter> implements Contract_homepage.View, ViewPager.OnPageChangeListener {

    @BindView(R.id.line_indicator)
    TabIndicator tabIndicator;

    @BindView(R.id.splase_viewpager)
    GlideViewPager viewPager;

    public Fragment_homepage() {

    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        //顶部指示器列表
        List<Fragment> items = new ArrayList<>();
        items.add(Fragment_homepage_inner.newInstance("关注"));
        items.add(Fragment_homepage_inner.newInstance("发现"));
        items.add(Fragment_homepage_inner.newInstance("附近"));
        List<String> titles = new ArrayList<>();
        titles.add("关注");
        titles.add("发现");
        titles.add("附近");

        //ViewPager设置
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getFragmentManager(),items);
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

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_homepage;
    }


    //返回此FragmentPresenter的实体类对象
    @Override
    protected Contract_homepage.Presenter initPresenter() {
        return new Presenter_homepage(this);
    }


    //此Fragment特有方法在Presenter执行后的回调
    @Override
    public void fun1Callback() {

    }






    //本页的Viewpager的监听回调
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
