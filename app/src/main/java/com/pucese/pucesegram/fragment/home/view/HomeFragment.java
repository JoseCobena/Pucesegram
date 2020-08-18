package com.pucese.pucesegram.fragment.home.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pucese.pucesegram.R;
import com.pucese.pucesegram.adapter.PictureAdapterRecyclerView;
import com.pucese.pucesegram.fragment.home.presenter.HomePresenter;
import com.pucese.pucesegram.fragment.home.presenter.HomePresenterImpl;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements HomeView{
    RecyclerView picturesRecycler;
    PictureAdapterRecyclerView pictureAdapterRecyclerView;
    ArrayList<Picture> pictures;
    LinearLayoutManager linearLayoutManager;

    private HomePresenter presenter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        presenter = new HomePresenterImpl(this);
        picturesRecycler=(RecyclerView) view.findViewById(R.id.pictureRecycler);
        linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        pictureAdapterRecyclerView=new PictureAdapterRecyclerView(presenter.buidPictures(pictures),R.layout.cardview_picture,getActivity() );
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;

    }

    public void showToolbar(String tittle, boolean upButton,View view)
    {
        Toolbar toolbar=(Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity() ).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity() ).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity() ).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
