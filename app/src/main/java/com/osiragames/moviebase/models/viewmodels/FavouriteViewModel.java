package com.osiragames.moviebase.models.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Query;
import android.content.Context;

import com.osiragames.moviebase.AppExecutors;
import com.osiragames.moviebase.database.MovieDatabase;
import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.List;

public class FavouriteViewModel extends ViewModel {
    private LiveData<List<SpecificMovieDetails>> favouritemovies;
    Context context;
    MovieDatabase database;

   public FavouriteViewModel(Context context,MovieDatabase movieDatabase){
       this.context = context;
       database = movieDatabase;
   }

    public LiveData<List<SpecificMovieDetails>> loadFavouriteMovies(){
        favouritemovies = database.favouiteMovieDao().getFavouriteMovies();

       return favouritemovies;
    }

    public void markFavouriteMovie(SpecificMovieDetails specificMovieDetails){
        database.favouiteMovieDao().insertFavouriteMovie(specificMovieDetails);
    }

    public void removeFavouriteMovie(SpecificMovieDetails movieDetails){
        database.favouiteMovieDao().deleteFavouriteMovie(movieDetails);
    }

    public LiveData<SpecificMovieDetails> getFavouriteMovie(int movieid){
        return database.favouiteMovieDao().getFavoriteMovie(movieid);
    }

}
