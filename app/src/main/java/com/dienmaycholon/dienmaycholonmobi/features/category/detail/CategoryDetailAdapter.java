package com.dienmaycholon.dienmaycholonmobi.features.category.detail;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryDetailProduct;
import com.dienmaycholon.dienmaycholonmobi.features.home.adapter.ItemProductMainAdapter;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CategoryDetailProduct> categoryDetailProducts;

    CategoryDetailAdapter(Context context) {
        this.context = context;
        categoryDetailProducts = new ArrayList<>();
    }

    public void addList(List<CategoryDetailProduct> categoryDetailProductList){
        this.categoryDetailProducts.addAll(categoryDetailProductList);
        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_tang_layout, null);
        return new CategoryDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CategoryDetailViewHolder viewHolder = (CategoryDetailViewHolder) holder;

        viewHolder.slider.setVisibility(View.GONE);

        CategoryDetailProduct categoryDetailProduct = categoryDetailProducts.get(position);
        Log.e("haha", "onBindViewHolder: " + categoryDetailProducts.size());
        RecyclerViewUtil.setupRecyclerViewHorizontal(
                viewHolder.rcvProductIndex,
                new ItemProductMainAdapter(categoryDetailProduct.getChildren(), context),context
        );

        viewHolder.txtvTitleTang.setText(categoryDetailProduct.getName());
        ItemProductMainAdapter adapter = new ItemProductMainAdapter(categoryDetailProduct.getChildren(), context);
        adapter.setHasStableIds(true);
        viewHolder.rcvProductIndex.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        if (categoryDetailProducts == null) return 0;
        return categoryDetailProducts.size();
    }

    class CategoryDetailViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtvTitleTang)        TextView txtvTitleTang;
        @BindView(R.id.rcvProductIndex) RecyclerView rcvProductIndex;
        @BindView(R.id.dotsLayout)        LinearLayout dotsLayout;
        @BindView(R.id.vp_product)        ViewPager viewPager;
        @BindView(R.id.slider)        RelativeLayout slider;
        CategoryDetailViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
