package com.dienmaycholon.dienmaycholonmobi.features.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.local.database.LocalDatabase;
import com.dienmaycholon.dienmaycholonmobi.data.model.User;
import com.dienmaycholon.dienmaycholonmobi.features.cart.CartActivity;
import com.dienmaycholon.dienmaycholonmobi.features.category.all.CategoryActivity;
import com.dienmaycholon.dienmaycholonmobi.features.login.LoginActivity;
import com.dienmaycholon.dienmaycholonmobi.features.search.view.SearchActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.txtvSearch) TextView txtvSearch;
    @BindView(R.id.nav_view) NavigationView navigationView;

    private LinearLayout nav_header_main;
    private LinearLayout lnl_login;
    private Button btn_login;
    private TextView txtv_username;
    private TextView txtv_email;
    private ImageView imv_Avatar;

    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        mCompositeDisposable = new CompositeDisposable();

        addViews();
        addEvents();
        callFragment(new HomeFragment());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCompositeDisposable.clear();
    }

    private void addViews() {
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        View header = navigationView.getHeaderView(0);
        nav_header_main = header.findViewById(R.id.nav_header_main);
        txtv_username = header.findViewById(R.id.txtv_username);
        txtv_email = header.findViewById(R.id.txtv_email);
        imv_Avatar = header.findViewById(R.id.imv_Avatar);
        
        lnl_login = header.findViewById(R.id.lnl_login);
        btn_login = header.findViewById(R.id.btn_login);

        Disposable disposable = LocalDatabase
                .getInstance(this)
                .getUserDao()
                .getUserInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onGetAllProductSuccess,
                        throwable -> onGetAllProductFailure(throwable.getMessage()));

        mCompositeDisposable.add(disposable);
    }

    private void onGetAllProductFailure(String message) {
        Log.e(TAG, "onGetAllProductFailure: " + message);
    }

    private void onGetAllProductSuccess(List<User> users) {
        if (users.size() > 0){
            User user = users.get(0);
            nav_header_main.setVisibility(View.VISIBLE);
            lnl_login.setVisibility(View.GONE);
            
            txtv_username.setText(user.getFullname());
            txtv_email.setText(user.getEmail());
        }
    }

    private void addEvents() {
        btn_login.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.txtvSearch)
    public void onSearchClick(){
        startActivity(new Intent(MainActivity.this, SearchActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.btn_cart:
                startActivity(new Intent(MainActivity.this, CartActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * @param fragment: fragment cần hiển thị để thay thế layout frmContent
     *                (áp dụng cho Fragment V4)
     */
    public void callFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frmContent, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.nav_home:
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                return true;
            case R.id.nav_category:
                startActivity(new Intent(MainActivity.this, CategoryActivity.class));
                return true;
            case R.id.nav_chinhanh:
                break;
            case R.id.nav_notification:
                break;
            case R.id.nav_history:
                break;
            case R.id.nav_contact:
                break;
            case R.id.nav_info:
                break;
            case R.id.nav_setting:
                break;
        }
        return true;
    }
}
