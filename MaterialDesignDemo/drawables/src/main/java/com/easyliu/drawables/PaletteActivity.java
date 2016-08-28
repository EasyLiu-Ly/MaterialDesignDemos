package com.easyliu.drawables;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;

import java.lang.ref.WeakReference;

public class PaletteActivity extends AppCompatActivity implements TabFragment.OnFragmentInteractionListener {
    TabLayout tabl_demo;
    ViewPager viewPager_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        initViews();
    }

    /**
     * initViews
     */
    private void initViews() {
        tabl_demo = (TabLayout) findViewById(R.id.tal_demo);
        tabl_demo.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabl_demo.setTabTextColors(Color.BLUE, Color.GREEN);
        tabl_demo.setSelectedTabIndicatorColor(Color.GREEN);
        tabl_demo.setSelectedTabIndicatorHeight(16);
        viewPager_demo = (ViewPager) findViewById(R.id.viewPager_demo);
        viewPager_demo.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), 5));
        tabl_demo.setupWithViewPager(viewPager_demo);
        viewPager_demo.setCurrentItem(0);
        colorChange(viewPager_demo.getCurrentItem());
        viewPager_demo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                PaletteActivity.this.colorChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 改变主题的颜色
     *
     * @param position
     */
    private void colorChange(int position) {
        MyFragmentAdapter fragmentAdapter = (MyFragmentAdapter) viewPager_demo.getAdapter();
        WeakReference<Bitmap> bitmapWeakReference= new WeakReference<Bitmap>(BitmapFactory.decodeResource(getResources(), TabFragment.getBackgroundDrawableId(position)));
        Palette.generateAsync(bitmapWeakReference.get(), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch=palette.getVibrantSwatch();
                tabl_demo.setBackgroundColor(swatch.getRgb());
                tabl_demo.setTabTextColors(swatch.getTitleTextColor(),swatch.getTitleTextColor());
                tabl_demo.setSelectedTabIndicatorColor(swatch.getTitleTextColor());
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(swatch.getRgb());
                    getWindow().setNavigationBarColor(swatch.getRgb());
                }
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
