package com.osiragames.moviebase.models.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.osiragames.moviebase.database.MovieDatabase;
import com.osiragames.moviebase.models.FavouriteMovieReview;
import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by ABHI on 7/11/2018.
 */

public class FavouriteMovieReviewViewModel extends ViewModel {
    Context context;
    MovieDatabase database;

    public FavouriteMovieReviewViewModel( Context context) {
        this.context = context;
        this.database = MovieDatabase.getMovieDatabase(context);
    }

    public LiveData<List<FavouriteMovieReview>> getFavouritemovieReviews(int movieid) {
        return    database.favouriteMovieReviewDao().getFavMovieReviews(movieid);

    }

    public void setFavouritemovieReviews(final List<FavouriteMovieReview> favouritemovieReviews) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                database.favouriteMovieReviewDao().loadFavouriteMovieReviews(favouritemovieReviews);

            }
        });
    }


}
