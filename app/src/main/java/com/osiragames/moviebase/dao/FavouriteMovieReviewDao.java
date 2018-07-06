package com.osiragames.moviebase.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.osiragames.moviebase.models.FavouriteMovieReview;

import java.util.List;

@Dao
public interface FavouriteMovieReviewDao {
    @Query("SELECT * from favourite_movie_review where movie_id = :movieid")
    public List<FavouriteMovieReview> getFavMovieReview(int movieid);

}
