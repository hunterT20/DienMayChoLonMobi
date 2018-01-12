package com.dienmaycholon.dienmaycholonmobi.features.detail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderDetailPhotoAdapter extends PagerAdapter {
    private List<Photo> list;
    private Context context;

    public SliderDetailPhotoAdapter(Context context) {
        this.context = context;
    }

    public void addList(List<Photo> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public void reset(){
        if (list == null) return;
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View itemView = layoutInflater.inflate(R.layout.item_slider_detail,container,false);
        imageView = itemView.findViewById(R.id.imgSlider);

        Picasso.with(context).load(list.get(position).getNormal())
                .error(R.mipmap.ic_launcher)
                .into(imageView);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
