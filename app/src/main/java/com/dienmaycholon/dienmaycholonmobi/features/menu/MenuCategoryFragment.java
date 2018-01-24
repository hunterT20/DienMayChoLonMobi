package com.dienmaycholon.dienmaycholonmobi.features.menu;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.ApiListResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.Category;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiService;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.dienmaycholon.dienmaycholonmobi.features.home.view.MainActivity;
import com.dienmaycholon.dienmaycholonmobi.util.HeightStatusBar;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuCategoryFragment extends Fragment {
    @BindView(R.id.rcv_menu_category)    RecyclerView rcv_menu_category;
    @BindView(R.id.lnl_header_category_menu)    LinearLayout lnl_header_category_menu;

    private ApiService apiService;
    private MenuCategoryAdapter adapter;

    public MenuCategoryFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.menu_category_fragment, container, false);
        ButterKnife.bind(this,view);

        apiService = ApiUtils.getAPIservices();

        adapter = new MenuCategoryAdapter(getActivity());
        RecyclerViewUtil.setupRecyclerView(rcv_menu_category, adapter, getActivity());

        addViews();
        return view;
    }

    private void addViews() {
        assert getActivity() != null;
        int padding_top_current = lnl_header_category_menu.getPaddingTop();
        int padding_left_current = lnl_header_category_menu.getPaddingLeft();
        int padding_right_current = lnl_header_category_menu.getPaddingRight();
        int padding_bottom_current = lnl_header_category_menu.getPaddingBottom();

        lnl_header_category_menu.setPadding(
                padding_left_current,
                padding_top_current + HeightStatusBar.getHeightStatusbar(getActivity()),
                padding_right_current,
                padding_bottom_current
        );

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
                        rcv_menu_category.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @OnClick(R.id.imv_back)
    public void onBackClick(){
        assert getActivity() != null;
        ((MainActivity)getActivity()).callMenu(new MenuMainFragment());
    }

}
