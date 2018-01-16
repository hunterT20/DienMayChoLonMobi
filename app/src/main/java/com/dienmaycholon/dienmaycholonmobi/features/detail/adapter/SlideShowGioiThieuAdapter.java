package com.dienmaycholon.dienmaycholonmobi.features.detail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Photo;
import com.dienmaycholon.dienmaycholonmobi.data.model.Slideshow;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SlideShowGioiThieuAdapter extends PagerAdapter {
    private List<Slideshow> list;
    private Context context;

    public SlideShowGioiThieuAdapter(Context context) {
        this.context = context;
    }

    public void addList(List<Slideshow> list){
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View itemView = layoutInflater.inflate(R.layout.item_slider_gioithieu_product,container,false);
        ImageView imageView = itemView.findViewById(R.id.imgSlider);
        TextView txtv_title_gioithieu = itemView.findViewById(R.id.txtv_title_gioithieu);
        TextView txtv_content_gioithieu = itemView.findViewById(R.id.txtv_content_gioithieu);

        Slideshow slideshow = list.get(position);

        Picasso.with(context).load(slideshow.getPhoto())
                .error(R.mipmap.ic_launcher)
                .into(imageView);
        txtv_title_gioithieu.setText(slideshow.getTitle());
        txtv_content_gioithieu.setText(slideshow.getDes());

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
