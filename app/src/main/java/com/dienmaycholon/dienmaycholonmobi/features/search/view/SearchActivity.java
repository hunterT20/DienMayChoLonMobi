package com.dienmaycholon.dienmaycholonmobi.features.search.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.data.model.DataSearch;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.dienmaycholon.dienmaycholonmobi.features.search.adapter.ItemProductSearchAdapter;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;
import com.dienmaycholon.dienmaycholonmobi.util.RxSearchObservable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = SearchActivity.class.getSimpleName();
    @BindView(R.id.edtSearch)
    EditText edtSearch;
    @BindView(R.id.rcvProductSearch)
    RecyclerView rcvProductSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.search_activity);
        ButterKnife.bind(this);

        RecyclerViewUtil.setupRecyclerViewGrid(rcvProductSearch, new ItemProductSearchAdapter(this), this);

        addEvents();
    }

    private void addEvents() {
        RxSearchObservable.fromView(edtSearch)
                .debounce(300, TimeUnit.MILLISECONDS)
                .filter(text -> {
                    if (text.isEmpty()) {
                        Log.e(TAG, "test: empty");
                        return false;
                    } else {
                        return true;
                    }
                })
                .distinctUntilChanged()
                .switchMap(this::dataFromNetwork)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> search(result, Constant.Token));
    }

    @OnClick(R.id.imvBack_Search)
    public void onBackClick() {
        onBackPressed();
    }

    @OnClick(R.id.imvBarcode)
    public void onBarcodeClick() {
    }

    private Observable<String> dataFromNetwork(final String query) {
        return Observable.just(true)
                .delay(1, TimeUnit.SECONDS)
                .map(value -> query);
    }

    private void search(String key, String token) {
        Observable<ApiResult<DataSearch, Integer>> getSearch = ApiUtils.getAPIservices().getSearch(key, token);
        getSearch.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResult<DataSearch, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(ApiResult<DataSearch, Integer> dataSearchApiResult) {
                        List<Child> childList = dataSearchApiResult.getData().getItems();

                        Log.e(TAG, "onNext: " + childList.size());
                        ItemProductSearchAdapter adapter = new ItemProductSearchAdapter(SearchActivity.this);
                        adapter.setHasStableIds(true);
                        adapter.addList(childList);
                        rcvProductSearch.setAdapter(adapter);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
