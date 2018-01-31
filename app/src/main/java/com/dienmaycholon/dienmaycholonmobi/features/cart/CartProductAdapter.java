package com.dienmaycholon.dienmaycholonmobi.features.cart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.util.NumberTextWatcherForThousand;
import com.squareup.picasso.Picasso;

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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CartProductViewHolder viewHolder = (CartProductViewHolder) holder;
        Child child = childList.get(position);

        Picasso.with(context).load(child.getPhoto())
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imv_product_cart);

        viewHolder.txtv_name_product.setText(child.getName());
        viewHolder.txtv_price_product.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(child.getSaleprice())) + "đ");
    }

    @Override
    public int getItemCount() {
        if (childList == null) return 0;
        return childList.size();
    }

    class CartProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imv_minus)        ImageView imv_minus;
        @BindView(R.id.imv_product_cart) ImageView imv_product_cart;
        @BindView(R.id.txtv_name_product) TextView txtv_name_product;
        @BindView(R.id.txtv_price_product) TextView txtv_price_product;
        CartProductViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
