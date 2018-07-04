package com.osiragames.moviebase.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABHI on 7/3/2018.
 */

public class SingletonMovieList {

   static SingletonMovieList singletonMovieList;
    private SingletonMovieList(){}

    public static List<SpecificMovieDetails> popularMovies,topRatedMovies;

    public static SingletonMovieList getInstance(){
        if(singletonMovieList == null){
            singletonMovieList = new SingletonMovieList();
        }

        return singletonMovieList;
    }

    public static List<SpecificMovieDetails> getPopularMovies() {
        return popularMovies;
    }

    public static void setPopularMovies(List<SpecificMovieDetails> popularMovies) {
        SingletonMovieList.popularMovies = popularMovies;
    }

    public static List<SpecificMovieDetails> getTopRatedMovies() {
        return topRatedMovies;
    }

    public static void setTopRatedMovies(List<SpecificMovieDetails> topRatedMovies) {
        SingletonMovieList.topRatedMovies = topRatedMovies;
    }

    public void addPopularMovie(SpecificMovieDetails movieDetails){
        popularMovies.add(movieDetails);
    }
    public void addTopRatedMovie(SpecificMovieDetails movieDetails){
        topRatedMovies.add(movieDetails);
    }

    public static List<SpecificMovieDetails> getSpecificMovieDetailsList(ResponseMovies responseMovies){
        List<SpecificMovieDetails> specificMovieDetailsList;
        if(responseMovies != null) {
            specificMovieDetailsList = new ArrayList<>();
                for(int i=0;i<responseMovies.getResults().size();i++){

                    Movie movie =responseMovies.getResults().get(i);
                    int movieId = movie.getId();
                    String title = movie.getOriginalTitle();
                    String posterPath = movie.getPosterPath() ;
                    String thumbail_poster = movie.getBackdropPath();
                    String userRating = movie.getVoteAverage()+"";
                    String releaseDate = movie.getReleaseDate();
                    String synopsis = movie.getOverview();
                    SpecificMovieDetails specificMovieDetails = new SpecificMovieDetails(movieId,title,posterPath,thumbail_poster,
                            userRating,releaseDate,synopsis);

                    specificMovieDetailsList.add(specificMovieDetails);
                }
               return specificMovieDetailsList;
        }
        return null;
    }
}
