package com.osiragames.moviebase.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.osiragames.moviebase.MovieInterfaces.PopularMoviesListener;
import com.osiragames.moviebase.MovieInterfaces.TopRatedMovieListener;
import com.osiragames.moviebase.MovieServices;
import com.osiragames.moviebase.R;
import com.osiragames.moviebase.adapters.MovieAdapter;
import com.osiragames.moviebase.models.Movie;
import com.osiragames.moviebase.models.ResponseMovies;
import com.osiragames.moviebase.models.SingletonMovieList;
import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.Date;
import java.util.List;

/**
 * Created by ABHI on 7/3/2018.
 */

public class PopularMoviesFragment extends Fragment {

    RecyclerView recyclerView;
    public static PopularMoviesFragment popularMoviesFragment;
    ImageView nodata_imageview;

    public static PopularMoviesFragment getInstance(){
        if(popularMoviesFragment == null) popularMoviesFragment = new PopularMoviesFragment();
        return popularMoviesFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.movies_grid,null,false);

        recyclerView = view.findViewById(R.id.moviegrid_recyclerview_id);
        nodata_imageview = view.findViewById(R.id.nodata_imageview_id);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));


        MovieServices.getPopularMovies(getResources().getString(R.string.api_key), new PopularMoviesListener() {
            @Override
            public void response(ResponseMovies responseMovies) {
                if(responseMovies != null){
                    nodata_imageview.setVisibility(View.GONE);
                    List<SpecificMovieDetails> movieList = SingletonMovieList.getSpecificMovieDetailsList(responseMovies);
                    SingletonMovieList.setPopularMovies(movieList);
                    //movie type 1 = popular movies, 2 = top rated movies
                    if(movieList!=null)
                    recyclerView.setAdapter(new MovieAdapter(getContext(),movieList,1));
                }else {
                    nodata_imageview.setVisibility(View.VISIBLE);
                }
            }
        });


        return view;
    }


}
