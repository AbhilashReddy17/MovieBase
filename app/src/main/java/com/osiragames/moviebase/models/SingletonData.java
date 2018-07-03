package com.osiragames.moviebase.models;

import com.osiragames.moviebase.MovieServices;

public class SingletonData {
 static  ResponseMovies responseMovies;
    static Movie movie;
    static MovieServices movieServices;

    public static  ResponseMovies getResponseMovies() {
        if(responseMovies == null)
            responseMovies = new ResponseMovies();
        return responseMovies;
    }

    public static void setResponseMovies(ResponseMovies responseMovies) {
        SingletonData.responseMovies = responseMovies;
    }

    public static void setMovie(Movie movie) {
        SingletonData.movie = movie;
    }

    public static Movie getMovie(int id){
        if(movie == null)
            movie = new Movie();
        return movie;
    }

    public static MovieServices getMovieServices(){
        if(movieServices == null) movieServices = new MovieServices();

        return movieServices;
    }

}
