package com.dienmaycholon.dienmaycholonmobi.features.error;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.features.product_detail.view.DetailActivity;
import com.dienmaycholon.dienmaycholonmobi.features.product_detail.view.DetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ErrorFragment extends Fragment {
    @BindView(R.id.txtv_refresh)
    TextView txtv_refresh;

    public ErrorFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.error_fragment, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.txtv_refresh)
    public void onRefreshClick(){
        assert getActivity() != null;
        ((DetailActivity)getActivity()).callFragment(new DetailFragment());
    }
}
