package com.dienmaycholon.dienmaycholonmobi.features.cart;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dienmaycholon.dienmaycholonmobi.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartInfoFragment extends Fragment {

    public CartInfoFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_info_fragment, container, false);
        ButterKnife.bind(this,view);

        addViews();
        return view;
    }

    private void addViews() {
        assert getActivity() != null;
        ((CartActivity)getActivity()).setTitleToolbar("Thông tin giao hàng");

        ((CartActivity)getActivity()).getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((CartActivity) getActivity()).callFragment(new CartProductFragment());
            }
        });
    }

}
