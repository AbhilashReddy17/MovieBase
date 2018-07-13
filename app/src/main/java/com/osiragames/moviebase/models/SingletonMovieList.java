package com.osiragames.moviebase.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABHI on 7/3/2018.
 */

public class SingletonMovieList {

   static SingletonMovieList singletonMovieList;
    static List<FavouriteMovieReview> reviews;
    private SingletonMovieList(){}

    public static List<SpecificMovieDetails> popularMovies,topRatedMovies;

    public static SingletonMovieList getInstance(){
        if(singletonMovieList == null){
            singletonMovieList = new SingletonMovieList();
        }

        return singletonMovieList;
    }

    public static List<FavouriteMovieReview> getReviews() {
        return reviews;
    }

    public static void setReviews(List<FavouriteMovieReview> re) {
       reviews = re;
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


    public static List<SpecificMovieDetails> getSpecificMovieDetailsList(ResponseMovies responseMovies){
        List<SpecificMovieDetails> specificMovieDetailsList;
        if(responseMovies != null) {
            specificMovieDetailsList = new ArrayList<>();
                for(int i=0;i<responseMovies.getResults().size();i++){

                    Movie movie =responseMovies.getResults().get(i);
                    String movieId = movie.getId()+"";
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

    public static List<FavouriteMovieReview> getFavouriteMovieReviews(MovieReviews movieReviews,int movieId){

        List<FavouriteMovieReview> reviews =null;

        if( null!= movieReviews && null!=movieReviews.getResults() && movieReviews.getResults().size()>0)
        {
            reviews = new ArrayList<>();
            for(int i=0;i<movieReviews.getResults().size();i++){
                List<MovieReviews.Result> results = movieReviews.getResults();
                String author= results.get(i).getAuthor();
                String content= results.get(i).getContent();
                FavouriteMovieReview review = new FavouriteMovieReview(movieId,content,author);
                reviews.add(review);
            }
        }
        return reviews;
    }
}
