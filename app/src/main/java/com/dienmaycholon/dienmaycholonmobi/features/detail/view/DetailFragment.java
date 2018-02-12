package com.dienmaycholon.dienmaycholonmobi.features.detail.view;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.Photo;
import com.dienmaycholon.dienmaycholonmobi.data.model.ProductDetail;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiService;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.dienmaycholon.dienmaycholonmobi.features.detail.adapter.DetailAdapter;
import com.dienmaycholon.dienmaycholonmobi.features.error.ErrorFragment;
import com.dienmaycholon.dienmaycholonmobi.features.detail.adapter.SliderDetailPhotoAdapter;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

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
    @BindView(R.id.txtv_product_name) TextView txtv_product_name;
    @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.btnBackSub)    ImageView btnBackSub;

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;
    private boolean mIsTheTitleVisible = false;
    private ApiService apiService;
    private List<Photo> photoList;
    private ProductDetail productDetail;
    private DetailAdapter detailAdapter;

    public DetailFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        ButterKnife.bind(this,view);
        setHasOptionsMenu(true);

        apiService = ApiUtils.getAPIservices();
        addViews();
        return view;
    }

    private void addViews() {
        if (getActivity() == null) return;
        ((DetailActivity) getActivity()).setupToolbar(toolbar);
        main_appbar.addOnOffsetChangedListener(this);
        startAlphaAnimation(txtv_title_detail_toolbar, 0, View.INVISIBLE);
        ((DetailActivity)getActivity()).getButtonCart().setVisibility(View.GONE);

        getProductDetail(Constant.id_detail, Constant.Token);
    }

    private void getProductDetail(String IDdetail, String Token){
        swipeRefresh.setRefreshing(true);
        Observable<ApiResult<ProductDetail, Integer>> getProductDetail = apiService.getProductDetail(IDdetail, Token);
        getProductDetail.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResult<ProductDetail, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiResult<ProductDetail, Integer> productDetailApiResult) {
                        productDetail = productDetailApiResult.getData();

                        txtv_product_name.setText(productDetail.getProduct().getName());
                        txtv_title_detail_toolbar.setText(productDetail.getProduct().getName());

                        photoList = productDetail.getProduct().getPhoto();
                        SliderDetailPhotoAdapter sliderDetailPhotoAdapter = new SliderDetailPhotoAdapter(getActivity());
                        sliderDetailPhotoAdapter.addList(photoList);

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

                        RecyclerViewUtil.setupRecyclerView(rcv_detail,new DetailAdapter(productDetail, getActivity()),getActivity());
                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcv_detail.getContext(),DividerItemDecoration.VERTICAL);
                        assert getActivity() != null;
                        Drawable drawable = ContextCompat.getDrawable(getActivity(),R.drawable.custom_divider);
                        assert drawable != null;
                        dividerItemDecoration.setDrawable(drawable);
                        rcv_detail.addItemDecoration(dividerItemDecoration);

                        detailAdapter = new DetailAdapter(productDetail, getActivity());
                        detailAdapter.setFragmentManager(getActivity().getSupportFragmentManager());
                        rcv_detail.setAdapter(detailAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefresh.setRefreshing(false);
                        swipeRefresh.setEnabled(false);
                        Log.e(TAG, "onError: " + e.getMessage());
                        assert getActivity() != null;
                        ((DetailActivity)getActivity()).callFragment(new ErrorFragment());
                    }

                    @Override
                    public void onComplete() {
                        swipeRefresh.setRefreshing(false);
                        swipeRefresh.setEnabled(false);
                        assert getActivity() != null;
                        ((DetailActivity)getActivity()).getButtonCart().setVisibility(View.VISIBLE);
                    }
                });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        assert getActivity() != null;
        getActivity().getMenuInflater().inflate(R.menu.toolbar_menu, menu);
    }

    @OnClick(R.id.btnBackSub)
    public void onBackStackClick(){
        assert getActivity() != null;
        getActivity().onBackPressed();
        getActivity().supportFinishAfterTransition();
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;

        handleToolbarTitleVisibility(percentage);
    }

    /**
     * Xử lý ẩn/hiện toolbar_with_back: nếu percentage > percentage_show thì show, ngược lại thì ẩn
     * @param percentage: phần trăm cuộn của appBarLayout (Tính được trong function onOffsetChanged)
     */
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

    /**
     * add dot view vào trong viewpager
     * @param currentPage: viewpager hiện tại
     */
    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[photoList.size()];

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
