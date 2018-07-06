package com.osiragames.moviebase.models.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.osiragames.moviebase.database.MovieDatabase;
import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.List;

public class FavouriteViewModel extends ViewModel {
    private LiveData<List<SpecificMovieDetails>> favouritemovies;
    Context context;
    MovieDatabase database;
   public FavouriteViewModel(Context context){
       this.context = context;
       database = MovieDatabase.getMovieDatabase(context);
   }

    private LiveData<List<SpecificMovieDetails>> loadFavouriteMovies(){
        favouritemovies = database.favouiteMovieDao().getFavouriteMovies();
       return favouritemovies;
    }

}
