package com.tsun.framework.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tsun.framework.R;

import java.util.ArrayList;
import java.util.List;

public class ComplexRecyclerActivity extends AppCompatActivity {

    private RecyclerView view;
    private ComplexRecyclerAdapter adapter;
    private int colors[] = {android.R.color.background_dark,
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_recycler_main);

        initView();
        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList();

        for (int i = 0; i< 20; i++) {
            int type = (int)((Math.random()*3) + 1);
            DataModel data = new DataModel();
            data.color = colors[type-1];
            data.type = type;
            data.name = "test" + i;
            data.content = "content" + i;
            data.contentColor = colors[(type+1) % 3];
            list.add(data);
        }
        adapter.addList(list);
        adapter.notifyDataSetChanged();
    }

    private void initView() {

        view = (RecyclerView) findViewById(R.id.rv_complex_main);
        view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new ComplexRecyclerAdapter(this);
        view.setAdapter(adapter);
    }
}
