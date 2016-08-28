package com.easyliu.drawables;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by EasyLiu on 2016/8/27.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    int mTabNumbers;
    ArrayMap<Integer, TabFragment> arrayMap = new ArrayMap<>();

    public MyFragmentAdapter(FragmentManager fm, int tabNumbers) {
        super(fm);
        this.mTabNumbers = tabNumbers;
    }

    @Override
    public int getCount() {
        return mTabNumbers;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab" + position;
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment tabFragment = arrayMap.get(position);
        if (tabFragment == null) {
            tabFragment = TabFragment.newInstance(position);
            arrayMap.put(position, tabFragment);
        }
        return tabFragment;
    }
}
