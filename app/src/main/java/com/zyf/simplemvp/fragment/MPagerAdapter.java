package com.zyf.simplemvp.fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.zyf.common.common.app.Fragment;
import java.util.List;

//通用Viewpager适配器
public class MPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> items;

    public MPagerAdapter(FragmentManager fm) {
        this(fm, null);
    }


    public MPagerAdapter(FragmentManager fm, List<Fragment> list) {
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
