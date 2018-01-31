package com.dienmaycholon.dienmaycholonmobi.features.cart;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.localDB.database.LocalDatabase;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartProductFragment extends Fragment {
    @BindView(R.id.rcv_cart_product)    RecyclerView rcv_cart_product;

    private CartProductAdapter adapter;
    private static final String TAG = CartProductFragment.class.getSimpleName();
    private CompositeDisposable mCompositeDisposable;

    public CartProductFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_product_fragment, container, false);
        ButterKnife.bind(this,view);
        mCompositeDisposable = new CompositeDisposable();

        addViews();
        return view;
    }

    private void addViews() {
        assert getActivity() != null;
        ((CartActivity) getActivity()).setTitleToolbar("Giỏ hàng");

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcv_cart_product.getContext(),DividerItemDecoration.VERTICAL);
        assert getActivity() != null;
        Drawable drawable = ContextCompat.getDrawable(getActivity(),R.drawable.custom_divider);
        assert drawable != null;
        dividerItemDecoration.setDrawable(drawable);
        rcv_cart_product.addItemDecoration(dividerItemDecoration);

        adapter = new CartProductAdapter(getActivity());
        RecyclerViewUtil.setupRecyclerView(rcv_cart_product, adapter, getActivity());
        rcv_cart_product.setAdapter(adapter);

        Disposable disposable = LocalDatabase
                .getInstance(getActivity())
                .getChildDao()
                .getListProductCurrentBuy()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onGetAllProductSuccess,
                        throwable -> onGetAllProductFailure(throwable.getMessage()));

        mCompositeDisposable.add(disposable);

        ((CartActivity) getActivity()).getBackButton().setOnClickListener(view -> getActivity().onBackPressed());
    }

    private void onGetAllProductFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void onGetAllProductSuccess(List<Child> childList) {
        adapter.addList(childList);
    }

    @Override
    public void onStop() {
        super.onStop();
        mCompositeDisposable.clear();
    }

    @OnClick(R.id.btn_thanh_toan)
    public void onThanhToanClick(){
        assert getActivity() != null;
        ((CartActivity)getActivity()).callFragment(new CartInfoFragment());
    }

}
