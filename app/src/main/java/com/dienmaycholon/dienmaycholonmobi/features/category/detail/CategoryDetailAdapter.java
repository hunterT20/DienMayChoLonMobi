package com.dienmaycholon.dienmaycholonmobi.features.category.detail;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CategoryDetail> categoryDetailList;

    public CategoryDetailAdapter(Context context) {
        this.context = context;
    }

    public void addList(List<CategoryDetail> categoryDetails){
        this.categoryDetailList.addAll(categoryDetails);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_tang_layout, null);
        return new CategoryDetailViewModel(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (categoryDetailList == null) return 0;
        return categoryDetailList.size();
    }

    class CategoryDetailViewModel extends RecyclerView.ViewHolder {
        @BindView(R.id.txtvTitleTang)        TextView txtvTitleTang;
        @BindView(R.id.rcvProductIndex) RecyclerView rcvProductIndex;
        @BindView(R.id.dotsLayout)        LinearLayout dotsLayout;
        @BindView(R.id.vp_product)        ViewPager viewPager;
        @BindView(R.id.slider)        RelativeLayout slider;
        CategoryDetailViewModel(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
