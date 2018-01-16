package com.dienmaycholon.dienmaycholonmobi.features.detail.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dienmaycholon.dienmaycholonmobi.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        callFragment(new DetailFragment());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    public void callFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frm_Detail, fragment)
                .commit();
    }

    public void setupToolbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() == null) return;
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
