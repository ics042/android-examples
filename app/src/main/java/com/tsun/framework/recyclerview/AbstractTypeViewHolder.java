package com.tsun.framework.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class AbstractTypeViewHolder extends RecyclerView.ViewHolder {
    public AbstractTypeViewHolder(View itemView) {
        super(itemView);
    }
    abstract void bindHolder(DataModel data);
}
