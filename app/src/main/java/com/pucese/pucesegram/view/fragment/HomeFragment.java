package com.pucese.pucesegram.view.fragment;


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
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        RecyclerView picturesRecycler=(RecyclerView) view.findViewById(R.id.pictureRecycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView=new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture,getActivity() );
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;

    }

    public ArrayList<Picture> buidPictures()
    {
        ArrayList<Picture> pictures =new ArrayList<>();
        pictures.add(new Picture("https://live.staticflickr.com/8711/16549120663_06ee047a93_b.jpg",
                "Portete","4 days","10 likes"));
        pictures.add(new Picture("https://www.turismo.gob.ec/wp-content/uploads/2018/10/ESMERALDAS-ATACAMES-PAISAJES-PLAYAS037.jpg",
                "Atacames","3 days","7 likes"));
        pictures.add(new Picture("https://img.goraymi.com/2018/08/06/03894b70caa8eaeb19e69eb41304fb1d_xl.jpg",
                "Las Palmas","8 days","15 likes"));
        pictures.add(new Picture("https://www.decameron.com/images/destinos/ecuador/mompiche/mompiche-001.jpg",
                "Mompiche","15 days","8 likes"));
        pictures.add(new Picture("https://gadmuisne.gob.ec/web/wp-content/uploads/2019/08/muisne12.jpg",
                "Muisne","1 day","2 likes"));
        pictures.add(new Picture("https://lh3.googleusercontent.com/proxy/wbHy-4MS0BcZGp6kSMWoqPIylh0XBsJNBUZft6xbY6GAN3u4Sr3bbgPiTuPemUc-Kj6J2lit6v14ej69T-gHpybZ5-Xwr9tY0eknAjnRn4aJQT00tR_bodr1vy5h",
                "Galera","8 days","4 likes"));
        pictures.add(new Picture("https://ec.viajandox.com/uploads/Playa%20Estero%20de%20Pl%C3%A1tano_1.jpg",
                "Estero de Plátano","3 days","3 likes"));
        return pictures;
    }


    public void showToolbar(String tittle, boolean upButton,View view)
    {
        Toolbar toolbar=(Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity() ).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity() ).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity() ).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
