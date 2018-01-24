package com.dienmaycholon.dienmaycholonmobi.features.menu;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.features.home.view.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuMainFragment extends Fragment
        implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.nav_view) NavigationView navigationView;

    public MenuMainFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.menu_main_fragment, container, false);
        ButterKnife.bind(this,view);
        navigationView.setNavigationItemSelectedListener(this);
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.nav_home:
                assert getActivity() != null;
                if (getActivity() instanceof MainActivity){
                    DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawer(GravityCompat.START);
                    }
                }
                return true;
            case R.id.nav_category:
                assert getActivity() != null;
                ((MainActivity)getActivity()).callMenu(new MenuCategoryFragment());
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
