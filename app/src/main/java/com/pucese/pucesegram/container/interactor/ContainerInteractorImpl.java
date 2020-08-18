package com.pucese.pucesegram.container.interactor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.container.presenter.ContainerPresenter;

public class ContainerInteractorImpl implements ContainerInteractor{
    private ContainerPresenter presenter;

    public ContainerInteractorImpl(ContainerPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void signOut() {
        FirebaseAuth.getInstance().signOut();
        presenter.signOutSuccess();
    }

    @Override
    public void showSelectedFragment(Fragment fragment, FragmentManager fragmentManager) {
        fragmentManager.beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}
