package com.dienmaycholon.dienmaycholonmobi.features.category.detail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryDetail;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryDetailProduct;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiService;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

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
public class CategoryDetailFragment extends Fragment {
    @BindView(R.id.rcv_category_detail)    RecyclerView rcv_category_detail;

    private ApiService apiService;
    private CategoryDetailAdapter adapter;

    public CategoryDetailFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.category_detail_fragment, container, false);
        ButterKnife.bind(this,view);

        apiService = ApiUtils.getAPIservices();
        adapter = new CategoryDetailAdapter(getActivity());
        RecyclerViewUtil.setupRecyclerView(rcv_category_detail, adapter, getActivity());
        addViews();
        return view;
    }

    private void addViews() {
        Observable<ApiResult<CategoryDetail>> getCategoryDetail = apiService.getCategoryParent(Constant.alias,Constant.Token);
        getCategoryDetail.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResult<CategoryDetail>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiResult<CategoryDetail> categoryDetailApiResult) {
                        Log.e(TAG, "onNext: " + categoryDetailApiResult.getData().getName());
                        CategoryDetail categoryDetail = categoryDetailApiResult.getData();
                        List<CategoryDetailProduct> productList = categoryDetail.getCategoryDetailProducts();

                        adapter.addList(productList);
                        rcv_category_detail.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
