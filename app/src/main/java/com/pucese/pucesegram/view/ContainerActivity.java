package com.pucese.pucesegram.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.pucese.pucesegram.R;
import com.pucese.pucesegram.view.fragment.CameraFragment;
import com.pucese.pucesegram.view.fragment.FavoriteFragment;
import com.pucese.pucesegram.view.fragment.HomeFragment;
import com.pucese.pucesegram.view.fragment.ProfileFragment;
import com.pucese.pucesegram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        setInitialFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.search:
                fragment = new SearchFragment();
                break;
            case R.id.profile:
                fragment = new ProfileFragment();
                break;
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.camera:
                fragment = new CameraFragment();
                break;
            case R.id.favorite:
                fragment = new FavoriteFragment();
                break;
        }
        replaceFragment(fragment);
        return true;
    }

    private void setInitialFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, new SearchFragment());
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
