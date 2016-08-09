package com.easyliu.coordinatorlayoutdemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.easyliu.coordinatorlayoutdemos.CollapsingToolbar.CollapsingDemoActivity;
import com.easyliu.coordinatorlayoutdemos.CoordinatorFloatingActionButton.FloatingActionButtonActivity;
import com.easyliu.coordinatorlayoutdemos.CoordinatorToolbar.CoordinatorToolbarActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.btn_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,FloatingActionButtonActivity.class));
            }
        });

        findViewById(R.id.btn_toorbar).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,CoordinatorToolbarActivity.class));
            }
        });

        findViewById(R.id.btn_collapsingToolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, CollapsingDemoActivity.class));
            }
        });
    }
}
