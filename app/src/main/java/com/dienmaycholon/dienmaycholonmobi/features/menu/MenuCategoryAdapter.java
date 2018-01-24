package com.dienmaycholon.dienmaycholonmobi.features.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Category;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Category> categoryList;

    MenuCategoryAdapter(Context context) {
        this.context = context;
        categoryList = new ArrayList<>();
    }

    public void addList(List<Category> categoryList){
        this.categoryList.addAll(categoryList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext ()).inflate (R.layout.menu_category_item, parent, false);
        return new CategoryParentViewHolder (v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CategoryParentViewHolder categoryParentViewHolder = (CategoryParentViewHolder) holder;
        final Category category = categoryList.get(position);

        categoryParentViewHolder.txtv_name_category.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        if (categoryList == null) return 0;
        return categoryList.size();
    }

    class CategoryParentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imv_category)        ImageView imv_category;
        @BindView(R.id.txtv_name_category)        TextView txtv_name_category;
        CategoryParentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
