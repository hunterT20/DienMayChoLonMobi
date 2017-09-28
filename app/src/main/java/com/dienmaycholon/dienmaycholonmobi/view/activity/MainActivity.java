package com.dienmaycholon.dienmaycholonmobi.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import com.dienmaycholon.dienmaycholonmobi.view.IndexFragment;
import com.dienmaycholon.dienmaycholonmobi.view.adapter.SliderMainAdapter;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private SliderMainAdapter sliderMainAdapter;

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;

    int[] img;
    private static int currentPage = 0;
    private static int numberPage = 0;

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
        viewPager = findViewById(R.id.viewPager);
        circleIndicator = findViewById(R.id.indicator);

        img =  new int[]{R.drawable.slide_1,R.drawable.slide_2,R.drawable.slide_3,R.drawable.slide_4,R.drawable.slide_5,R.drawable.slide_6,R.drawable.slide_7};
        sliderMainAdapter = new SliderMainAdapter(img, getApplication());

        viewPager.setAdapter(sliderMainAdapter);
        circleIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int pageCount = img.length;
                    if (currentPage == 0) {
                        viewPager.setCurrentItem(pageCount - 1, false);
                    } else if (currentPage == pageCount - 1) {
                        viewPager.setCurrentItem(0, false);
                    }
                }
            }
        });

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == numberPage) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 6000, 2000);

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
                break;
            case R.id.nav_chinhanh:
                break;
        }

        btnBackSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.activity_main_drawer);
                animationMenu();
                header_main.setVisibility(View.VISIBLE);
                header_sub.setVisibility(View.GONE);
                header.setBackground(getResources().getDrawable(R.drawable.background_nav));
        }
        });

        return true;
    }

    public void animationMenu(){
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        Handler handler = new Handler();handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawer.openDrawer(GravityCompat.START);
            }
        }, 500);
    }

    public void callFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frmContent, fragment)
                .commit();
    }
}
