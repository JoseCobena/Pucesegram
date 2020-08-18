package com.pucese.pucesegram.container.presenter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public interface ContainerPresenter {
    void signOut();
    void signOutSuccess();
    void showSelectedFragment(Fragment fragment, FragmentManager fragmentManager);

}
