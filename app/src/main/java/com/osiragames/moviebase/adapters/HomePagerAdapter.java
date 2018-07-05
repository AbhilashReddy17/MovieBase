package com.osiragames.moviebase.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.osiragames.moviebase.R;
import com.osiragames.moviebase.fragments.PopularMoviesFragment;
import com.osiragames.moviebase.fragments.TopRatedMoviesFragment;

/**
 * Created by ABHI on 7/3/2018.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    Context context;
  public HomePagerAdapter(FragmentManager fragmentManager,Context context){
      super(fragmentManager);
      this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
      if(position == 0){
          return PopularMoviesFragment.getInstance();

      }else{
         return TopRatedMoviesFragment.getInstance();
      }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

     if(position == 0) return context.getResources().getString(R.string.popular_movies);
     else return context.getResources().getString(R.string.top_rated_movies);
    }
}
