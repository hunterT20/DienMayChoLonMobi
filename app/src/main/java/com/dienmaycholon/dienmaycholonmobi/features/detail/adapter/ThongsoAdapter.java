package com.dienmaycholon.dienmaycholonmobi.features.detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.ElementProduct;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThongsoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ElementProduct> elementProducts;

    public ThongsoAdapter(Context context) {
        this.context = context;
    }

    public void addList(List<ElementProduct> elementProducts){
        this.elementProducts = elementProducts;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (parent.getContext()).inflate(R.layout.detail_thong_so_kt_item, parent, false);
        return new ThongsoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ThongsoViewHolder thongsoViewHolder = (ThongsoViewHolder) holder;
        ElementProduct elementProduct = elementProducts.get(position);

        thongsoViewHolder.txtv_title_thongso_item.setText(elementProduct.getName());
        ThongSoItemAdapter adapter = new ThongSoItemAdapter(context);
        adapter.addList(elementProduct.getValue());

        RecyclerViewUtil.setupRecyclerView(thongsoViewHolder.rcv_data_thongso_item,adapter,context);

        thongsoViewHolder.rcv_data_thongso_item.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return elementProducts.size();
    }

    class ThongsoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtv_title_thongso_item) TextView txtv_title_thongso_item;
        @BindView(R.id.rcv_data_thongso_item) RecyclerView rcv_data_thongso_item;
        ThongsoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
