package com.dienmaycholon.dienmaycholonmobi.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.model.ItemIndex;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewHorizontalUtil;

import java.util.List;

public class IndexAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layout;
    private List<ItemIndex> itemList;

    public IndexAdapter(Context context, List<ItemIndex> khoList) {
        this.context = context;
        this.itemList = khoList;
        layout = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layout.inflate(R.layout.item_listmain, null);
            holder = new ViewHolder();
            holder.txtvTitleTang = view.findViewById(R.id.txtvTitleTang);
            holder.rcvProductIndex = view.findViewById(R.id.rcvProductIndex);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ItemIndex itemIndex = itemList.get(i);
        RecyclerViewHorizontalUtil.setupRecyclerView(
                holder.rcvProductIndex,
                new ItemProductAdapter(itemIndex.getProductList(), context),context
        );

        holder.txtvTitleTang.setText(itemIndex.getTitle());
        ItemProductAdapter adapter = new ItemProductAdapter(itemIndex.getProductList(), context);
        holder.rcvProductIndex.setAdapter(adapter);
        return view;
    }

    private static class ViewHolder {
        TextView txtvTitleTang;
        RecyclerView rcvProductIndex;
    }
}
