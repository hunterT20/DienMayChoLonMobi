package com.dienmaycholon.dienmaycholonmobi.features.detail.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.data.model.DetailElement;
import com.dienmaycholon.dienmaycholonmobi.data.model.ElementHot;
import com.dienmaycholon.dienmaycholonmobi.data.model.Product;
import com.dienmaycholon.dienmaycholonmobi.data.model.ProductDetail;
import com.dienmaycholon.dienmaycholonmobi.data.model.PromotionText;
import com.dienmaycholon.dienmaycholonmobi.data.model.Slideshow;
import com.dienmaycholon.dienmaycholonmobi.features.detail.view.DetailActivity;
import com.dienmaycholon.dienmaycholonmobi.features.home.adapter.ItemProductMainAdapter;
import com.dienmaycholon.dienmaycholonmobi.util.NumberTextWatcherForThousand;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ProductDetail productDetail;
    private Context context;
    private FragmentManager fragmentManager;

    private static final int TYPE_PRICE = 0;
    private static final int TYPE_MAKE = 1;
    private static final int TYPE_QUATANG = 2;
    private static final int TYPE_TINHNANG = 3;
    private static final int TYPE_SANPHAM_TUONGTU = 4;
    private static final int TYPE_KT = 5;
    private static final int TYPE_GIOI_THIEU = 6;
    private static final int TYPE_FOOTER = 9;

    public DetailAdapter(ProductDetail productDetail, Context context) {
        this.productDetail = productDetail;
        this.context = context;
    }

    public void setFragmentManager(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
    }

    public void reset(){
        if (productDetail == null) return;
        productDetail = null;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_PRICE) {
            View v = LayoutInflater.from (parent.getContext()).inflate(R.layout.detail_price_layout, parent, false);
            return new PriceViewHolder (v);
        }else if (viewType == TYPE_MAKE){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_make_layout, parent, false);
            return new MakeViewHolder(v);
        }else if (viewType == TYPE_QUATANG){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_qua_tang_layout, parent, false);
            return new QuaTangViewHolder(v);
        }else if (viewType == TYPE_TINHNANG){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_tinh_nang_noi_bat_layout, parent, false);
            return new TinhNangViewHolder(v);
        }else if (viewType == TYPE_SANPHAM_TUONGTU){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_tang_layout, parent, false);
            return new SanPhamTuongTuViewHolder(v);
        }else if (viewType == TYPE_KT){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_thong_so_kt_layout, parent, false);
            return new ThongSoViewHolder(v);
        }else if (viewType == TYPE_GIOI_THIEU){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_gioi_thieu_product, parent, false);
            return new GioiThieuViewHolder(v);
        }
        return null;
    }

    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled"})
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Product product = productDetail.getProduct();
        DetailElement detailElement = productDetail.getDetailElement();
        if (holder instanceof PriceViewHolder){
            PriceViewHolder priceViewHolder = (PriceViewHolder) holder;

            priceViewHolder.txtv_price_current.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(product.getDiscount())) + "đ");
            priceViewHolder.txtv_cost.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(product.getSaleprice())) + "đ");
            priceViewHolder.txtv_cost.setPaintFlags(priceViewHolder.txtv_cost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            priceViewHolder.txtv_note_price.setText(product.getNoteunderprice());
        }else if (holder instanceof MakeViewHolder){
            MakeViewHolder makeViewHolder = (MakeViewHolder) holder;
            makeViewHolder.txtv_thuong_hieu.setText(product.getBrand());
        }else if (holder instanceof QuaTangViewHolder){
            QuaTangViewHolder quaTangViewHolder = (QuaTangViewHolder) holder;
            PromotionText promotionText = detailElement.getPromotionText();
            if (promotionText.getData() == null){
                quaTangViewHolder.csl_quatang.setVisibility(View.GONE);
            }else {
                quaTangViewHolder.txtv_total_quatang.setText(
                        "Tổng trị giá: " +
                        NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(promotionText.getTotal())) + "VNĐ"
                );

                TextView[] content = new TextView[promotionText.getData().size()];

                quaTangViewHolder.lnl_content_quatang.removeAllViews();
                for (int i = 0; i < content.length; i++) {
                    content[i] = new TextView(context);
                    content[i].setText(promotionText.getData().get(i).getName());
                    quaTangViewHolder.lnl_content_quatang.addView(content[i]);
                }
            }
        }else if (holder instanceof TinhNangViewHolder){
            TinhNangViewHolder tinhNangViewHolder = (TinhNangViewHolder) holder;
            List<ElementHot> elementHot = productDetail.getElementHot();
            TinhNangAdapter adapter = new TinhNangAdapter(context, elementHot);

            RecyclerViewUtil.setupRecyclerView(tinhNangViewHolder.rcv_tinhnang, adapter, context);

            tinhNangViewHolder.rcv_tinhnang.setAdapter(adapter);

            tinhNangViewHolder.btn_xemthem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ModalBottomSheet modalBottomSheet = new ModalBottomSheet();
                    modalBottomSheet.addList(productDetail.getElementProduct());
                    modalBottomSheet.show(fragmentManager, modalBottomSheet.getTag());
                }
            });
        }else if (holder instanceof SanPhamTuongTuViewHolder){
            SanPhamTuongTuViewHolder viewHolder = (SanPhamTuongTuViewHolder) holder;
            List<Child> childs = productDetail.getSimilarProduct();
            viewHolder.slider.setVisibility(View.GONE);
            viewHolder.txtvTitleTang.setText("Sản phẩm tương tự");

            RecyclerViewUtil.setupRecyclerViewHorizontal(
                    viewHolder.rcvProductIndex,
                    new ItemProductMainAdapter(childs, context),context
            );

            ItemProductMainAdapter adapter = new ItemProductMainAdapter(childs, context);
            adapter.setHasStableIds(true);
            viewHolder.rcvProductIndex.setAdapter(adapter);
        }else if (holder instanceof GioiThieuViewHolder){
            final GioiThieuViewHolder gioiThieuViewHolder = (GioiThieuViewHolder) holder;
            final List<Slideshow> slideshows = product.getSlideshow();
            SlideShowGioiThieuAdapter adapter = new SlideShowGioiThieuAdapter(context);
            adapter.addList(slideshows);

            addBottomDots(0,slideshows, gioiThieuViewHolder.dotsLayout);

            gioiThieuViewHolder.vp_product.setAdapter(adapter);
            gioiThieuViewHolder.vp_product.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    addBottomDots(position, slideshows, gioiThieuViewHolder.dotsLayout);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            gioiThieuViewHolder.webview_gioithieu.setWebViewClient(new WebViewClient());
            gioiThieuViewHolder.webview_gioithieu.getSettings().setLoadsImagesAutomatically(true);
            gioiThieuViewHolder.webview_gioithieu.getSettings().setJavaScriptEnabled(true);
            gioiThieuViewHolder.webview_gioithieu.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            gioiThieuViewHolder.webview_gioithieu.loadUrl(product.getContent());

        }
    }

    private void addBottomDots(int currentPage, List<Slideshow> slideshows, LinearLayout dotsLayout) {
        TextView[] dots = new TextView[slideshows.size()];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#666666"));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(context.getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return TYPE_PRICE;
        }else if (position == 1){
            return TYPE_MAKE;
        }else if (position == 2){
            return TYPE_QUATANG;
        }else if (position == 3){
            return TYPE_TINHNANG;
        }else if (position == 4){
            return TYPE_SANPHAM_TUONGTU;
        }else if (position == 5){
            return TYPE_GIOI_THIEU;
        }
        return 9;
    }

    class PriceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtv_inventory)        TextView txtv_inventory;
        @BindView(R.id.txtv_price_current) TextView txtv_price_current;
        @BindView(R.id.txtv_cost) TextView txtv_cost;
        @BindView(R.id.txtv_note_price) TextView txtv_note_price;
        PriceViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    class MakeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtv_thuong_hieu) TextView txtv_thuong_hieu;
        MakeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    class QuaTangViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.csl_quatang)        ConstraintLayout csl_quatang;
        @BindView(R.id.txtv_total_quatang) TextView txtv_total_quatang;
        @BindView(R.id.lnl_content_quatang)        LinearLayout lnl_content_quatang;
        QuaTangViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class ThongSoViewHolder extends RecyclerView.ViewHolder {
        ThongSoViewHolder(View v) {
            super(v);
        }
    }

    class GioiThieuViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.vp_product) ViewPager vp_product;
        @BindView(R.id.dotsLayout) LinearLayout dotsLayout;
        @BindView(R.id.webview_gioithieu)        WebView webview_gioithieu;
        GioiThieuViewHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);
        }
    }

    class TinhNangViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rcv_tinhnang) RecyclerView rcv_tinhnang;
        @BindView(R.id.btn_xemthem)        Button btn_xemthem;
        TinhNangViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    class SanPhamTuongTuViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtvTitleTang) TextView txtvTitleTang;
        @BindView(R.id.rcvProductIndex) RecyclerView rcvProductIndex;
        @BindView(R.id.slider)        RelativeLayout slider;
        SanPhamTuongTuViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
