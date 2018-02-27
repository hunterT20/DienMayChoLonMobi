package com.dienmaycholon.dienmaycholonmobi.features.cart;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.local.database.LocalDatabase;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.data.model.Customer;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ParamCartProduct;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartInfoFragment extends Fragment {
    private CompositeDisposable mCompositeDisposable;

    public CartInfoFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_info_fragment, container, false);
        ButterKnife.bind(this,view);
        mCompositeDisposable = new CompositeDisposable();

        addViews();
        return view;
    }

    private void addViews() {
        assert getActivity() != null;
        ((CartActivity)getActivity()).setTitleToolbar("Thông tin giao hàng");

        ((CartActivity)getActivity()).getBackButton().setOnClickListener(view -> (
                (CartActivity) getActivity()).callFragment(new CartProductFragment()));
    }

    @OnClick(R.id.btn_buy)
    public void onBuyClick(){
        Disposable disposable = LocalDatabase
                .getInstance(getActivity())
                .getChildDao()
                .getListProductCurrentBuy()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(children -> {
                    List<ParamCartProduct> productList = new ArrayList<>();
                    for (Child child : children){
                        ParamCartProduct product = new ParamCartProduct();
                        product.setId(child.getIdDetail());
                        product.setColor(child.getColorChoose());
                        product.setQt(child.getCount());

                        productList.add(product);
                    }
                    return productList;
                })
                .subscribe(this::onGetAllProductSuccess,
                        throwable -> onGetAllProductFailure(throwable.getMessage()));

        mCompositeDisposable.add(disposable);
    }
    private void onGetAllProductFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void onGetAllProductSuccess(List<ParamCartProduct> productList) {
        Gson gson = new Gson();
        String listProduct = gson.toJson(productList);
        String customer = gson.toJson(createDataCustomer());

        HashMap<String,String> param = new HashMap<>();
        param.put("product", listProduct);
        param.put("customer", customer);

        Observable<ApiResult<String, Integer>> postCart = ApiUtils.getAPIservices().postCart(Constant.Token, param);

        postCart.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResult<String, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiResult<String, Integer> stringIntegerApiResult) {
                        Log.e(TAG, "onNext: " + stringIntegerApiResult.getMessage());
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

    private Customer createDataCustomer(){
        return new Customer.CustomerBuilder()
                .setGender(1)
                .setName("Ngô Thanh Tuấn")
                .setPhone("01669384803")
                .setEmail("thanhtuan200295@gmail.com")
                .setNote("test")
                .setShip("3")
                .setCity("0")
                .setDistrict("0")
                .setMyaddress("180 cao lỗ")
                .setCode_company(null)
                .setName_company(null)
                .setAddress_company(null)
                .setBranch(1)
                .setStorebranch("lô g, chung cư Hùng Vương")
                .setGetday("20/02/2018")
                .build();
    }

    @Override
    public void onStop() {
        super.onStop();
        mCompositeDisposable.clear();
    }
}
