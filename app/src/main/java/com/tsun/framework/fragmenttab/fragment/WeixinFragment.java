package com.tsun.framework.fragmenttab.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tsun.framework.R;
import com.tsun.framework.adapter.CommonFrameworkAdapter;
import com.tsun.framework.base.BaseFragment;
import com.tsun.framework.recyclerview.ComplexRecyclerActivity;

public class WeixinFragment extends BaseFragment{

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.tab1, null);
        return view;
    }
    protected void initData() {
        super.initData();
    }
}
