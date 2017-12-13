package com.dienmaycholon.dienmaycholonmobi.features.search.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.model.Product;
import com.dienmaycholon.dienmaycholonmobi.util.RecyclerViewUtil;
import com.dienmaycholon.dienmaycholonmobi.features.index.adapter.ItemProductMainAdapter;
import com.dienmaycholon.dienmaycholonmobi.features.search.adapter.ItemProductSearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private ImageView imvBack_Search;
    private ImageView imvBarcode;
    private EditText edtSearch;
    private RecyclerView rcvProductSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        addViews();
        addEvents();
    }

    private void addEvents() {
        imvBack_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 3){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rcvProductSearch.setVisibility(View.VISIBLE);
                        }
                    },1000);
                }else if (editable.length() == 0){
                       rcvProductSearch.setVisibility(View.GONE);
                }
            }
        });
    }

    private void addViews() {
        imvBack_Search = findViewById(R.id.imvBack_Search);
        imvBarcode = findViewById(R.id.imvBarcode);
        edtSearch = findViewById(R.id.edtSearch);
        rcvProductSearch = findViewById(R.id.rcvProductSearch);

        List<Product> productList = new ArrayList<>();
        Product product = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);

        RecyclerViewUtil.setupRecyclerViewGrid(rcvProductSearch,new ItemProductMainAdapter(productList,this),this);

        ItemProductSearchAdapter adapter = new ItemProductSearchAdapter(productList,this);
        adapter.setHasStableIds(true);
        rcvProductSearch.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}