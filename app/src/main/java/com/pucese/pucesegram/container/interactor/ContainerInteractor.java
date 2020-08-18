package com.pucese.pucesegram.container.interactor;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public interface ContainerInteractor {
    void signOut();
    void showSelectedFragment(Fragment fragment, FragmentManager fragmentManager);

}
