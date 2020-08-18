package com.pucese.pucesegram.fragment.search.presenter;

import com.pucese.pucesegram.adapter.PictureAdapterRecyclerView;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public interface SearchPresenter {
    void filtrar(
            String texto,
            PictureAdapterRecyclerView pictureAdapterRecyclerView,
            ArrayList<Picture> pictures
    );
    ArrayList<Picture> buidPictures(ArrayList<Picture> pictures);

}
