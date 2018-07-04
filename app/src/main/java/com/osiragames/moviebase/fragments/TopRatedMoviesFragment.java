package com.osiragames.moviebase.fragments;

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

import com.osiragames.moviebase.MovieInterfaces.PopularMoviesListener;
import com.osiragames.moviebase.MovieInterfaces.TopRatedMovieListener;
import com.osiragames.moviebase.MovieServices;
import com.osiragames.moviebase.R;
import com.osiragames.moviebase.adapters.MovieAdapter;
import com.osiragames.moviebase.models.Movie;
import com.osiragames.moviebase.models.ResponseMovies;
import com.osiragames.moviebase.models.SingletonMovieList;
import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.List;

/**
 * Created by ABHI on 7/3/2018.
 */

public class TopRatedMoviesFragment extends Fragment {

    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.movies_grid,null,false);

        recyclerView = view.findViewById(R.id.moviegrid_recyclerview_id);

        MovieServices.getTopRatedMovies(getResources().getString(R.string.api_key), new TopRatedMovieListener() {
            @Override
            public void response(ResponseMovies responseMovies) {
                if(responseMovies != null){
                    List<SpecificMovieDetails> movieList = SingletonMovieList.getSpecificMovieDetailsList(responseMovies);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),GridLayoutManager.DEFAULT_SPAN_COUNT));
                    recyclerView.setAdapter(new MovieAdapter(getContext(),movieList));
                }
            }
        });
        return view;
    }
}
