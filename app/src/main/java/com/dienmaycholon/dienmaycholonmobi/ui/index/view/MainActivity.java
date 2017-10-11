package com.dienmaycholon.dienmaycholonmobi.ui.index.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.dienmaycholon.dienmaycholonmobi.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        callFragment(new IndexFragment());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private int level_Menu = 0;
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        final View header = navigationView.getHeaderView(0);
        final View header_main = header.findViewById(R.id.nav_header_main);
        final View header_sub = header.findViewById(R.id.nav_header_sub);
        final TextView txtvTitleSub = header.findViewById(R.id.txtvTitleSubMenu);
        ImageView btnBackSub = header.findViewById(R.id.btnBackSub);

        switch (id){
            //Sự kiện click menu level 0
            case R.id.nav_home:
                return true;
            case R.id.nav_category:
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.category_menu);
                txtvTitleSub.setText("Danh mục");
                animationMenu();
                header_main.setVisibility(View.GONE);
                header_sub.setVisibility(View.VISIBLE);
                header.setBackgroundColor(getResources().getColor(R.color.BackgroundNavSub));
                level_Menu = 1;
                break;
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

            //Sự kiện click menu level 1 click
            case R.id.nav_category_dientu:
                level_Menu = 2;
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.dientu_category_menu);
                txtvTitleSub.setText(item.getTitle());
                animationMenu();
                break;
            case R.id.nav_category_dienlanh:
                level_Menu = 2;
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.dienlanh_category_menu);
                txtvTitleSub.setText(item.getTitle());
                animationMenu();
                break;
            case R.id.nav_category_giadung:
                break;
            case R.id.nav_category_vienthong:
                break;
            case R.id.nav_category_mobi:
                break;
            case R.id.nav_category_noithat:
                break;
            case R.id.nav_category_dichvu:
                break;
        }

        //Sự kiện click button back trong menu
        btnBackSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*B1: Nếu level menu == 1 (menu đang ở Danh mục) thì xóa layout menu lv1 và thay bằng menu lv0
                * B2: Thực hiện animation đóng mở menu, Ẩn Header menu Danh mục, hiện Header menu main
                * B3: Cuối cùng chuyển biến level_menu về 0*/
                if (level_Menu == 1){
                    navigationView.getMenu().clear();
                    navigationView.inflateMenu(R.menu.activity_main_drawer);
                    animationMenu();
                    header_main.setVisibility(View.VISIBLE);
                    header_sub.setVisibility(View.GONE);
                    header.setBackground(getResources().getDrawable(R.drawable.background_nav));
                    level_Menu = 0;
                }else if (level_Menu == 2){
                    /*B1: Nếu level menu == 2 (menu đang ở con của Danh mục) thì xóa layout menu lv2 và thay bằng menu Danh mục
                    * B2: Thực hiện animation đóng mở menu
                    * B3: Thay giá trị biến level = 1*/
                    navigationView.getMenu().clear();
                    navigationView.inflateMenu(R.menu.category_menu);
                    txtvTitleSub.setText("Danh mục");
                    animationMenu();
                    level_Menu = 1;
                }
        }
        });

        return true;
    }

    /**
     * Khi chuyển level menu sẽ hiển thị đóng => chờ 500ms và mở lại
     * để làm mượt quá trình chuyển layout menu
     */
    public void animationMenu(){
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawer.openDrawer(GravityCompat.START);
            }
        }, 500);
    }

    /**
     *
     * @param fragment: fragment cần hiển thị để thay thế layout frmContent
     *                (áp dụng cho Fragment V4)
     */
    public void callFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frmContent, fragment)
                .commit();
    }
}
