package com.easyliu.tablayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.easyliu.tablayoutdemo.fragment.BlankFragment;

/**
 * Created by EasyLiu on 2016/8/7.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    private int mTabNumbers;

    public MyFragmentAdapter(FragmentManager fm, int tabNumbers) {
        super(fm);
        this.mTabNumbers = tabNumbers;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "tab" + position;
    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance("tab" + position);
    }

    @Override
    public int getCount() {
        return mTabNumbers;
    }
}
