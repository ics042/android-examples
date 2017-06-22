package com.tsun.framework;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.tsun.framework.base.BaseFragment;
import com.tsun.framework.fragment.CommonFragment;
import com.tsun.framework.fragment.CustomizedFragment;
import com.tsun.framework.fragment.OtherFragment;
import com.tsun.framework.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity{

    private RadioGroup rgMain;
    private List<BaseFragment> mBaseFragment;
    private int pos;
    private Fragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFragment();
        // Listener
        setListener();
        rgMain.check(R.id.rb_common_framework);
    }

    private void setListener() {
        rgMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new CommonFragment());
        mBaseFragment.add(new ThirdPartyFragment());
        mBaseFragment.add(new CustomizedFragment());
        mBaseFragment.add(new OtherFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        rgMain = (RadioGroup)findViewById(R.id.rg_main);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_common_framework:
                    pos = 0;
                    break;
                case R.id.rb_third_party:
                    pos = 1;
                    break;
                case R.id.rb_customize:
                    pos = 2;
                    break;
                case R.id.rb_other:
                    pos = 3;
                    break;
                default:
                    pos = 0;
                    break;
            }
            BaseFragment to = getFragment();
            // Replace fragment
            switchFragment(lastFragment, to);
        }
    }

    private void switchFragment(Fragment from, Fragment to) {
        if (from != to && to != null) {
            // Get FragmentManager
            FragmentManager fm = getSupportFragmentManager();
            // Start transaction
            FragmentTransaction  transaction = fm.beginTransaction();
            lastFragment = to;
            if (!to.isAdded()) {
                if (from != null) {
                    transaction.hide(from);
                }
                transaction.add(R.id.fl_content, to).commit();
            } else {
                if (from != null) {
                    transaction.hide(from);
                }
                transaction.show(to).commit();
            }
        }
    }

    private BaseFragment getFragment() {
        return mBaseFragment.get(pos);
    }
}
