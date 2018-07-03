package com.osiragames.moviebase;

import android.util.Log;

import com.osiragames.moviebase.MovieInterfaces.MovieReviewListener;
import com.osiragames.moviebase.MovieInterfaces.MovieVideoListener;
import com.osiragames.moviebase.MovieInterfaces.PopularMoviesListener;
import com.osiragames.moviebase.MovieInterfaces.TopRatedMovieListener;
import com.osiragames.moviebase.models.MovieReviews;
import com.osiragames.moviebase.models.MovieVideos;
import com.osiragames.moviebase.models.ResponseMovies;
import com.osiragames.moviebase.retroInterface.RetroAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieServices {


    public static final String TAG = MovieServices.class.getSimpleName();

    //calling the toprated movies

    public static void getTopRatedMovies(String api_key, final TopRatedMovieListener topRatedMovieListener){
        RetroAPI apiInterface = Controller.getClient().create(RetroAPI.class);
        apiInterface.getTopRatedMovies(api_key).enqueue(new Callback<ResponseMovies>() {
            @Override
            public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: recived the top rated movies");
                    topRatedMovieListener.response(response.body());
                }else
                    topRatedMovieListener.response(null);
            }

            @Override
            public void onFailure(Call<ResponseMovies> call, Throwable t) {
                Log.d(TAG, "onFailure: TopRated Movies");
                topRatedMovieListener.response(null);
            }
        });

    }


    //calling the popular movies

    public static void getPopularMovies(String api_key,final PopularMoviesListener popularMoviesListener){
        RetroAPI apiInterface = Controller.getClient().create(RetroAPI.class);
        apiInterface.getPopularMovies(api_key).enqueue(new Callback<ResponseMovies>() {
            @Override
            public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: recived the top rated movies");

                    popularMoviesListener.response(response.body());
                }else
                    popularMoviesListener.response(null);
            }

            @Override
            public void onFailure(Call<ResponseMovies> call, Throwable t) {

            }
        });
    }

    public static void getMovieReviews(int movie_id,String api_key, final MovieReviewListener movieReviewListener){
        RetroAPI apiInterface = Controller.getClient().create(RetroAPI.class);
        apiInterface.getMovieReview(movie_id,api_key).enqueue(new Callback<MovieReviews>() {
            @Override
            public void onResponse(Call<MovieReviews> call, Response<MovieReviews> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: recived the top rated movies");

                    movieReviewListener.response(response.body());
                }else
                    movieReviewListener.response(null);
            }

            @Override
            public void onFailure(Call<MovieReviews> call, Throwable t) {
                movieReviewListener.response(null);
            }
        });

    }


    public static void getMovieVideos(int movie_id,String api_key, final MovieVideoListener movieVideoListener){
        RetroAPI apiInterface = Controller.getClient().create(RetroAPI.class);
        apiInterface.getMovieVideos(movie_id,api_key).enqueue(new Callback<MovieVideos>() {
            @Override
            public void onResponse(Call<MovieVideos> call, Response<MovieVideos> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: recived the top rated movies");

                    movieVideoListener.response(response.body());
                }else
                    movieVideoListener.response(null);
            }

            @Override
            public void onFailure(Call<MovieVideos> call, Throwable t) {
                movieVideoListener.response(null);
            }
        });

    }





}
