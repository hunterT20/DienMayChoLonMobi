package com.dienmaycholon.dienmaycholonmobi.features.product_detail.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dienmaycholon.dienmaycholonmobi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DanhGiaFragment extends Fragment {
    @BindView(R.id.rcv_DanhGia)
    RecyclerView rcv_DanhGia;

    public DanhGiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_danh_gia_fragment, container, false);
        ButterKnife.bind(this,view);
        addViews(view);
        return view;
    }

    private void addViews(View view) {

    }
}
