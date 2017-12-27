package com.dienmaycholon.dienmaycholonmobi.features.index.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.features.product_detail.view.DetailActivity;
import com.dienmaycholon.dienmaycholonmobi.util.NumberTextWatcherForThousand;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

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
        View itemView = mLayoutInflater.inflate(R.layout.item_product_main,parent,false);
        return new ItemSearchViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ItemSearchViewHolder holder, int position) {
        final Child child = listItems.get(position);

        Picasso.with(context).load(child.getImage())
                .resize(150,100)
                .error(R.mipmap.ic_launcher)
                .into(holder.imgItemProduct);

        holder.txtvNameProduct.setText(child.getName());
        holder.txtvPrice.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(child.getSaleprice())) + "đ");
        holder.txtvPriceDel.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(child.getDiscount())) + "đ");
        holder.txtvPriceDel.setPaintFlags(holder.txtvPriceDel.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailActivity.class));
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
        private TextView txtvNameProduct,txtvPrice,txtvPriceDel;
        ItemSearchViewHolder(View itemView) {
            super(itemView);
            txtvNameProduct = itemView.findViewById(R.id.txtvNameProduct);
            txtvPriceDel = itemView.findViewById(R.id.txtvPriceDel);
            txtvPrice = itemView.findViewById(R.id.txtvPrice);
            imgItemProduct = itemView.findViewById(R.id.imgItemProduct);
        }
    }
}
