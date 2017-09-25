package com.lotus.cruzroja.view.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lotus.cruzroja.R;
import com.lotus.cruzroja.view.adapter.PictureAdapterRecyclerView;
import com.lotus.cruzroja.view.model.Picture;

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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Primeros Auxilios",false,view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture,getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> buidPictures()
    {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture(R.drawable.primerosauxilios,"Lección 1","Evaluación Inicial"));
        pictures.add(new Picture(R.drawable.img2,"Lección 2","Reanimación Cardiopulmonar (RCP)"));
        pictures.add(new Picture(R.drawable.lesson3picture,"Lección 3","Maniobra de atragantamiento con compresiones abdominales"));
        pictures.add(new Picture(R.drawable.lesson4picture,"Lección 4","Heridas y hemorragias"));
        pictures.add(new Picture(R.drawable.lesson5picture,"Lección 5","Quemaduras"));
        pictures.add(new Picture(R.drawable.lesson6picture,"Lección 6","Vendajes"));
        pictures.add(new Picture(R.drawable.lesson7picture,"Lección 7","Fracturas e inmovilizaciones"));
        pictures.add(new Picture(R.drawable.lesson8picture,"Lección 8","Movilización de pacientes"));

        return pictures;
    }

    public void showToolbar(String title, boolean upButton, View view)
    {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
