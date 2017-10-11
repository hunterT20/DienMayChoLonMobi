package com.dienmaycholon.dienmaycholonmobi.ui.index.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.model.ItemIndex;
import com.dienmaycholon.dienmaycholonmobi.model.Product;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;
import com.dienmaycholon.dienmaycholonmobi.ui.search.view.SearchActivity;
import com.dienmaycholon.dienmaycholonmobi.ui.index.adapter.ItemTangAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {

    private RecyclerView lvIndex;
    private List<ItemIndex> list;
    private TextView txtvSearch;

    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);

        addViews(view);
        addControls();
        return view;
    }

    private void addControls() {
        txtvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    private void addViews(View view) {
        lvIndex = view.findViewById(R.id.lvIndex);
        txtvSearch = view.findViewById(R.id.txtvSearch);
        RecyclerViewUtil.setupRecyclerView(lvIndex, new ItemTangAdapter(list,getActivity()),getActivity());

        List<Product> productList = new ArrayList<>();
        Product product = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);

        list = new ArrayList<>();
        ItemIndex itemIndex1 = new ItemIndex("Khuyến mãi",productList);
        ItemIndex itemIndex2 = new ItemIndex("Điện tử",productList);
        ItemIndex itemIndex3 = new ItemIndex("Điện lạnh",productList);
        ItemIndex itemIndex4 = new ItemIndex("Di động - Tablet",productList);
        ItemIndex itemIndex5 = new ItemIndex("Gia dụng",productList);
        ItemIndex itemIndex6 = new ItemIndex("Viễn thông - Laptop",productList);
        ItemIndex itemIndex7 = new ItemIndex("Nội thất",productList);
        ItemIndex itemIndex8 = new ItemIndex("Đối tác - Dịch vụ",productList);

        list.add(itemIndex1);
        list.add(itemIndex2);
        list.add(itemIndex3);
        list.add(itemIndex4);
        list.add(itemIndex5);
        list.add(itemIndex6);
        list.add(itemIndex7);
        list.add(itemIndex8);

        ItemTangAdapter adapter = new ItemTangAdapter(list,getActivity());
        adapter.setHasStableIds(true);
        lvIndex.setAdapter(adapter);
    }

}
