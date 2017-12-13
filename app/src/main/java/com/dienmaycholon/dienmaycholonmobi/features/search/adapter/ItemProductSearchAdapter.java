package com.dienmaycholon.dienmaycholonmobi.features.search.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Product;
import com.dienmaycholon.dienmaycholonmobi.util.NumberTextWatcherForThousand;

import java.util.List;

public class ItemProductSearchAdapter extends RecyclerView.Adapter<ItemProductSearchAdapter.ItemSearchViewHolder> {
    private List<Product> listItems;
    private LayoutInflater mLayoutInflater;
    private Context context;

    public ItemProductSearchAdapter(List<Product> listItems, Context context) {
        this.listItems = listItems;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ItemSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_product_search,parent,false);
        return new ItemSearchViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ItemSearchViewHolder holder, int position) {
        final Product pro = listItems.get(position);

        holder.txtvNameProduct.setText(pro.getName());
        holder.txtvPrice.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(pro.getPrice())) + "đ");
        holder.txtvPriceDel.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(pro.getPriceDel())) + "đ");
        holder.txtvPriceDel.setPaintFlags(holder.txtvPriceDel.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
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
