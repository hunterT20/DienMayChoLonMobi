package com.dienmaycholon.dienmaycholonmobi.features.cart;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)    Toolbar toolbar;
    @BindView(R.id.btn_back)    ImageView btn_back;
    @BindView(R.id.txtv_title_toolbar_with_back)    TextView txtv_title_toolbar_with_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);
        ButterKnife.bind(this);

        addViews();
    }

    private void addViews() {
        setSupportActionBar(toolbar);
        callFragment(new CartProductFragment());
    }

    public void callFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frm_content, fragment)
                .commit();
    }

    public void setTitleToolbar(String titleToolbar){
        txtv_title_toolbar_with_back.setText(titleToolbar);
    }

    public ImageView getBackButton(){
        return btn_back;
    }
}
