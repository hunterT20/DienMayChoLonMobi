package com.dienmaycholon.dienmaycholonmobi.features.home.view;


import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiListResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.Banner;
import com.dienmaycholon.dienmaycholonmobi.data.model.ContainerProduct;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;
import com.dienmaycholon.dienmaycholonmobi.features.home.adapter.ItemTangAdapter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.lvIndex) RecyclerView lvIndex;
    @BindView(R.id.swipeRefresh)    SwipeRefreshLayout swipeRefreshLayout;

    private ItemTangAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this,view);

        //printKeyHash(getActivity());
        addViews();
        addControls();
        return view;
    }

    private void addControls() {

    }

    private void addViews() {
        lvIndex.setHasFixedSize(true);
        lvIndex.setItemViewCacheSize(20);
        lvIndex.setDrawingCacheEnabled(true);
        lvIndex.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        swipeRefreshLayout.setOnRefreshListener(this);

        adapter = new ItemTangAdapter(getActivity());
        adapter.setHasStableIds(true);
        RecyclerViewUtil.setupRecyclerView(lvIndex, adapter,getActivity());

        getBannerHome(Constant.Token);
    }

    private void getBannerHome(final String Token){
        swipeRefreshLayout.setRefreshing(true);
        Observable<ApiListResult<Banner>> getBannerHome = ApiUtils.getAPIservices().getBannerHome(Token);
        getBannerHome.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiListResult<Banner>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiListResult<Banner> bannerApiListResult) {
                        List<Banner> bannerList = bannerApiListResult.getData();
                        adapter.addListBanner(bannerList);
                        getProduct(Token);
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getProduct(String Token){
        Observable<ApiListResult<ContainerProduct>> getProductMain = ApiUtils.getAPIservices().getContainerProduct(Token);
        getProductMain.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiListResult<ContainerProduct>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiListResult<ContainerProduct> containerProductApiListResult) {
                        List<ContainerProduct> list = containerProductApiListResult.getData();
                        adapter.addListProduct(list);
                        lvIndex.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                        Log.e(TAG, "onError: index get product " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
    }

    @Override
    public void onRefresh() {
        if (adapter != null) adapter.reset();
        getBannerHome(Constant.Token);
    }

    public static String printKeyHash(Activity context) {
        PackageInfo packageInfo;
        String key = null;
        try {
            //getting application package name, as defined in manifest
            String packageName = context.getApplicationContext().getPackageName();

            //Retriving package info
            packageInfo = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES);

            Log.e("Package Name=", context.getApplicationContext().getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));

                // String key = new String(Base64.encodeBytes(md.digest()));
                Log.e("Key Hash=", key);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("Name not found", e1.toString());
        }
        catch (NoSuchAlgorithmException e) {
            Log.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        return key;
    }
}
