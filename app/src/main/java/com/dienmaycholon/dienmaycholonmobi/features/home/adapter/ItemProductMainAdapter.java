package com.dienmaycholon.dienmaycholonmobi.features.home.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
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

import java.util.List;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

public class ItemProductMainAdapter extends RecyclerView.Adapter<ItemProductMainAdapter.ItemSearchViewHolder> {
    private List<Child> listItems;
    private LayoutInflater mLayoutInflater;
    private Context context;

    ItemProductMainAdapter(List<Child> listItems, Context context) {
        this.listItems = listItems;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ItemSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.home_product_layout, parent, false);
        return new ItemSearchViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ItemSearchViewHolder holder, int position) {
        final Child child = listItems.get(position);

        Picasso.with(context).load(child.getPhoto())
                .error(R.mipmap.ic_launcher)
                .into(holder.imgItemProduct);

        holder.txtvNameProduct.setText(child.getName());
        holder.txtvPrice.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(child.getSaleprice())) + "đ");
        holder.txtvPriceDel.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(child.getDiscount())) + "đ");
        holder.txtvPriceDel.setPaintFlags(holder.txtvPriceDel.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constant.id_detail = child.getIdDetail();
                Intent intent = new Intent(context, DetailActivity.class);
                Pair<View, String> p1 = Pair.create((View) holder.imgItemProduct, ViewCompat.getTransitionName(holder.imgItemProduct));
                Pair<View, String> p2 = Pair.create((View) holder.txtvNameProduct, ViewCompat.getTransitionName(holder.txtvNameProduct));
                ActivityOptionsCompat options = makeSceneTransitionAnimation((Activity) context, p1, p2);
                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ItemSearchViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItemProduct;
        private TextView txtvNameProduct, txtvPrice, txtvPriceDel;

        ItemSearchViewHolder(View itemView) {
            super(itemView);
            txtvNameProduct = itemView.findViewById(R.id.txtvNameProduct);
            txtvPriceDel = itemView.findViewById(R.id.txtvPriceDel);
            txtvPrice = itemView.findViewById(R.id.txtvPrice);
            imgItemProduct = itemView.findViewById(R.id.imgItemProduct);
        }
    }
}
