package com.dienmaycholon.dienmaycholonmobi.features.detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.ElementHot;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TinhNangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ElementHot> list;
    private Context context;

    TinhNangAdapter(Context context, List<ElementHot> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (parent.getContext()).inflate(R.layout.detail_tinh_nang_noi_bat_item, parent, false);
        return new TinhNangViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TinhNangViewHolder tinhNangViewHolder = (TinhNangViewHolder) holder;
        ElementHot elementHot = list.get(position);

        tinhNangViewHolder.txtv_title_tinhnang.setText(elementHot.getName());
        tinhNangViewHolder.txtv_content_tinhnang.setText(elementHot.getVal());
        if (position % 2 != 0){
            tinhNangViewHolder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorTinhNang));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TinhNangViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtv_title_tinhnang)        TextView txtv_title_tinhnang;
        @BindView(R.id.txtv_content_tinhnang) TextView txtv_content_tinhnang;
        TinhNangViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
