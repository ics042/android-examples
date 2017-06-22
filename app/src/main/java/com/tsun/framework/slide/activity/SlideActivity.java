package com.tsun.framework.slide.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsun.framework.R;

import java.util.ArrayList;


public class SlideActivity extends AppCompatActivity {

    private ViewPager vpSlide;
    private TextView tvTitle;
    private LinearLayout llIndicator;
    private int prePosition = 0;

    private ArrayList<ImageView> images;
    private final int[] imageIds = {
        R.drawable.coffee1,
        R.drawable.coffee2,
        R.drawable.coffee3,
        R.drawable.coffee4
    };
    private final String[] imageDescriptions = {
            "Hello World",
            "Coffee Time",
            "Good News",
            "Yes I do"
    };
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            vpSlide.setCurrentItem(vpSlide.getCurrentItem()+1);
            handler.sendEmptyMessageDelayed(0, 5000);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_main);
        vpSlide = (ViewPager)findViewById(R.id.vp_slide);
        tvTitle = (TextView) findViewById(R.id.tv_slide_title);
        tvTitle.setText(imageDescriptions[0]);
        llIndicator = (LinearLayout) findViewById(R.id.ll_indicator);
        images = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView ivCoffee = new ImageView(this);
            Log.v("Image", String.valueOf(imageIds[i]));
            ivCoffee.setBackgroundResource(imageIds[i]);
            images.add(ivCoffee);

            // add points
            ImageView ivPoint = new ImageView(this);
            ivPoint.setBackgroundResource(R.drawable.point_selector);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(24, 24);
            if (i == 0) {
                ivPoint.setEnabled(true);
            } else {
                ivPoint.setEnabled(false);
                params.leftMargin = 8;
            }
            ivPoint.setLayoutParams(params);
            llIndicator.addView(ivPoint);
        }
        vpSlide.setAdapter(new MyPageAdapter());
        vpSlide.addOnPageChangeListener(new MyOnPageChangeListener());

        // send message
        handler.sendEmptyMessageDelayed(0, 5000);
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int realPosition = position%images.size();
            tvTitle.setText(imageDescriptions[realPosition]);
            llIndicator.getChildAt(prePosition).setEnabled(false);
            llIndicator.getChildAt(realPosition).setEnabled(true);
            prePosition = realPosition;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_SETTLING) {
                handler.removeCallbacksAndMessages(null);
            } else if (state == ViewPager.SCROLL_STATE_IDLE) {
                handler.removeCallbacksAndMessages(null);
                handler.sendEmptyMessageDelayed(0, 5000);
            }
        }
    }

    class MyPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {

//            return images.size();
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int realPosition = position%images.size();
            ImageView iv = images.get(realPosition);
            iv.setOnTouchListener(new View.OnTouchListener(){

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            handler.removeCallbacksAndMessages(null);
                            break;
                        case MotionEvent.ACTION_MOVE:
                            break;
                        case MotionEvent.ACTION_UP:
                            handler.removeCallbacksAndMessages(null);
                            handler.sendEmptyMessageDelayed(0, 5000);
                            break;
                    }
                    return false;
                }
            });
            if (iv.getParent() != null) {
                ((ViewGroup)iv.getParent()).removeView(iv);
            }
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }
}
