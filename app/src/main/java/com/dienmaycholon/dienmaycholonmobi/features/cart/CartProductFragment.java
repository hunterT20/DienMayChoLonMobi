package com.dienmaycholon.dienmaycholonmobi.features.cart;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartProductFragment extends Fragment {
    @BindView(R.id.rcv_cart_product)    RecyclerView rcv_cart_product;

    private CartProductAdapter adapter;

    public CartProductFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_product_fragment, container, false);
        ButterKnife.bind(this,view);

        addViews();
        return view;
    }

    private void addViews() {
        assert getActivity() != null;
        ((CartActivity) getActivity()).setTitleToolbar("Giỏ hàng");

        adapter = new CartProductAdapter(getActivity());
        RecyclerViewUtil.setupRecyclerView(rcv_cart_product, adapter, getActivity());
        rcv_cart_product.setAdapter(adapter);
    }

    @OnClick(R.id.btn_thanh_toan)
    public void onThanhToanClick(){
        assert getActivity() != null;
        ((CartActivity)getActivity()).callFragment(new CartInfoFragment());
    }

}
