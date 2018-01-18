package com.dienmaycholon.dienmaycholonmobi.features.detail.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.ElementProduct;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModalBottomSheet extends BottomSheetDialogFragment {
    @BindView(R.id.rcv_thongso_kythuat)    RecyclerView rcv_thongso_kythuat;
    private List<ElementProduct> elementProductList;

    static BottomSheetDialogFragment newInstance() {
        return new BottomSheetDialogFragment();
    }

    public void addList(List<ElementProduct> elementProducts){
        this.elementProductList = elementProducts;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_thong_so_kt_layout, container, false);
        ButterKnife.bind(this,view);

        ThongsoAdapter thongsoAdapter = new ThongsoAdapter(getActivity());
        thongsoAdapter.addList(elementProductList);

        RecyclerViewUtil.setupRecyclerView(rcv_thongso_kythuat,thongsoAdapter,getActivity());

        rcv_thongso_kythuat.setAdapter(thongsoAdapter);
        return view;
    }
}
