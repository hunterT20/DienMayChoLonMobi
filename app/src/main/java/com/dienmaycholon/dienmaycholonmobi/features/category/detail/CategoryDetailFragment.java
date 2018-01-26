package com.dienmaycholon.dienmaycholonmobi.features.category.detail;


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
public class CategoryDetailFragment extends Fragment {
    @BindView(R.id.rcv_category_detail)    RecyclerView rcv_category_detail;

    public CategoryDetailFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.category_detail_fragment, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
