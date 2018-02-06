package com.dienmaycholon.dienmaycholonmobi.features.login;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dienmaycholon.dienmaycholonmobi.R;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

        addFragment(new LoginFragment());
    }

    public void addFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frm_login, fragment)
                .commit();
    }
}
