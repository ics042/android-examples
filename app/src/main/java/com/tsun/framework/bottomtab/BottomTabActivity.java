package com.tsun.framework.bottomtab;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsun.framework.R;

import java.util.ArrayList;
import java.util.List;

public class BottomTabActivity extends Activity implements View.OnClickListener {

    private LinearLayout llBottom1;
    private LinearLayout llBottom2;
    private LinearLayout llBottom3;
    private LinearLayout llBottom4;
    private ImageView ivWeiXin;
    private ImageView ivContact;
    private ImageView ivFriend;
    private ImageView ivSetting;
    private TextView tvWeiXin;
    private TextView tvContact;
    private TextView tvFriend;
    private TextView tvSetting;


    private ViewPager viewPager;
    private PagerAdapter adapter;
    private List<View> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_tab_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        llBottom1.setOnClickListener(this);
        llBottom2.setOnClickListener(this);
        llBottom3.setOnClickListener(this);
        llBottom4.setOnClickListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetImage();
                switch (position) {
                    case 0:
                        ivWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
                        tvWeiXin.setTextColor(Color.rgb(0, 255, 0));
                        break;
                    case 1:
                        ivContact.setImageResource(R.drawable.tab_contact_pressed);
                        tvContact.setTextColor(Color.rgb(0, 255, 0));
                        break;
                    case 2:
                        ivFriend.setImageResource(R.drawable.tab_friend_pressed);
                        tvFriend.setTextColor(Color.rgb(0, 255, 0));
                        break;
                    case 3:
                        ivSetting.setImageResource(R.drawable.tab_settings_pressed);
                        tvSetting.setTextColor(Color.rgb(0, 255, 0));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        llBottom1 = (LinearLayout)findViewById(R.id.ll_bottom1);
        llBottom2 = (LinearLayout)findViewById(R.id.ll_bottom2);
        llBottom3 = (LinearLayout)findViewById(R.id.ll_bottom3);
        llBottom4 = (LinearLayout)findViewById(R.id.ll_bottom4);

        ivWeiXin = (ImageView)findViewById(R.id.iv_weixin);
        ivContact = (ImageView)findViewById(R.id.iv_contact);
        ivFriend = (ImageView)findViewById(R.id.iv_friend);
        ivSetting = (ImageView)findViewById(R.id.iv_setting);

        tvWeiXin = (TextView)findViewById(R.id.tv_weixin);
        tvContact = (TextView)findViewById(R.id.tv_contact);
        tvFriend = (TextView)findViewById(R.id.tv_friend);
        tvSetting = (TextView)findViewById(R.id.tv_setting);
        viewPager = (ViewPager)findViewById(R.id.vp_tab_main);
        LayoutInflater inflater = LayoutInflater.from(this);
        View tab1 = inflater.inflate(R.layout.tab1, null);
        View tab2 = inflater.inflate(R.layout.tab2, null);
        View tab3 = inflater.inflate(R.layout.tab3, null);
        View tab4 = inflater.inflate(R.layout.tab4, null);
        list.add(tab1);
        list.add(tab2);
        list.add(tab3);
        list.add(tab4);

        adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));;
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = list.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        resetImage();
        switch (v.getId()) {
            case R.id.ll_bottom1:
                ivWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
                tvWeiXin.setTextColor(Color.rgb(0, 255, 0));
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_bottom2:
                ivContact.setImageResource(R.drawable.tab_contact_pressed);
                tvContact.setTextColor(Color.rgb(0, 255, 0));
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_bottom3:
                ivFriend.setImageResource(R.drawable.tab_friend_pressed);
                tvFriend.setTextColor(Color.rgb(0, 255, 0));
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_bottom4:
                ivSetting.setImageResource(R.drawable.tab_settings_pressed);
                tvSetting.setTextColor(Color.rgb(0, 255, 0));
                viewPager.setCurrentItem(3);
                break;
        }
    }

    private void resetImage() {
        ivWeiXin.setImageResource(R.drawable.tab_weixin_normal);
        ivContact.setImageResource(R.drawable.tab_contact_normal);
        ivFriend.setImageResource(R.drawable.tab_friend_normal);
        ivSetting.setImageResource(R.drawable.tab_settings_normal);

        tvWeiXin.setTextColor(Color.rgb(204, 204, 204));
        tvContact.setTextColor(Color.rgb(204, 204, 204));
        tvFriend.setTextColor(Color.rgb(204, 204, 204));
        tvSetting.setTextColor(Color.rgb(204, 204, 204));
    }
}
