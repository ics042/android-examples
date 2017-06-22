package com.tsun.framework.recyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tsun.framework.R;

public class TypeOneViewHolder extends AbstractTypeViewHolder{

    public ImageView ivHeader;
    public TextView tvName;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        this.ivHeader = (ImageView) itemView.findViewById(R.id.iv_header);
        this.tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
    }

    public void bindHolder(DataModel data) {
        this.ivHeader.setBackgroundResource(data.color);
        this.tvName.setText(data.name);
    }
}
