package com.zyf.simplemvp.fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.zhengsr.viewpagerlib.indicator.TabIndicator;
import com.zhengsr.viewpagerlib.view.GlideViewPager;
import com.zyf.common.common.app.Fragment;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.factory.presenter.function1.Func1Presenter;
import com.zyf.factory.presenter.function1.Function1Contract;
import com.zyf.simplemvp.R;
import com.zyf.simplemvp.fragment.f1_frag.Frag1_Fragment1;
import com.zyf.simplemvp.fragment.f1_frag.Frag1_Fragment2;
import com.zyf.simplemvp.fragment.f1_frag.Frag1_Fragment3;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


public class Fragment1 extends PresenterFragment<Function1Contract.Presenter> implements Function1Contract.View, ViewPager.OnPageChangeListener {


    @BindView(R.id.line_indicator)
    TabIndicator tabIndicator;

    @BindView(R.id.splase_viewpager)
    GlideViewPager viewPager;

    public Fragment1() {

    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        List<Fragment> items = new ArrayList<>();
        items.add(new Frag1_Fragment1());
        items.add(new Frag1_Fragment2());
        items.add(new Frag1_Fragment3());
        List<String> titles = new ArrayList<>();
        titles.add("1-1");
        titles.add("1-2");
        titles.add("1-3");


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
        return R.layout.fragment_fragment1;
    }


    //返回此FragmentPresenter的实体类对象
    @Override
    protected Function1Contract.Presenter initPresenter() {
        return new Func1Presenter(this);
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


    //本页嵌套的Viewpager适配器
    private class MPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> items;

        public MPagerAdapter(FragmentManager fm) {
            this(fm, null);
        }


        MPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.items = list;

        }

        @Override
        public Fragment getItem(int i) {
            return items.get(i);
        }

        @Override
        public int getCount() {
            return items.size();
        }


    }


}
