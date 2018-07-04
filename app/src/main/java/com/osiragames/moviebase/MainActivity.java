package com.osiragames.moviebase;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.osiragames.moviebase.MovieInterfaces.MovieReviewListener;
import com.osiragames.moviebase.MovieInterfaces.MovieVideoListener;
import com.osiragames.moviebase.MovieInterfaces.PopularMoviesListener;
import com.osiragames.moviebase.MovieInterfaces.TopRatedMovieListener;
import com.osiragames.moviebase.adapters.HomePagerAdapter;
import com.osiragames.moviebase.models.MovieReviews;
import com.osiragames.moviebase.models.MovieVideos;
import com.osiragames.moviebase.models.ResponseMovies;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager = findViewById(R.id.homepage_pager);
        pager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //checking for the internet connectivity

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        String api_key = getResources().getString(R.string.api_key);
        if (!api_key.equalsIgnoreCase("")) {
            //have the api key
            if (isConnected) {
                //has connected to internet

                pushToMainPage();

//                //top rated movies
//                MovieServices.getTopRatedMovies(api_key, new TopRatedMovieListener() {
//                    @Override
//                    public void response(ResponseMovies responseMovies) {
//                        if (responseMovies != null) {
//
//                        }
//                    }
//                });

                //popular movies

//                MovieServices.getPopularMovies(api_key, new PopularMoviesListener() {
//
//                    @Override
//                    public ResponseMovies response(ResponseMovies responseMovies) {
//                        if (responseMovies != null) {
//
//                        }
//                        return null;
//                    }
//                });

//                int movie_id = 351286;
                //Movie Reviews

//                MovieServices.getMovieReviews(movie_id,api_key, new MovieReviewListener() {
//                    @Override
//                    public void response(MovieReviews movieReview) {
//
//                    }
//                });

//                //movie Videos
//
//                MovieServices.getMovieVideos(movie_id,api_key, new MovieVideoListener() {
//                    @Override
//                    public void response(MovieVideos movieVideos) {
//
//                    }
//                });


            } else {
                //not connected to internet
            }
        } else {
            //doesnot have the api key
        }

    }

    private void pushToMainPage() {

    }

    public interface MovieListener {
        public void getTopRated();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
