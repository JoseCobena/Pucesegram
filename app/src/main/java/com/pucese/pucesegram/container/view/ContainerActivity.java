package com.pucese.pucesegram.container.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.pucese.pucesegram.R;
import com.pucese.pucesegram.container.presenter.ContainerPresenter;
import com.pucese.pucesegram.container.presenter.ContainerPresenterImpl;
import com.pucese.pucesegram.fragment.camera.view.CameraFragment;
import com.pucese.pucesegram.fragment.favorite.view.FavoriteFragment;
import com.pucese.pucesegram.fragment.home.view.HomeFragment;
import com.pucese.pucesegram.fragment.profile.view.ProfileFragment;
import com.pucese.pucesegram.fragment.search.view.SearchFragment;
import com.pucese.pucesegram.login.view.LoginActivity;

public class ContainerActivity extends AppCompatActivity implements ContainerView{
    private ContainerPresenter presenter;
    private Button mButtonsignOut;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        presenter= new ContainerPresenterImpl(this);

        mButtonsignOut = (Button) findViewById(R.id.signOut);
        mButtonsignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signOut();
            }
        });

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigationview);
        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
        presenter.showSelectedFragment(new HomeFragment(), getSupportFragmentManager());
        //showSelectedFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search:
                        presenter.showSelectedFragment(new SearchFragment(), getSupportFragmentManager());
                        break;
                    case R.id.profile:
                        presenter.showSelectedFragment(new ProfileFragment(), getSupportFragmentManager());
                        break;
                    case R.id.home:
                        presenter.showSelectedFragment(new HomeFragment(), getSupportFragmentManager());
                        break;
                    case R.id.camera:
                        presenter.showSelectedFragment(new CameraFragment(), getSupportFragmentManager());
                        break;
                    case R.id.favorite:
                        presenter.showSelectedFragment(new FavoriteFragment(), getSupportFragmentManager());
                        break;
                }
                return true;
            }
        });

    }


    @Override
    public void signOut() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
