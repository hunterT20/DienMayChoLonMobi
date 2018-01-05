package com.dienmaycholon.dienmaycholonmobi.features.index.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.ContainerProduct;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ItemTangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ContainerProduct> listItems;
    private Context context;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    public ItemTangAdapter(List<ContainerProduct> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public void reset(){
        if (listItems.size() == 0) return;
        listItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.header_layout, parent, false);
            return new HeaderViewHolder (v);
        } else if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_listmain, parent, false);
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
            setSlider(headerViewHolder);

        }else if(holder instanceof ItemTangViewHolder) {

            ItemTangViewHolder itemTangViewHolder = (ItemTangViewHolder) holder;
            ContainerProduct containerProduct = listItems.get(position - 1);
            RecyclerViewUtil.setupRecyclerViewHorizontal(
                    itemTangViewHolder.rcvProductIndex,
                    new ItemProductMainAdapter(containerProduct.getChild(), context),context
            );

            itemTangViewHolder.txtvTitleTang.setText(containerProduct.getName());
            ItemProductMainAdapter adapter = new ItemProductMainAdapter(containerProduct.getChild(), context);
            adapter.setHasStableIds(true);
            itemTangViewHolder.rcvProductIndex.setAdapter(adapter);

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

    private void setSlider(final HeaderViewHolder headerViewHolder){
        final int[] currentPage = {0};
        final int numberPage = 0;

        final int[] img =  new int[]{R.drawable.slide_1,R.drawable.slide_2,R.drawable.slide_3,R.drawable.slide_4,R.drawable.slide_5,R.drawable.slide_6,R.drawable.slide_7};
        SliderMainAdapter sliderMainAdapter = new SliderMainAdapter(img, context);

        headerViewHolder.viewPager.setAdapter(sliderMainAdapter);
        headerViewHolder.circleIndicator.setViewPager(headerViewHolder.viewPager);

        headerViewHolder.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage[0] = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int pageCount = img.length;
                    if (currentPage[0] == 0) {
                        headerViewHolder.viewPager.setCurrentItem(pageCount - 1, false);
                    } else if (currentPage[0] == pageCount - 1) {
                        headerViewHolder.viewPager.setCurrentItem(0, false);
                    }
                }
            }
        });

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage[0] == numberPage) {
                    currentPage[0] = 0;
                }
                headerViewHolder.viewPager.setCurrentItem(currentPage[0]++, true);
            }
        };

        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 6000, 2000);
    }

    @Override
    public int getItemCount() {
        return listItems.size() + 1;
    }

    class ItemTangViewHolder extends RecyclerView.ViewHolder {
        TextView txtvTitleTang;
        RecyclerView rcvProductIndex;

        ItemTangViewHolder(View itemView) {
            super(itemView);
            txtvTitleTang = itemView.findViewById(R.id.txtvTitleTang);
            rcvProductIndex = itemView.findViewById(R.id.rcvProductIndex);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        private ViewPager viewPager;
        private CircleIndicator circleIndicator;

        HeaderViewHolder(View itemView) {
            super (itemView);
            this.viewPager = itemView.findViewById (R.id.vp_product);
            this.circleIndicator = itemView.findViewById(R.id.indicator);
        }
    }
}
