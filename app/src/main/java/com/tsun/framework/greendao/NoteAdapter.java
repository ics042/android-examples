package com.tsun.framework.greendao;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ben on 27/06/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class NoteViewHolder extends RecyclerView.ViewHolder  {
    public NoteViewHolder(View itemView) {
        super(itemView);
    }
}
