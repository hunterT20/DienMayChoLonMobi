package com.dienmaycholon.dienmaycholonmobi.features.product_detail.view;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.features.product_detail.adapter.RecyclerViewDetailAdapter;
import com.dienmaycholon.dienmaycholonmobi.features.product_detail.adapter.SliderDetailPhotoAdapter;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements AppBarLayout.OnOffsetChangedListener{
    @BindView(R.id.vp_product) ViewPager viewPager;
    @BindView(R.id.txtv_title_detail_toolbar)    TextView txtv_title_detail_toolbar;
    @BindView(R.id.toolbar)    Toolbar toolbar;
    @BindView(R.id.main_appbar)    AppBarLayout main_appbar;
    @BindView(R.id.dotsLayout) LinearLayout dotsLayout;
    @BindView(R.id.rcv_detail)    RecyclerView rcv_detail;

    private int[] img;
    private SliderDetailPhotoAdapter sliderDetailPhotoAdapter;
    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;
    private boolean mIsTheTitleVisible = false;
    private TextView[] dots;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        ButterKnife.bind(this,view);
        setHasOptionsMenu(true);

        addViews();
        return view;
    }

    private void addViews() {
        if (getActivity() == null) return;
        ((DetailActivity) getActivity()).setupToolbar(toolbar);
        main_appbar.addOnOffsetChangedListener(this);
        startAlphaAnimation(txtv_title_detail_toolbar, 0, View.INVISIBLE);

        img = new int[]{R.drawable.product, R.drawable.product, R.drawable.product, R.drawable.product};
        sliderDetailPhotoAdapter = new SliderDetailPhotoAdapter(img, getActivity());

        addBottomDots(0);

        viewPager.setAdapter(sliderDetailPhotoAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");

        RecyclerViewUtil.setupRecyclerView(rcv_detail,new RecyclerViewDetailAdapter(list, getActivity()),getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcv_detail.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getActivity(),R.drawable.custom_divider);
        assert drawable != null;
        dividerItemDecoration.setDrawable(drawable);
        rcv_detail.addItemDecoration(dividerItemDecoration);

        RecyclerViewDetailAdapter detailAdapter = new RecyclerViewDetailAdapter(list, getActivity());
        rcv_detail.setAdapter(detailAdapter);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;

        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(txtv_title_detail_toolbar, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }
        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(txtv_title_detail_toolbar, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[img.length];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#666666"));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.colorPrimary));
    }
}
