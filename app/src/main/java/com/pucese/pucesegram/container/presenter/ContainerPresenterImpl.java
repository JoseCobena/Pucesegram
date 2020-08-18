package com.pucese.pucesegram.container.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.pucese.pucesegram.container.interactor.ContainerInteractor;
import com.pucese.pucesegram.container.interactor.ContainerInteractorImpl;
import com.pucese.pucesegram.container.view.ContainerView;

public class ContainerPresenterImpl implements ContainerPresenter{
    private ContainerView view;
    private ContainerInteractor interactor;

    public ContainerPresenterImpl(ContainerView view) {
        this.view = view;
        interactor= new ContainerInteractorImpl(this);
    }

    @Override
    public void signOut() {
        interactor.signOut();
    }

    @Override
    public void signOutSuccess() {
        view.signOut();
    }

    @Override
    public void showSelectedFragment(Fragment fragment, FragmentManager fragmentManager) {
        interactor.showSelectedFragment(fragment, fragmentManager);
    }
}
