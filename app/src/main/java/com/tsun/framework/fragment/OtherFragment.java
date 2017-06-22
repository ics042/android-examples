package com.tsun.framework.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.tsun.framework.base.BaseFragment;

public class OtherFragment extends BaseFragment {

    private TextView textView;

    @Override
    protected View initView() {
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
    protected void initData() {
        super.initData();
        textView.setText("Other Framework");
    }
}
