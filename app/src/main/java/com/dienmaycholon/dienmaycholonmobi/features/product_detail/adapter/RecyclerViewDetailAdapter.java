package com.dienmaycholon.dienmaycholonmobi.features.product_detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Product;
import com.dienmaycholon.dienmaycholonmobi.data.model.ProductDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ProductDetail productDetail;
    private Context context;

    private static final int TYPE_PRICE = 0;
    private static final int TYPE_MAKE = 1;
    private static final int TYPE_QUATANG = 2;
    private static final int TYPE_KT = 3;
    private static final int TYPE_GIOI_THIEU = 4;
    private static final int TYPE_FOOTER = 9;

    public RecyclerViewDetailAdapter(ProductDetail productDetail, Context context) {
        this.productDetail = productDetail;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_PRICE) {
            View v = LayoutInflater.from (parent.getContext()).inflate(R.layout.detail_price_layout, parent, false);
            return new PriceViewHolder (v);
        }else if (viewType == TYPE_MAKE){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_make_layout, parent, false);
            return new MakeViewHolder(v);
        }else if (viewType == TYPE_QUATANG){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_qua_tang_layout, parent, false);
            return new QuaTangViewHolder(v);
        }else if (viewType == TYPE_KT){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_thong_so_kt_layout, parent, false);
            return new ThongSoViewHolder(v);
        }else if (viewType == TYPE_GIOI_THIEU){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_gioi_thieu_product, parent, false);
            return new GioiThieuViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PriceViewHolder){
            PriceViewHolder priceViewHolder = (PriceViewHolder) holder;
            Product product = productDetail.getProduct();

            priceViewHolder.txtv_price_current.setText(product.getDiscount());
            priceViewHolder.txtv_cost.setText(product.getSaleprice());
            priceViewHolder.txtv_note_price.setText(product.getNoteunderprice());
        }
    }

    @Override
    public int getItemCount() {
        return 5;
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
        }else if (position == 4){
            return TYPE_GIOI_THIEU;
        }
        return 9;
    }

    class PriceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtv_inventory)        TextView txtv_inventory;
        @BindView(R.id.txtv_price_current) TextView txtv_price_current;
        @BindView(R.id.txtv_cost) TextView txtv_cost;
        @BindView(R.id.txtv_note_price) TextView txtv_note_price;
        PriceViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    class MakeViewHolder extends RecyclerView.ViewHolder {
        MakeViewHolder(View view) {
            super(view);
        }
    }

    class QuaTangViewHolder extends RecyclerView.ViewHolder{
        QuaTangViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ThongSoViewHolder extends RecyclerView.ViewHolder {
        ThongSoViewHolder(View v) {
            super(v);
        }
    }

    class GioiThieuViewHolder extends RecyclerView.ViewHolder {
        GioiThieuViewHolder(View v) {
            super(v);
        }
    }
}
