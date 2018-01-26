package com.dienmaycholon.dienmaycholonmobi.features.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.Banner;
import com.dienmaycholon.dienmaycholonmobi.data.model.ContainerProduct;
import com.dienmaycholon.dienmaycholonmobi.features.category.all.CategoryActivity;
import com.dienmaycholon.dienmaycholonmobi.features.category.detail.CategoryDetailActivity;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class ItemTangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ContainerProduct> listItems;
    private List<Banner> bannerList;
    private Context context;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    public ItemTangAdapter(Context context) {
        this.context = context;
    }

    public void addListProduct(List<ContainerProduct> listItems){
        this.listItems = listItems;
        notifyDataSetChanged();
    }

    public void addListBanner(List<Banner> list){
        this.bannerList = list;
        notifyDataSetChanged();
    }

    public void reset(){
        if (listItems == null) return;
        listItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.home_header_layout, parent, false);
            return new HeaderViewHolder (v);
        } else if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.home_tang_layout, parent, false);
            return new ItemTangViewHolder (v);
        } else if(viewType == TYPE_FOOTER) {
            /*View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.list_item, parent, false);
            return new ItemTangViewHolder (v);*/
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderViewHolder) {

            final HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            setSliderHeader(headerViewHolder);
            FilterIndexAdapter filterIndexAdapter = new FilterIndexAdapter(context);

            List<String> list_filter = new ArrayList<>();
            list_filter.add("Tin khuyến mãi");
            list_filter.add("Mua trả góp");
            list_filter.add("Thẻ thành viên");

            RecyclerViewUtil.setupRecyclerViewHorizontal(headerViewHolder.rcv_filter_index,filterIndexAdapter,context);
            filterIndexAdapter.addList(list_filter);

            headerViewHolder.rcv_filter_index.setAdapter(filterIndexAdapter);

        }else if(holder instanceof ItemTangViewHolder) {

            ItemTangViewHolder itemTangViewHolder = (ItemTangViewHolder) holder;

            List<Banner> banners = listItems.get(position - 1).getBanner();
            if (banners.size() != 0){
                setSliderTang(itemTangViewHolder, banners);
            }else {
                itemTangViewHolder.slider.setVisibility(View.GONE);
            }

            final ContainerProduct containerProduct = listItems.get(position - 1);
            RecyclerViewUtil.setupRecyclerViewHorizontal(
                    itemTangViewHolder.rcvProductIndex,
                    new ItemProductMainAdapter(containerProduct.getChild(), context),context
            );

            itemTangViewHolder.txtvTitleTang.setText(containerProduct.getName());
            ItemProductMainAdapter adapter = new ItemProductMainAdapter(containerProduct.getChild(), context);
            adapter.setHasStableIds(true);
            itemTangViewHolder.rcvProductIndex.setAdapter(adapter);

            itemTangViewHolder.txtv_xem_them.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Constant.alias = containerProduct.getAlias();
                    context.startActivity(new Intent(context, CategoryDetailActivity.class));
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader (position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private boolean isPositionHeader (int position) {
        return position == 0;
    }

    private boolean isPositionFooter (int position) {
        return position == listItems.size () + 1;
    }

    private void setSliderHeader(final HeaderViewHolder headerViewHolder){
        SliderMainAdapter sliderMainAdapter = new SliderMainAdapter(bannerList, context);

        headerViewHolder.viewPager.setAdapter(sliderMainAdapter);
        headerViewHolder.circleIndicator.setViewPager(headerViewHolder.viewPager);
        headerViewHolder.viewPager.setPageMargin((int) (context.getResources().getDisplayMetrics().widthPixels * -0.26));
        headerViewHolder.viewPager.setOffscreenPageLimit(5);
        headerViewHolder.viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override public void transformPage(@NonNull View page, float position) {
                page.setScaleX(0.85f - Math.abs(position * 0.4f));
                page.setScaleY(0.95f - Math.abs(position * 0.6f));
                page.setAlpha(1.0f - Math.abs(position * 0.5f));
            }
        });
    }

    private void setSliderTang(final ItemTangViewHolder holder, final List<Banner> banners){
        SliderMainAdapter sliderMainAdapter = new SliderMainAdapter(banners,context);
        addBottomDots(0, holder, banners);

        holder.viewPager.setAdapter(sliderMainAdapter);
        holder.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position, holder, banners);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (listItems == null) return 0;
        return listItems.size() + 1;
    }

    private void addBottomDots(int currentPage, ItemTangViewHolder holder, List<Banner> banners) {
        TextView[] dots = new TextView[banners.size()];

        holder.dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#666666"));
            holder.dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(context.getResources().getColor(R.color.cardview_light_background));
    }

    class ItemTangViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtvTitleTang) TextView txtvTitleTang;
        @BindView(R.id.txtv_xem_them) TextView txtv_xem_them;
        @BindView(R.id.rcvProductIndex) RecyclerView rcvProductIndex;
        @BindView(R.id.dotsLayout)        LinearLayout dotsLayout;
        @BindView(R.id.vp_product) ViewPager viewPager;
        @BindView(R.id.slider)        RelativeLayout slider;

        ItemTangViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.vp_product) ViewPager viewPager;
        @BindView(R.id.indicator) CircleIndicator circleIndicator;
        @BindView(R.id.rcv_filter_index) RecyclerView rcv_filter_index;

        HeaderViewHolder(View itemView) {
            super (itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
