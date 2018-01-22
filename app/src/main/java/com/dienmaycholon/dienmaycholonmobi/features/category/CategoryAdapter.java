package com.dienmaycholon.dienmaycholonmobi.features.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Category;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryChild;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Category> categoryList;

    CategoryAdapter(Context context) {
        this.context = context;
    }

    public void addList(List<Category> categoryList){
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext ()).inflate (R.layout.category_parent_item, parent, false);
        return new CategoryParentViewHolder (v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CategoryParentViewHolder categoryParentViewHolder = (CategoryParentViewHolder) holder;
        Category category = categoryList.get(position);

        categoryParentViewHolder.txtv_category_title_parent.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        if (categoryList == null) return 0;
        return categoryList.size();
    }

    class CategoryParentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imv_category_parent)        ImageView imv_category_parent;
        @BindView(R.id.txtv_category_title_parent)        TextView txtv_category_title_parent;
        CategoryParentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
