package com.osiragames.moviebase.models;

/**
 * Created by ABHI on 7/3/2018.
 */

public class SpecificMovieDetails {

    int movieId;
    String title;
    String posterPath;
    String thumbail_poster;
    String userRating;
    String releaseDate;
    String Synopsis;

    public SpecificMovieDetails(int movieId, String title, String posterPath, String thumbail_poster,
                                String userRating, String releaseDate, String synopsis) {
        this.movieId = movieId;
        this.title = title;
        this.posterPath = posterPath;
        this.thumbail_poster = thumbail_poster;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
        Synopsis = synopsis;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
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
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }
}
