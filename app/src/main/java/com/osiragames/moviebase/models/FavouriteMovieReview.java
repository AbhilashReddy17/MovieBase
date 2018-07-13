package com.osiragames.moviebase.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
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

    public FavouriteMovieReview(int id, int movieid, String moviereview, String author) {
        this.id = id;
        this.movieid = movieid;
        this.moviereview = moviereview;
        this.author = author;
    }

    @Ignore
    public FavouriteMovieReview( int movieid, String moviereview, String author) {

        this.movieid = movieid;
        this.moviereview = moviereview;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getMoviereview() {
        return moviereview;
    }

    public void setMoviereview(String moviereview) {
        this.moviereview = moviereview;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
