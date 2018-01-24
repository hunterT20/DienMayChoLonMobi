package com.dienmaycholon.dienmaycholonmobi.features.category.all;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.ApiListResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.Category;
import com.dienmaycholon.dienmaycholonmobi.data.model.CategoryChild;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryParentAdapter.CategoryListener {
    @BindView(R.id.rcv_category_parent)    RecyclerView rcv_category_parent;
    @BindView(R.id.rcv_category_children) RecyclerView rcv_category_children;

    private ApiService apiService;
    private CategoryParentAdapter adapter;
    private CategoryChildAdapter childAdapter;

    public CategoryFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.category_fragment, container, false);
        ButterKnife.bind(this,view);

        apiService = ApiUtils.getAPIservices();

        adapter = new CategoryParentAdapter(getActivity());
        adapter.setOnEventListener(this);
        RecyclerViewUtil.setupRecyclerView(rcv_category_parent, adapter, getActivity());

        childAdapter = new CategoryChildAdapter(getActivity());
        RecyclerViewUtil.setupRecyclerView(rcv_category_children, childAdapter, getActivity());
        addViews();
        return view;
    }

    private void addViews() {
        Observable<ApiListResult<Category>> getCategory = apiService.getCategoryMenu(Constant.Token);
        getCategory.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiListResult<Category>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiListResult<Category> categoryApiListResult) {
                        adapter.addList(categoryApiListResult.getData());
                        rcv_category_parent.setAdapter(adapter);

                        childAdapter.addList(categoryApiListResult.getData().get(0).getCategoryChildList());
                        rcv_category_children.setAdapter(childAdapter);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onParentItemClick(List<CategoryChild> categoryChildList) {
        childAdapter.clear();
        childAdapter.addList(categoryChildList);
    }
}
