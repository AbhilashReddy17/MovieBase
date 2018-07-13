package com.osiragames.moviebase.models.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.osiragames.moviebase.database.MovieDatabase;
import com.osiragames.moviebase.models.FavouriteMovieReview;
import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.List;

/**
 * Created by ABHI on 7/11/2018.
 */

public class FavouriteMovieReviewViewModel extends ViewModel {
    Context context;
    MovieDatabase database;

    public FavouriteMovieReviewViewModel( Context context, MovieDatabase database) {
        this.context = context;
        this.database = database;
    }

    public LiveData<List<FavouriteMovieReview>> getFavouritemovieReviews(int movieid) {
        return    database.favouriteMovieReviewDao().getFavMovieReviews(movieid);

    }

    public void setFavouritemovieReviews(List<FavouriteMovieReview> favouritemovieReviews) {
        database.favouriteMovieReviewDao().loadFavouriteMovieReviews(favouritemovieReviews);
    }


}
