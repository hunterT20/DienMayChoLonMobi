package com.dienmaycholon.dienmaycholonmobi.features.search.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.ApiListResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.dienmaycholon.dienmaycholonmobi.features.home.adapter.ItemProductMainAdapter;
import com.dienmaycholon.dienmaycholonmobi.features.search.adapter.ItemProductSearchAdapter;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = SearchActivity.class.getSimpleName();
    @BindView(R.id.edtSearch) EditText edtSearch;
    @BindView(R.id.rcvProductSearch) RecyclerView rcvProductSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.search_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imvBack_Search)
    public void onBackClick(){
        onBackPressed();
    }

    @OnClick(R.id.imvBarcode)
    public void onBarcodeClick(){

    }

    private void search(String key, String token){
        Observable<ApiListResult<Child>> getSearch = ApiUtils.getAPIservices().getSearch(key, token);
        getSearch.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiListResult<Child>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiListResult<Child> childApiListResult) {
                        Log.e(TAG, "onNext: " + childApiListResult.getData().size());
                        /*RecyclerViewUtil.setupRecyclerViewGrid(rcvProductSearch,new ItemProductMainAdapter(productList,this),this);

                        ItemProductSearchAdapter adapter = new ItemProductSearchAdapter(productList,this);
                        adapter.setHasStableIds(true);
                        rcvProductSearch.setAdapter(adapter);*/
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
    public void onBackPressed() {
        super.onBackPressed();
    }
}
