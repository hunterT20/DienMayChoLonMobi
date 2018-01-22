package com.dienmaycholon.dienmaycholonmobi.features.category;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dienmaycholon.dienmaycholonmobi.R;

import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        ButterKnife.bind(this);

        callFragment(new CategoryFragment());
    }

    public void callFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frm_category, fragment)
                .commit();
    }
}
