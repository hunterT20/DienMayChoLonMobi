package com.dienmaycholon.dienmaycholonmobi.features.category.all;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Category;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryChild;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryParentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Category> categoryList;
    private int positionSelected = 0;

    private CategoryListener categoryListener;

    public void setOnEventListener(CategoryListener listener) {
        categoryListener = listener;
    }

    public interface CategoryListener{
        void onParentItemClick(List<CategoryChild> categoryChildList);
    }

    CategoryParentAdapter(Context context) {
        this.context = context;
        categoryList = new ArrayList<>();
    }

    public void addList(List<Category> categoryList){
        this.categoryList.addAll(categoryList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext ()).inflate (R.layout.category_parent_item, parent, false);
        return new CategoryParentViewHolder (v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final CategoryParentViewHolder categoryParentViewHolder = (CategoryParentViewHolder) holder;
        final Category category = categoryList.get(position);

        categoryParentViewHolder.txtv_category_title_parent.setText(category.getName());

        if (position == positionSelected){
            changeColorItemSelected(categoryParentViewHolder);
        }else {
            resetColorSelected(categoryParentViewHolder);
            categoryParentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    positionSelected = categoryParentViewHolder.getAdapterPosition();
                    categoryListener.onParentItemClick(category.getCategoryChildList());
                    notifyDataSetChanged();
                }
            });
        }
    }

    private void changeColorItemSelected(CategoryParentViewHolder holder){
        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.cardview_light_background));
        holder.txtv_category_title_parent.setTextColor(context.getResources().getColor(R.color.colorAccent));
        holder.imv_category_parent.setColorFilter(context.getResources().getColor(R.color.colorAccent));
    }

    private void resetColorSelected(CategoryParentViewHolder holder){
        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorCategoryParent));
        holder.txtv_category_title_parent.setTextColor(Color.parseColor("#9E9E9E"));
        holder.imv_category_parent.setColorFilter(Color.parseColor("#9E9E9E"));
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
