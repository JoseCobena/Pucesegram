package com.pucese.pucesegram.fragment.home.presenter;

import com.pucese.pucesegram.fragment.home.interactor.HomeInteractor;
import com.pucese.pucesegram.fragment.home.interactor.HomeInteractorImpl;
import com.pucese.pucesegram.fragment.home.view.HomeView;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public class HomePresenterImpl implements HomePresenter{
    private HomeView view;
    private HomeInteractor interactor;

    public HomePresenterImpl(HomeView view) {
        this.view = view;
        interactor = new HomeInteractorImpl(this);
    }

    @Override
    public ArrayList<Picture> buidPictures(ArrayList<Picture> pictures) {
        return interactor.buidPictures(pictures);
    }
}
