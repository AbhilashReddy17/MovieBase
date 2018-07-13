package com.osiragames.moviebase.models.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.osiragames.moviebase.database.MovieDatabase;

/**
 * Created by ABHI on 7/11/2018.
 */

public class FavouriteMovieReviewFactory extends ViewModelProvider.NewInstanceFactory {

    MovieDatabase movieDatabase;
    Context context;

    public FavouriteMovieReviewFactory(MovieDatabase movieDatabase, Context context) {
        this.movieDatabase = movieDatabase;
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new FavouriteMovieReviewViewModel(context,movieDatabase);
    }
}
