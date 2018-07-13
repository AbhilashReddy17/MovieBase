package com.osiragames.moviebase.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.osiragames.moviebase.R;
import com.osiragames.moviebase.adapters.MovieAdapter;
import com.osiragames.moviebase.database.MovieDatabase;
import com.osiragames.moviebase.models.SpecificMovieDetails;
import com.osiragames.moviebase.models.viewmodels.FavouriteViewModel;
import com.osiragames.moviebase.models.viewmodels.FavouriteViewModelFactory;

import java.util.List;

/**
 * Created by ABHI on 7/10/2018.
 */

public class SavedFavouriteMovies extends Fragment {

    RecyclerView recyclerView;

    public static SavedFavouriteMovies fragment;
    ImageView nodata;

    public static SavedFavouriteMovies getinstance(){
        if(fragment == null) {
            fragment = new SavedFavouriteMovies();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.movies_grid,null,false);
        recyclerView =view.findViewById(R.id.moviegrid_recyclerview_id);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        nodata = view.findViewById(R.id.nodata_imageview_id);

        FavouriteViewModelFactory factory = new FavouriteViewModelFactory(MovieDatabase.getMovieDatabase(getContext().getApplicationContext()),getContext().getApplicationContext());

        FavouriteViewModel viewModel = ViewModelProviders.of(SavedFavouriteMovies.this,factory).get(FavouriteViewModel.class);

         viewModel.loadFavouriteMovies().observe(this, new Observer<List<SpecificMovieDetails>>() {
             @Override
             public void onChanged(@Nullable List<SpecificMovieDetails> specificMovieDetails) {
                 if(specificMovieDetails.size()!=0) {
                     nodata.setVisibility(View.GONE);
                     recyclerView.setAdapter(new MovieAdapter(getContext(), specificMovieDetails, 3));
                 }
                 else{
                     nodata.setVisibility(View.VISIBLE);
                     recyclerView.setAdapter(new MovieAdapter(getContext(),null,3));
                 }

             }
         });



        return view;
    }
}
