package com.osiragames.moviebase.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "favourite_movie_review",foreignKeys = @ForeignKey(entity = SpecificMovieDetails.class,
        parentColumns = "movie_id",
        childColumns = "movie_id",
        onDelete = ForeignKey.CASCADE))
public class FavouriteMovieReview {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;
    @ColumnInfo(name = "movie_id")
    int movieid;
    @ColumnInfo(name = "movie_review")
    String moviereview;
    @ColumnInfo(name = "author")
    String author;

}
