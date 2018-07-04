package com.osiragames.moviebase.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osiragames.moviebase.R;

/**
 * Created by ABHI on 7/3/2018.
 */

public class PopularMoviesFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.movies_grid,null,false);

        recyclerView = view.findViewById(R.id.moviegrid_recyclerview_id);


        return view;
    }


}
