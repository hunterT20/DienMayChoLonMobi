package com.dienmaycholon.dienmaycholonmobi.features.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Banner;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

public class SliderMainAdapter extends PagerAdapter {
    private List<Banner> banners;
    private Context context;

    SliderMainAdapter(List<Banner> image, Context context) {
        this.banners = image;
        this.context = context;
    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View itemView = layoutInflater.inflate(R.layout.item_slider_main,container,false);

        ImageView imageView = itemView.findViewById(R.id.imgSlider);
        Picasso.with(context).load(banners.get(position).getPhoto())
                .fit()
                .error(R.mipmap.ic_launcher)
                .into(imageView);

        Log.e(TAG, "instantiateItem: " + banners.get(position).getPhoto());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((CardView)object);
    }
}
