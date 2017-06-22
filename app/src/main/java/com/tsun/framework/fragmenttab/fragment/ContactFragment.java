package com.tsun.framework.fragmenttab.fragment;

import android.view.View;

import com.tsun.framework.R;
import com.tsun.framework.base.BaseFragment;

public class ContactFragment extends BaseFragment{
    
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.tab2, null);
        return view;
    }
    protected void initData() {
        super.initData();
    }
}
