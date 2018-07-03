package com.osiragames.moviebase.retroInterface;

import com.osiragames.moviebase.models.Movie;
import com.osiragames.moviebase.models.ResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroAPI {

    @GET("movie/top_rated")
    Call<ResponseMovies> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
