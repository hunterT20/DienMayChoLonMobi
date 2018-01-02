package com.dienmaycholon.dienmaycholonmobi.features.product_detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dienmaycholon.dienmaycholonmobi.R;

import java.util.List;

public class RecyclerViewDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> listItems;
    private Context context;

    private static final int TYPE_PRICE = 0;
    private static final int TYPE_MAKE = 1;
    private static final int TYPE_QUATANG = 2;
    private static final int TYPE_KT = 3;
    private static final int TYPE_FOOTER = 9;

    public RecyclerViewDetailAdapter(List<String> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_PRICE) {
            View v = LayoutInflater.from (parent.getContext()).inflate(R.layout.detail_price_layout, parent, false);
            return new HeaderViewHolder (v);
        }else if (viewType == TYPE_MAKE){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_make_layout, parent, false);
            return new MakeViewHolder(v);
        }else if (viewType == TYPE_QUATANG){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_qua_tang_layout, parent, false);
            return new QuaTangViewHolder(v);
        }else if (viewType == TYPE_KT){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_thong_so_kt_layout, parent, false);
            return new ThongSoViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return TYPE_PRICE;
        }else if (position == 1){
            return TYPE_MAKE;
        }else if (position == 2){
            return TYPE_QUATANG;
        }else if (position == 3){
            return TYPE_KT;
        }
        return 9;
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        HeaderViewHolder(View view) {
            super(view);
        }
    }

    private class MakeViewHolder extends RecyclerView.ViewHolder {
        MakeViewHolder(View view) {
            super(view);
        }
    }

    private class QuaTangViewHolder extends RecyclerView.ViewHolder{
        QuaTangViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class ThongSoViewHolder extends RecyclerView.ViewHolder {
        ThongSoViewHolder(View v) {
            super(v);
        }
    }
}
