package com.pucese.pucesegram.picturedetail.presenter;

import android.content.Intent;

import com.pucese.pucesegram.picturedetail.interactor.PictureDetailInteractor;
import com.pucese.pucesegram.picturedetail.interactor.PictureDetailInteractorImpl;
import com.pucese.pucesegram.picturedetail.view.PictureDetailView;

public class PictureDetailPresenterImpl implements PictureDetailPresenter{
    private PictureDetailView view;
    private PictureDetailInteractor interactor;

    public PictureDetailPresenterImpl(PictureDetailView view) {
        this.view = view;
        interactor = new PictureDetailInteractorImpl(this);
    }

    @Override
    public void setInformation(Intent i) {
        interactor.setInformation(i);
    }

    @Override
    public void getResult(String url, String name, String like, String title, String comentarios) {
        view.setImage(url);
        view.setNombre(name);
        view.setLikeNumber(like);
        view.setTitulo(title);
        view.setDetail(comentarios);
    }
}
