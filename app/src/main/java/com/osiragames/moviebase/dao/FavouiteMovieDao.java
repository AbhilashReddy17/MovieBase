package com.osiragames.moviebase.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface FavouiteMovieDao {
    @Query("SELECT * from specific_movie_details")
    public LiveData<List<SpecificMovieDetails>> getFavouriteMovies();

    @Query("SELECT * from specific_movie_details where id = :id")
    public LiveData<SpecificMovieDetails> getFavoriteMovie(int id);

    @Delete
    public int deleteFavouriteMovie(SpecificMovieDetails favouriteMovie);

    @Insert(onConflict = REPLACE)
    public void insertFavouriteMovie(SpecificMovieDetails favouriteMovies);
}
