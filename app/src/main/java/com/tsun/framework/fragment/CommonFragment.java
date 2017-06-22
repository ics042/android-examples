package com.tsun.framework.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tsun.framework.R;
import com.tsun.framework.bottomtab.BottomTabActivity;
import com.tsun.framework.json.activity.JsonActivity;
import com.tsun.framework.okhttp.activity.OKHttpActivity;
import com.tsun.framework.recyclerview.RecyclerViewActivity;
import com.tsun.framework.slide.activity.SlideActivity;
import com.tsun.framework.tablayout.activity.TabLayoutActivity;
import com.tsun.framework.adapter.CommonFrameworkAdapter;
import com.tsun.framework.base.BaseFragment;

public class CommonFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private ListView lvCommon;
    private String[] data;
    private CommonFrameworkAdapter adapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_common, null);
        lvCommon = (ListView)view.findViewById(R.id.lv_common);
        lvCommon.setOnItemClickListener(this);
        return view;
    }
    protected void initData() {
        super.initData();
        data = new String[]{"OKHttp", "JSON", "Video"};
        adapter = new CommonFrameworkAdapter(mContext, data);
        lvCommon.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String tmp = data[position];
        if (tmp.toLowerCase().equals("okhttp")) {
            Intent intent = new Intent(mContext, OKHttpActivity.class);
            startActivity(intent);
        } else if (tmp.toLowerCase().equals("video")) {
            // String newVideoPath = "http://sv7.onlinevideoconverter.com/download?file=c2j9f5b1c2j9h7b1";
            String newVideoPath = "http://192.168.1.9:8080/士兵突击[01][国语中字][d-vb].rmvb";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(newVideoPath));
            intent.setDataAndType(Uri.parse(newVideoPath), "video/*");
            startActivity(intent);
        } else if (("json").equals(tmp.toLowerCase())) {
            Intent intent = new Intent(mContext, JsonActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(mContext, "data=="+tmp, Toast.LENGTH_SHORT).show();
        }
    }
}
