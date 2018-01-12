package com.dienmaycholon.dienmaycholonmobi.features.detail.view;


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
public class InfoProductFragment extends Fragment {


    public InfoProductFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_info_product_fragment, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
