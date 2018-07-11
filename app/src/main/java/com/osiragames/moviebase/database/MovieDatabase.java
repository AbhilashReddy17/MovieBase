package com.osiragames.moviebase.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.osiragames.moviebase.dao.FavouiteMovieDao;
import com.osiragames.moviebase.dao.FavouriteMovieReviewDao;
import com.osiragames.moviebase.models.FavouriteMovieReview;
import com.osiragames.moviebase.models.SpecificMovieDetails;

import java.util.List;

@Database(entities = {SpecificMovieDetails.class},version = 1,exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public static final String TAG = MovieDatabase.class.getSimpleName();
    private static final String DATABASE_NAME ="movie_database";
    private static final Object LOCK = new Object();
    public static MovieDatabase moviedb;
    public static MovieDatabase getMovieDatabase(Context context){
        if(moviedb == null){
            synchronized (LOCK){

                Log.d(TAG, "getMovieDatabase: creating");
                moviedb = Room.databaseBuilder(context.getApplicationContext(),
                        MovieDatabase.class, DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        Log.d(TAG, "getMovieDatabase: returning");

        return moviedb;
    }

  public abstract FavouiteMovieDao favouiteMovieDao();
}
