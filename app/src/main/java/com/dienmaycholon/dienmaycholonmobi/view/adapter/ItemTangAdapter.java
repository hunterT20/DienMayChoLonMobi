package com.dienmaycholon.dienmaycholonmobi.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.model.ItemIndex;
import com.dienmaycholon.dienmaycholonmobi.model.Product;
import com.dienmaycholon.dienmaycholonmobi.util.NumberTextWatcherForThousand;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewHorizontalUtil;

import java.util.List;

/**
 * Created by Nusib on 9/29/2017.
 */

public class ItemTangAdapter extends RecyclerView.Adapter<ItemTangAdapter.ItemTangViewHolder> {
    private List<ItemIndex> listItems;
    private LayoutInflater mLayoutInflater;
    private Context context;

    public ItemTangAdapter(List<ItemIndex> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemTangAdapter.ItemTangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_listmain,parent,false);
        return new ItemTangViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemTangViewHolder holder, int position) {
        ItemIndex itemIndex = listItems.get(position);
        RecyclerViewHorizontalUtil.setupRecyclerView(
                holder.rcvProductIndex,
                new ItemProductAdapter(itemIndex.getProductList(), context),context
        );

        holder.txtvTitleTang.setText(itemIndex.getTitle());
        ItemProductAdapter adapter = new ItemProductAdapter(itemIndex.getProductList(), context);
        holder.rcvProductIndex.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ItemTangViewHolder extends RecyclerView.ViewHolder {
        TextView txtvTitleTang;
        RecyclerView rcvProductIndex;
        public ItemTangViewHolder(View itemView) {
            super(itemView);
            txtvTitleTang = itemView.findViewById(R.id.txtvTitleTang);
            rcvProductIndex = itemView.findViewById(R.id.rcvProductIndex);
        }
    }
}
