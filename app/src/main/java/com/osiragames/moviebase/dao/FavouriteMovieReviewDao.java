package com.osiragames.moviebase.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.osiragames.moviebase.models.FavouriteMovieReview;

import java.util.List;

@Dao
public interface FavouriteMovieReviewDao {
    @Query("SELECT * from favourite_movie_review where movie_id = :movieid")
    public LiveData<List<FavouriteMovieReview>> getFavMovieReviews(int movieid);

    @Insert
    public void loadFavouriteMovieReviews(List<FavouriteMovieReview> favouriteMovieReviews);
}
