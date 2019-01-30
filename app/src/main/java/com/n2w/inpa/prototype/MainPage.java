package com.n2w.inpa.prototype;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainPage extends AppCompatActivity implements DiscoverFragment.OnFragmentInteractionListener,
        MyTripFragment.OnFragmentInteractionListener {

    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        toolbar = getSupportActionBar();

        BottomNavigationView btmNavView = findViewById(R.id.menuNavigation);
        btmNavView.setLabelVisibilityMode(1);
        btmNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new DiscoverFragment());


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.menu_discover:
                    //toolbar.setTitle(R.string.menu_title_discovery);
                    fragment = new DiscoverFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_mytrip:
                    //toolbar.setTitle(R.string.menu_title_mytrip);
                    fragment = new MyTripFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_myprofile:
                    //toolbar.setTitle(R.string.menu_title_myprofile);
                    return true;
                case R.id.menu_settings:
                    //toolbar.setTitle(R.string.menu_title_settings);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.replace(R.id.fragmentFrame,fragment);
        fragTrans.addToBackStack(null);
        fragTrans.commit();
    }
}
