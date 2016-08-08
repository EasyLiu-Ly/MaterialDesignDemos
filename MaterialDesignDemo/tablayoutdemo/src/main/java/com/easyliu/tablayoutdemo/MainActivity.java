package com.easyliu.tablayoutdemo;

import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.easyliu.tablayoutdemo.fragment.BlankFragment;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    TabLayout tabl_demo;
    ViewPager viewPager_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * initViews
     */
    private void initViews() {
        tabl_demo = (TabLayout) findViewById(R.id.tal_demo);
        tabl_demo.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabl_demo.setTabTextColors(Color.BLUE,Color.GREEN);
        tabl_demo.setSelectedTabIndicatorColor(Color.GREEN);
        tabl_demo.setSelectedTabIndicatorHeight(16);
        viewPager_demo = (ViewPager) findViewById(R.id.viewPager_demo);
        viewPager_demo.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), 10));
        tabl_demo.setupWithViewPager(viewPager_demo);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
