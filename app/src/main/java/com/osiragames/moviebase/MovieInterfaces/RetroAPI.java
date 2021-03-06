package com.osiragames.moviebase.MovieInterfaces;

import com.osiragames.moviebase.models.Movie;
import com.osiragames.moviebase.models.MovieReviews;
import com.osiragames.moviebase.models.MovieVideos;
import com.osiragames.moviebase.models.ResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroAPI {

    @GET("movie/top_rated")
    Call<ResponseMovies> getTopRatedMovies(@Query("api_key") String apiKey);
    @GET("movie/popular")
    Call<ResponseMovies> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/reviews")
    Call<MovieReviews> getMovieReview(@Path("movie_id") int movie_id, @Query("api_key") String apikey);

    @GET("movie/{movie_id}/videos")
    Call<MovieVideos> getMovieVideos(@Path("movie_id") int movie_id, @Query("api_key") String apikey);


}
