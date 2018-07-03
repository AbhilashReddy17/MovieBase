package com.osiragames.moviebase;

import android.util.Log;

import com.osiragames.moviebase.MovieInterfaces.PopularMoviesListener;
import com.osiragames.moviebase.MovieInterfaces.TopRatedMovieListener;
import com.osiragames.moviebase.models.ResponseMovies;
import com.osiragames.moviebase.models.SingletonData;
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
                    SingletonData.setResponseMovies(response.body());
                    topRatedMovieListener.setTopRatedMoviesResponse(response.body());
                }else
                    topRatedMovieListener.setTopRatedMoviesResponse(null);
            }

            @Override
            public void onFailure(Call<ResponseMovies> call, Throwable t) {
                Log.d(TAG, "onFailure: TopRated Movies");
                topRatedMovieListener.setTopRatedMoviesResponse(null);
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
                    SingletonData.setResponseMovies(response.body());
                    popularMoviesListener.setPopularMoviesResponse(response.body());
                }else
                    popularMoviesListener.setPopularMoviesResponse(null);
            }

            @Override
            public void onFailure(Call<ResponseMovies> call, Throwable t) {

            }
        });
    }


}
