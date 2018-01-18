package com.dienmaycholon.dienmaycholonmobi.features.detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.ValueElementProduct;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThongSoItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ValueElementProduct> valueElementProducts;

    ThongSoItemAdapter(Context context) {
        this.context = context;
    }

    public void addList(List<ValueElementProduct> valueElementProducts){
        this.valueElementProducts = valueElementProducts;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (parent.getContext()).inflate(R.layout.detail_tinh_nang_noi_bat_item, parent, false);
        return new ThongsoItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ThongsoItemViewHolder thongsoItemViewHolder = (ThongsoItemViewHolder) holder;
        ValueElementProduct valueElementProduct = valueElementProducts.get(position);

        thongsoItemViewHolder.txtv_title_tinhnang.setText(valueElementProduct.getName());
        thongsoItemViewHolder.txtv_content_tinhnang.setText(valueElementProduct.getVal());
        if (position % 2 != 0){
            thongsoItemViewHolder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorTinhNang));
        }
    }

    @Override
    public int getItemCount() {
        return valueElementProducts.size();
    }

    class ThongsoItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtv_title_tinhnang)        TextView txtv_title_tinhnang;
        @BindView(R.id.txtv_content_tinhnang) TextView txtv_content_tinhnang;
        ThongsoItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
