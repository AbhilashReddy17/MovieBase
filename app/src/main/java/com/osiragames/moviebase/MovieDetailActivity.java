package com.osiragames.moviebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.osiragames.moviebase.adapters.MovieDetailPagerAdapter;
import com.osiragames.moviebase.models.Movie;
import com.osiragames.moviebase.models.SingletonMovieList;
import com.osiragames.moviebase.models.SpecificMovieDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE_POSITION ="pos_movie";
    public static final String MOVIE_TYPE ="movie_type";

    int movieType;
    int moview_pos;
    SpecificMovieDetails movie;
    ImageView poster;
    TextView title,date,synopsis,rating;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

  movieType = getIntent().getIntExtra(MOVIE_TYPE,1);
        moview_pos = getIntent().getIntExtra(MOVIE_POSITION,1);

        switch (movieType){
            //movie type 1 = popular movies, 2 = top rated movies
            case 1:
                movie = SingletonMovieList.getInstance().getPopularMovies().get(moview_pos);
                break;

            case 2:
                movie = SingletonMovieList.getTopRatedMovies().get(moview_pos);
                break;
                default: movie = null;
        }

        poster= findViewById(R.id.moviebasic_details_posterid);
        title = findViewById(R.id.moviebasic_details_titleid);
        rating = findViewById(R.id.moviebasic_detials_ratingid);
        synopsis = findViewById(R.id.moviebasic_details_synopsisid);
        date = findViewById(R.id.moviebasic_details_releasdateid);

        if(movie!=null){

            viewPager = findViewById(R.id.movie_details_viewpager_id);
            viewPager.setAdapter(new MovieDetailPagerAdapter(getSupportFragmentManager(),movie.getMovieId(),this));

            Picasso.get()
                    .load(getResources().getString(R.string.movieposter_baseurl)+movie.getPosterPath())
                    .placeholder(R.drawable.poster_notavailable)
                    .error(R.mipmap.ic_postererror)
                    .into(poster);

            title.setText(movie.getTitle());
            date.setText(movie.getReleaseDate());
            rating.setText(movie.getUserRating());
            synopsis.setText(movie.getSynopsis());
        }


    }
}
