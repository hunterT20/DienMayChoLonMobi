package com.dienmaycholon.dienmaycholonmobi.features.cart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Child> childList;

    CartProductAdapter(Context context) {
        this.context = context;
        childList = new ArrayList<>();
    }

    public void addList(List<Child> childList){
        this.childList.addAll(childList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_product_item, null);
        return new CartProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CartProductViewHolder viewHolder = (CartProductViewHolder) holder;

        viewHolder.imv_minus.setEnabled(false);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class CartProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imv_minus)        ImageView imv_minus;
        CartProductViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
