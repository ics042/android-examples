package com.tsun.framework.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CommonFrameworkAdapter extends BaseAdapter {

    private Context context;
    private String[] data;
    public CommonFrameworkAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setPadding(50, 50, 0, 50);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);
        textView.setText(data[position]);
        return textView;
    }
}
