package com.pucese.pucesegram.picturedetail.presenter;

import android.content.Intent;

public interface PictureDetailPresenter {

    void setInformation(Intent i);
    void getResult(String url, String name, String like, String title, String comentarios);
}
