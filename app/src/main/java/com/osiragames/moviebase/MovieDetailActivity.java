package com.osiragames.moviebase;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.osiragames.moviebase.adapters.MovieDetailPagerAdapter;
import com.osiragames.moviebase.database.MovieDatabase;
import com.osiragames.moviebase.models.Movie;
import com.osiragames.moviebase.models.SingletonMovieList;
import com.osiragames.moviebase.models.SpecificMovieDetails;
import com.osiragames.moviebase.models.viewmodels.FavouriteViewModel;
import com.osiragames.moviebase.models.viewmodels.FavouriteViewModelFactory;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE_POSITION = "pos_movie";
    public static final String MOVIE_TYPE = "movie_type";

    int movieType;
    int moview_pos;
    SpecificMovieDetails movie;
    ImageView poster;
    TextView title, date, synopsis, rating;
    ViewPager viewPager;
    ImageView fav_icon;
    boolean clickedFav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);


        movieType = getIntent().getIntExtra(MOVIE_TYPE, 1);
        moview_pos = getIntent().getIntExtra(MOVIE_POSITION, 1);

        switch (movieType) {
            //movie type 1 = popular movies, 2 = top rated movies
            case 1:
                movie = SingletonMovieList.getInstance().getPopularMovies().get(moview_pos);
                break;

            case 2:
                movie = SingletonMovieList.getTopRatedMovies().get(moview_pos);
                break;
            default:
                movie = null;
        }

        poster = findViewById(R.id.moviebasic_details_posterid);
        title = findViewById(R.id.moviebasic_details_titleid);
        rating = findViewById(R.id.moviebasic_detials_ratingid);
        synopsis = findViewById(R.id.moviebasic_details_synopsisid);
        date = findViewById(R.id.moviebasic_details_releasdateid);
        fav_icon = findViewById(R.id.fav_icon);
        clickedFav = false;

        if (movie != null) {

            viewPager = findViewById(R.id.movie_details_viewpager_id);
            viewPager.setAdapter(new MovieDetailPagerAdapter(getSupportFragmentManager(), movie.getMovieId(), this));

            Picasso.get()
                    .load(getResources().getString(R.string.movieposter_baseurl_w500) + movie.getPosterPath())
                    .placeholder(R.drawable.poster_notavailable)
                    .error(R.mipmap.ic_postererror)
                    .into(poster);

            title.setText(movie.getTitle());
            date.setText(movie.getReleaseDate());
            rating.setText(movie.getUserRating());
            synopsis.setText(movie.getSynopsis());
        }
        FavouriteViewModelFactory factory = new FavouriteViewModelFactory(movie,
                MovieDatabase.getMovieDatabase(getApplicationContext()),getApplicationContext());
        FavouriteViewModel viewModel = ViewModelProviders.of(MovieDetailActivity.this,factory).get(FavouriteViewModel.class);
        viewModel.getFavouriteMovie(movie.getMovieId()).observe(this, new Observer<SpecificMovieDetails>() {
            @Override
            public void onChanged(@Nullable SpecificMovieDetails movieDetails) {
                if(movieDetails == null)   fav_icon.setImageResource(R.mipmap.ic_not_favourite);
                else   fav_icon.setImageResource(R.mipmap.ic_favourite);
            }
        });

        viewModel.markFavouriteMovie(movie);

        fav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavouriteViewModelFactory factory = new FavouriteViewModelFactory(movie,
                        MovieDatabase.getMovieDatabase(getApplicationContext()),getApplicationContext());
                Drawable.ConstantState constantState = fav_icon.getDrawable().getConstantState();
                Drawable.ConstantState constantState1 = getResources().getDrawable(R.mipmap.ic_not_favourite).getConstantState();

                if (fav_icon.getDrawable().getConstantState().equals(getResources().getDrawable(R.mipmap.ic_not_favourite).getConstantState())) {
                    if (movie != null) {
                        fav_icon.setImageResource(R.mipmap.ic_favourite);

                         FavouriteViewModel viewModel = ViewModelProviders.of(MovieDetailActivity.this,factory).get(FavouriteViewModel.class);

                         viewModel.markFavouriteMovie(movie);
                       // MovieDatabase.getMovieDatabase(getApplicationContext()).favouiteMovieDao().insertFavouriteMovie(movie);

                    } else {
                        Toast.makeText(MovieDetailActivity.this, "There is someproblem saving", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    if (movie != null) {
                        fav_icon.setImageResource(R.mipmap.ic_not_favourite);
                        FavouriteViewModel viewModel = ViewModelProviders.of(MovieDetailActivity.this,factory).get(FavouriteViewModel.class);
                        viewModel.removeFavouriteMovie(movie);
                       // MovieDatabase.getMovieDatabase(getApplicationContext()).favouiteMovieDao().deleteFavouriteMovie(movie);
                    } else {
                        Toast.makeText(MovieDetailActivity.this, "There is some problem ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

}
