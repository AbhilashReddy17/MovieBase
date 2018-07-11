package com.osiragames.moviebase.models.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.osiragames.moviebase.database.MovieDatabase;
import com.osiragames.moviebase.models.SpecificMovieDetails;

/**
 * Created by ABHI on 7/8/2018.
 */

public class FavouriteViewModelFactory extends ViewModelProvider.NewInstanceFactory {


    MovieDatabase movieDatabase;
    Context context;

    public FavouriteViewModelFactory(MovieDatabase movieDatabase, Context context) {
        this.movieDatabase = movieDatabase;
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new FavouriteViewModel(context,movieDatabase);
    }
}
