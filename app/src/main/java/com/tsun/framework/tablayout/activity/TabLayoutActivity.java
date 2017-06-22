package com.tsun.framework.tablayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tsun.framework.R;
import com.tsun.framework.tablayout.adapter.ViewPagerAdapter;
import com.tsun.framework.tablayout.fragment.TabFragment;

import java.util.ArrayList;

public class TabLayoutActivity extends AppCompatActivity{

    private ViewPager vpTablayout;
    private TextView tvTitle;
    ViewPagerAdapter vpAdapter;
    ArrayList<TabFragment> fragments;
    private TabLayout tlTablayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        vpTablayout = (ViewPager)findViewById(R.id.vp_tablayout);
        tvTitle =(TextView)findViewById(R.id.tv_title_bar);
        tvTitle.setText("Tab Layout");
        tlTablayout = (TabLayout) findViewById(R.id.tl_tablayout);

        fragments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TabFragment tabFragment = new TabFragment();
            tabFragment.setTitle("Title "+i);
            tabFragment.setContent("Content "+i);
            fragments.add(tabFragment);
        }
        vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        vpTablayout.setAdapter(vpAdapter);
        tlTablayout.setupWithViewPager(vpTablayout);
        tlTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
