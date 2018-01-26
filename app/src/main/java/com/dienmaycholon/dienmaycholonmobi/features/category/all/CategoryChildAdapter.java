package com.dienmaycholon.dienmaycholonmobi.features.category.all;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryChild;
import com.dienmaycholon.dienmaycholonmobi.features.category.detail.CategoryDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CategoryChild> categoryChildList;

    CategoryChildAdapter(Context context) {
        this.context = context;
        categoryChildList = new ArrayList<>();
    }

    public void addList(List<CategoryChild> categoryChildren){
        this.categoryChildList.addAll(categoryChildren);
        notifyDataSetChanged();
    }

    public void clear(){
        if (this.categoryChildList == null) return;
        this.categoryChildList.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext ()).inflate(R.layout.category_child_item,parent,false);
        return new CategoryChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CategoryChildViewHolder viewHolder = (CategoryChildViewHolder) holder;
        final CategoryChild categoryChild = categoryChildList.get(position);

        viewHolder.txtv_title_category_child.setText(categoryChild.getName());
        Picasso.with(context).load(categoryChild.getIcon())
                .fit()
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imv_category_child);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constant.alias = categoryChild.getAlias();
                context.startActivity(new Intent(context, CategoryDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (categoryChildList == null) return 0;
        return categoryChildList.size();
    }

    class CategoryChildViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtv_title_category_child)        TextView txtv_title_category_child;
        @BindView(R.id.imv_category_child)        ImageView imv_category_child;
        CategoryChildViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
