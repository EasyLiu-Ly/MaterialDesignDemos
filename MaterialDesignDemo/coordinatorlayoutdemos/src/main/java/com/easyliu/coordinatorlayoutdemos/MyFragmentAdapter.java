package com.easyliu.coordinatorlayoutdemos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by EasyLiu on 2016/8/7.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    private int mItemNumbers;

    public MyFragmentAdapter(FragmentManager fm, int itemNumbers) {
        super(fm);
        this.mItemNumbers = itemNumbers;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "tab" + position;
    }

    @Override
    public Fragment getItem(int position) {
        return ItemFragment.newInstance(mItemNumbers);
    }

    @Override
    public int getCount() {
        return 10;
    }
}
