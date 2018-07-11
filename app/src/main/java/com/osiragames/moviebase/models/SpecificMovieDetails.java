package com.osiragames.moviebase.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ABHI on 7/3/2018.
 */

@Entity(tableName = "specific_movie_details")
public class SpecificMovieDetails {

    @PrimaryKey
    @NonNull
     @ColumnInfo(name = "movie_id")
     private String movieId;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "poster_path")
    private String posterPath;
    @ColumnInfo(name = "thumbnail_poster")
    private String thumbail_poster;
    @ColumnInfo(name = "user_rating")
    private String userRating;
    @ColumnInfo(name = "release_date")
    private String releaseDate;
    @ColumnInfo(name = "synopsis")
    private String synopsis;

    public SpecificMovieDetails(String movieId, String title, String posterPath, String thumbail_poster,
                                String userRating, String releaseDate, String synopsis) {
        this.movieId = movieId;

        this.title = title;
        this.posterPath = posterPath;
        this.thumbail_poster = thumbail_poster;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
    }



    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getThumbail_poster() {
        return thumbail_poster;
    }

    public void setThumbail_poster(String thumbail_poster) {
        this.thumbail_poster = thumbail_poster;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
