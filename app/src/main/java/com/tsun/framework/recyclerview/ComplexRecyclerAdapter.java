package com.tsun.framework.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tsun.framework.R;

import java.util.ArrayList;
import java.util.List;

public class ComplexRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<DataModel> list = new ArrayList<>();
    private Context context;

    public ComplexRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    public void addList(List<DataModel> l) {
        list.addAll(l);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case DataModel.TYPE_ONE:
                holder = new TypeOneViewHolder(inflater.inflate(R.layout.item_type_1, parent, false));
                break;
            case DataModel.TYPE_TWO:
                holder = new TypeTwoViewHolder(inflater.inflate(R.layout.item_type_2, parent, false));
                break;
            case DataModel.TYPE_THREE:
                holder = new TypeThreeViewHolder(inflater.inflate(R.layout.item_type_3, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AbstractTypeViewHolder)holder).bindHolder(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return this.list.get(position).type;
    }
}
