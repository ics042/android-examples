package com.tsun.framework.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tsun.framework.R;
import com.tsun.framework.adapter.CommonFrameworkAdapter;
import com.tsun.framework.base.BaseFragment;
import com.tsun.framework.bottomtab.BottomTabActivity;
import com.tsun.framework.fragmentpagertab.FragmentPagerTabActivity;
import com.tsun.framework.fragmenttab.FragmentTabActivity;
import com.tsun.framework.json.activity.JsonActivity;
import com.tsun.framework.okhttp.activity.OKHttpActivity;
import com.tsun.framework.recyclerview.ComplexRecyclerActivity;
import com.tsun.framework.recyclerview.ComplexRecyclerAdapter;
import com.tsun.framework.recyclerview.RecyclerViewActivity;
import com.tsun.framework.slide.activity.SlideActivity;
import com.tsun.framework.tablayout.activity.TabLayoutActivity;

public class CustomizedFragment extends BaseFragment implements AdapterView.OnItemClickListener{

    private ListView lvCustomized;
    private String[] data;
    private CommonFrameworkAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_customized, null);
        lvCustomized = (ListView)view.findViewById(R.id.lv_customized);
        lvCustomized.setOnItemClickListener(this);
        return view;
    }
    protected void initData() {
        super.initData();
        data = new String[]{"RecyclerView", "ComplexRecycler", "FragmentTab", "FragmentPagerTab",
                "ViewPagerTab", "Tablayout", "Slide"};
        adapter = new CommonFrameworkAdapter(mContext, data);
        lvCustomized.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String tmp = data[position];
        if ("complexrecycler".equals(tmp.toLowerCase())) {
            Intent intent = new Intent(mContext, ComplexRecyclerActivity.class);
            startActivity(intent);
        } else if ("fragmenttab".equals(tmp.toLowerCase())) {
            Intent intent = new Intent(mContext, FragmentTabActivity.class);
            startActivity(intent);
        }  else if (("tablayout").equals(tmp.toLowerCase())) {
            Intent intent = new Intent(mContext, TabLayoutActivity.class);
            startActivity(intent);
        } else if (("slide").equals(tmp.toLowerCase())) {
            Intent intent = new Intent(mContext, SlideActivity.class);
            startActivity(intent);
        } else if (("viewpagertab").equals(tmp.toLowerCase())) {
            Intent intent = new Intent(mContext, BottomTabActivity.class);
            startActivity(intent);
        } else if (("recyclerview").equals(tmp.toLowerCase())) {
            Intent intent = new Intent(mContext, RecyclerViewActivity.class);
            startActivity(intent);
        } else if (("fragmentpagertab").equals(tmp.toLowerCase())) {
            Intent intent = new Intent(mContext, FragmentPagerTabActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(mContext, "data=="+tmp, Toast.LENGTH_SHORT).show();
        }
    }
}
