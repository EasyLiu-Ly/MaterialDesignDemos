package com.easyliu.cardviewdemo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initRecyclerViews();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * init the RecyclerViews
     */
    private void initRecyclerViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // 用于提升性能
        mRecyclerView.setHasFixedSize(true);
        // 设置布局
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //设置适配器
        List<String> myDataset = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            String data = new String();
            data += "data ";
            for (int j = 0; j < i; j++) {
                data += "data ";
            }
            myDataset.add(data);
        }
        mAdapter = new MyAdapter(myDataset);
        mAdapter.setOnListItemClickListener(new IOnListItemClickListener() {
            @Override
            public void onClick(int position) {
                Snackbar.make(MainActivity.this.findViewById(R.id.myCoordinatorLayout), "onClick" + position, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                Snackbar.make(MainActivity.this.findViewById(R.id.myCoordinatorLayout), "onLongClick" + position, Snackbar.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
