package com.easyliu.coordinatorlayoutdemos;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easyliu.coordinatorlayoutdemos.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener{
    private TabLayout tabl_demo;
    private ViewPager viewPager_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        initToolbar();
        initViewPager();
        initTabLayout();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initTabLayout() {
        tabl_demo = (TabLayout) findViewById(R.id.tabl_demo);
        tabl_demo.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabl_demo.setupWithViewPager(viewPager_demo);
    }

    private void initViewPager() {
        viewPager_demo = (ViewPager) findViewById(R.id.viewpaegr_demo);
        viewPager_demo.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), 25));
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
