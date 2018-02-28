package com.dienmaycholon.dienmaycholonmobi.features.search.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.features.detail.view.DetailActivity;
import com.dienmaycholon.dienmaycholonmobi.util.NumberTextWatcherForThousand;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

public class ItemProductSearchAdapter extends RecyclerView.Adapter<ItemProductSearchAdapter.ItemSearchViewHolder> {
    private List<Child> listItems;
    private LayoutInflater mLayoutInflater;
    private Context context;

    public ItemProductSearchAdapter(Context context) {
        this.listItems = new ArrayList<>();
        this.mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void addList(List<Child> listItems) {
        if (listItems == null) return;
        this.listItems.addAll(listItems);
        notifyDataSetChanged();
    }

    @Override
    public ItemSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_product_search, parent, false);
        return new ItemSearchViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ItemSearchViewHolder holder, int position) {
        final Child child = listItems.get(position);

        Picasso.with(context).load(child.getPhoto())
                .error(R.mipmap.ic_launcher)
                .into(holder.imgItemProduct);
        holder.txtvNameProduct.setText(child.getName());
        holder.txtvPrice.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(child.getSaleprice())) + "đ");
        holder.txtvPriceDel.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(child.getDiscount())) + "đ");
        holder.txtvPriceDel.setPaintFlags(holder.txtvPriceDel.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.itemView.setOnClickListener(view -> {
            Constant.id_detail = child.getIdDetail();
            Intent intent = new Intent(context, DetailActivity.class);
            Pair<View, String> p1 = Pair.create(holder.imgItemProduct, "image_product");
            Pair<View, String> p2 = Pair.create(holder.txtvNameProduct, "name_product");
            ActivityOptionsCompat options = makeSceneTransitionAnimation((Activity) context, p1, p2);
            context.startActivity(intent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        if (listItems == null) return 0;
        return listItems.size();
    }

    class ItemSearchViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgItemProduct) ImageView imgItemProduct;
        @BindView(R.id.txtvNameProduct) TextView txtvNameProduct;
        @BindView(R.id.txtvPrice) TextView txtvPrice;
        @BindView(R.id.txtvPriceDel) TextView txtvPriceDel;

        ItemSearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
