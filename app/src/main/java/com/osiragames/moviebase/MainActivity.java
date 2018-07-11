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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager = findViewById(R.id.homepage_pager);
        pager.setAdapter(new HomePagerAdapter(getSupportFragmentManager(),this));


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


            } else {
                //not connected to internet
            }
        } else {
            //doesnot have the api key
        }

    }

    private void pushToMainPage() {

    }


}
