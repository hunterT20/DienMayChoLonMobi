package com.dienmaycholon.dienmaycholonmobi.features.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterIndexAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> list;
    private Context context;
    private LayoutInflater layoutInflater;

    FilterIndexAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<String> list){
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_filter,parent,false);
        return new FilterIndexAdapter.FilterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FilterViewHolder filterViewHolder = (FilterViewHolder) holder;
        filterViewHolder.txtv_filter.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FilterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtv_filter) TextView txtv_filter;
        FilterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
