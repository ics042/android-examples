package com.tsun.framework.fragmenttab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsun.framework.R;
import com.tsun.framework.base.BaseFragment;
import com.tsun.framework.fragmenttab.fragment.ContactFragment;
import com.tsun.framework.fragmenttab.fragment.FriendFragment;
import com.tsun.framework.fragmenttab.fragment.SettingFragment;
import com.tsun.framework.fragmenttab.fragment.WeixinFragment;

import java.util.ArrayList;
import java.util.List;

import static com.tsun.framework.R.id.ll_bottom1;

public class FragmentTabActivity extends FragmentActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_main);
        initView();
        initEvent();
        ivWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
        tvWeiXin.setTextColor(Color.rgb(0, 255, 0));
        pos = 0;
        BaseFragment to = getFragment();
        // Replace fragment
        switchFragment(lastFragment, to);
    }

    private void initEvent() {
        llBottom1.setOnClickListener(this);
        llBottom2.setOnClickListener(this);
        llBottom3.setOnClickListener(this);
        llBottom4.setOnClickListener(this);
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

        list.add(new WeixinFragment());
        list.add(new ContactFragment());
        list.add(new FriendFragment());
        list.add(new SettingFragment());
    }

    @Override
    public void onClick(View v) {
        resetImage();
        switch (v.getId()) {
            case ll_bottom1:
                ivWeiXin.setImageResource(R.drawable.tab_weixin_pressed);
                tvWeiXin.setTextColor(Color.rgb(0, 255, 0));
                pos = 0;
                break;
            case R.id.ll_bottom2:
                ivContact.setImageResource(R.drawable.tab_contact_pressed);
                tvContact.setTextColor(Color.rgb(0, 255, 0));
                pos = 1;
                break;
            case R.id.ll_bottom3:
                ivFriend.setImageResource(R.drawable.tab_friend_pressed);
                tvFriend.setTextColor(Color.rgb(0, 255, 0));
                pos = 2;
                break;
            case R.id.ll_bottom4:
                ivSetting.setImageResource(R.drawable.tab_settings_pressed);
                tvSetting.setTextColor(Color.rgb(0, 255, 0));
                pos = 3;
                break;
        }
        BaseFragment to = getFragment();
        // Replace fragment
        switchFragment(lastFragment, to);
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
    private void switchFragment(Fragment from, Fragment to) {
        if (from != to && to != null) {
            // Get FragmentManager
            FragmentManager fm = getSupportFragmentManager();
            // Start transaction
            FragmentTransaction transaction = fm.beginTransaction();
            lastFragment = to;
            if (!to.isAdded()) {
                if (from != null) {
                    transaction.hide(from);
                }
                transaction.add(R.id.fl_tab_main, to).commit();
            } else {
                if (from != null) {
                    transaction.hide(from);
                }
                transaction.show(to).commit();
            }
        }
    }
    private BaseFragment getFragment() {
        return list.get(pos);
    }
}

