package com.easyliu.coordinatorlayoutdemos.CollapsingToolbar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.easyliu.coordinatorlayoutdemos.R;

import java.util.ArrayList;
import java.util.List;

public class CollapsingDemoActivity extends AppCompatActivity {
    private RecyclerView rcv_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_demo);
        initToolbar();
        initViews();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_demo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(CollapsingDemoActivity.this.findViewById(R.id.coordinator2), "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
            }
        });
    }

    private void initViews() {
        rcv_demo = (RecyclerView) findViewById(R.id.rcv_demo);
        rcv_demo.setLayoutManager(new LinearLayoutManager(this));
        List<String> values = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            values.add("value" + i);
        }
        rcv_demo.setAdapter(new MyRecyclerViewAdapter(values));
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
