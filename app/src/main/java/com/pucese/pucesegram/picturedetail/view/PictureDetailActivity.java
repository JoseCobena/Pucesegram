package com.pucese.pucesegram.picturedetail.view;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pucese.pucesegram.R;
import com.pucese.pucesegram.picturedetail.presenter.PictureDetailPresenter;
import com.pucese.pucesegram.picturedetail.presenter.PictureDetailPresenterImpl;
import com.squareup.picasso.Picasso;

public class PictureDetailActivity extends AppCompatActivity implements PictureDetailView{
    private ImageView imageHeader;
    private TextView userNameDetail;
    private TextView likeNumberDetail;
    private TextView secondTitleDetail;
    private TextView textContentImageDetail;
    private PictureDetailPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar(" ",true);



        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setEnterTransition(new Fade());
        }

        imageHeader= findViewById(R.id.imageHeader);
        userNameDetail = findViewById(R.id.userNameDetail);
        likeNumberDetail = findViewById(R.id.likeNumberDetail);
        secondTitleDetail = findViewById(R.id.secondTitleDetail);
        textContentImageDetail = findViewById(R.id.textContentImageDetail);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = getIntent();

        presenter = new PictureDetailPresenterImpl(this);

        presenter.setInformation(i);
    }

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }


    @Override
    public void setImage(String txt) {
        Picasso.get().load(txt).into(imageHeader);
    }

    @Override
    public void setNombre(String txt) {
        userNameDetail.setText(txt);
    }

    @Override
    public void setLikeNumber(String txt) {
        likeNumberDetail.setText(txt);
    }

    @Override
    public void setTitulo(String txt) {
        secondTitleDetail.setText(txt);
    }

    @Override
    public void setDetail(String txt) {
        textContentImageDetail.setText(txt);
    }
}