package com.osiragames.moviebase.models.viewmodels;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Query;
import android.content.Context;

import com.osiragames.moviebase.AppExecutors;
import com.osiragames.moviebase.database.MovieDatabase;
import com.osiragames.moviebase.models.FavouriteMovieReview;
import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.List;
import java.util.concurrent.Executors;

public class FavouriteViewModel extends ViewModel {
    private LiveData<List<SpecificMovieDetails>> favouritemovies;
    Context context;
    MovieDatabase database;

    LiveData<SpecificMovieDetails> movie;

    public FavouriteViewModel(Context context,MovieDatabase movieDatabase){
       this.context = context;
       database = movieDatabase;
        favouritemovies = database.favouiteMovieDao().getFavouriteMovies();

    }

    public LiveData<List<SpecificMovieDetails>> loadFavouriteMovies(){

//       Executors.newSingleThreadExecutor().execute(new Runnable() {
//           @Override
//           public void run() {
//               favouritemovies = database.favouiteMovieDao().getFavouriteMovies();
//
//           }
//       });

       return favouritemovies;
    }

    public void markFavouriteMovie(final SpecificMovieDetails specificMovieDetails){

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
        database.favouiteMovieDao().insertFavouriteMovie(specificMovieDetails);
            }
        });

    }

    public void removeFavouriteMovie(final SpecificMovieDetails movieDetails){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
        database.favouiteMovieDao().deleteFavouriteMovie(movieDetails);
    }
});

        }

    public LiveData<SpecificMovieDetails> getFavouriteMovie(final int movieid) {
//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                 movie= database.favouiteMovieDao().getFavoriteMovie(movieid);
//            }
//        });
        movie= database.favouiteMovieDao().getFavoriteMovie( movieid);
        return movie;
    }


}
