package com.tsun.framework.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tsun.framework.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView view;
    private List<String> list = new ArrayList<>();
    private MyRecyclerAdapter adapter;

    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_main);
        initData();
        initView();
        adapter = new MyRecyclerAdapter(this, list);
        view.setAdapter(adapter);
        // set layout manager
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(linearLayoutManager);
        // set item style
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                linearLayoutManager.getOrientation());
        view.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.menu_list:
                view.setLayoutManager(linearLayoutManager);
                break;
            case R.id.menu_grid:
                view.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.menu_horizon_grid:
                view.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.menu_staggered:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        view = (RecyclerView)findViewById(R.id.rv_main);
    }

    private void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            list.add(""+(char)i);
        }
    }
}
