package com.dienmaycholon.dienmaycholonmobi.features.index.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.ApiListResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.ContainerProduct;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiService;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;
import com.dienmaycholon.dienmaycholonmobi.features.search.view.SearchActivity;
import com.dienmaycholon.dienmaycholonmobi.features.index.adapter.ItemTangAdapter;

import java.util.Arrays;
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
public class IndexFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.lvIndex) RecyclerView lvIndex;
    @BindView(R.id.swipeRefresh)    SwipeRefreshLayout swipeRefreshLayout;
    private TextView txtvSearch;

    private ApiService apiService;
    private String TOKEN;
    private Boolean isGetToken = false;
    private ItemTangAdapter adapter;

    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        ButterKnife.bind(this,view);

        addViews(view);
        addControls();
        return view;
    }

    private void addControls() {
        txtvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                if (getActivity() == null) return;
                getActivity().startActivity(intent);
            }
        });
    }

    private void addViews(View view) {
        txtvSearch = view.findViewById(R.id.txtvSearch);
        lvIndex.setHasFixedSize(true);
        lvIndex.setItemViewCacheSize(20);
        lvIndex.setDrawingCacheEnabled(true);
        lvIndex.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        apiService = ApiUtils.getAPIservicesTest();
        swipeRefreshLayout.setOnRefreshListener(this);
        getToken();
    }

    private void getToken(){
        swipeRefreshLayout.setRefreshing(true);
        Observable<ApiResult<String>> getToken = apiService.getToken();
        getToken.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResult<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiResult<String> token) {
                        Constant.Token = token.getData();
                        TOKEN = token.getData();
                        getProduct(token.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                        isGetToken = false;
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        isGetToken = true;
                    }
                });
    }

    private void getProduct(String Token){
        Observable<ApiListResult<ContainerProduct>> getProductMain = apiService.getContainerProduct(Token);
        getProductMain.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiListResult<ContainerProduct>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiListResult<ContainerProduct> containerProductApiListResult) {
                        List<ContainerProduct> list = containerProductApiListResult.getData();
                        RecyclerViewUtil.setupRecyclerView(lvIndex, new ItemTangAdapter(list,getActivity()),getActivity());

                        adapter = new ItemTangAdapter(list,getActivity());
                        adapter.setHasStableIds(true);
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
        if (isGetToken){
            getProduct(TOKEN);
        }else {
            getToken();
        }
    }
}
