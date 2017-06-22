package com.tsun.framework.fragmentpagertab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsun.framework.R;
import com.tsun.framework.base.BaseFragment;
import com.tsun.framework.fragmentpagertab.fragment.ContactFragment;
import com.tsun.framework.fragmentpagertab.fragment.FriendFragment;
import com.tsun.framework.fragmentpagertab.fragment.SettingFragment;
import com.tsun.framework.fragmentpagertab.fragment.WeixinFragment;

import java.util.ArrayList;
import java.util.List;

import static com.tsun.framework.R.id.list_item;
import static com.tsun.framework.R.id.ll_bottom1;

public class FragmentPagerTabActivity extends FragmentActivity implements View.OnClickListener {

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

    private List<BaseFragment> list = new ArrayList<>();
    private int pos;
    private Fragment lastFragment;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager_tab_main);
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
        llBottom1 = (LinearLayout)findViewById(ll_bottom1);
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

        viewPager = (ViewPager)findViewById(R.id.vp_fragment_pager_tab_main);

        list.add(new WeixinFragment());
        list.add(new ContactFragment());
        list.add(new FriendFragment());
        list.add(new SettingFragment());

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        };
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        resetImage();
        switch (v.getId()) {
            case ll_bottom1:
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

