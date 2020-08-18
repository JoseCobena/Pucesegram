package com.pucese.pucesegram.fragment.profile.presenter;

import com.pucese.pucesegram.fragment.profile.interactor.ProfileInteractor;
import com.pucese.pucesegram.fragment.profile.interactor.ProfileInteractorImpl;
import com.pucese.pucesegram.fragment.profile.view.ProfileView;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public class ProfilePresenterImpl implements ProfilePresenter{
    private ProfileInteractor interactor;
    private ProfileView view;

    public ProfilePresenterImpl(ProfileView view) {
        this.view = view;
        interactor = new ProfileInteractorImpl(this);
    }

    @Override
    public ArrayList<Picture> buidPictures(ArrayList<Picture> pictures) {
        return interactor.buidPictures(pictures);
    }
}
