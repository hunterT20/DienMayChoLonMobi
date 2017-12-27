package com.dienmaycholon.dienmaycholonmobi.features.index.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dienmaycholon.dienmaycholonmobi.R;

public class SliderMainAdapter extends PagerAdapter {
    private int[] image;
    private LayoutInflater layoutInflater;
    private Context context;

    public SliderMainAdapter(int[] image, Context context) {
        this.image = image;
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View itemView = layoutInflater.inflate(R.layout.item_slider_main,container,false);
        imageView = itemView.findViewById(R.id.imgSlider);
        imageView.setImageResource(image[position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
