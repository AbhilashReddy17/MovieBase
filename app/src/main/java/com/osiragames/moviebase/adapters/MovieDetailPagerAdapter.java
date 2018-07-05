package com.osiragames.moviebase.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.osiragames.moviebase.R;
import com.osiragames.moviebase.fragments.ReviewFragment;
import com.osiragames.moviebase.fragments.TrailerFragment;

public class MovieDetailPagerAdapter extends FragmentStatePagerAdapter {

    int movieId;
    Context context;

    public MovieDetailPagerAdapter(FragmentManager fm,int movieId,Context context) {
        super(fm);
        this.movieId = movieId;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return ReviewFragment.getFragment(movieId);
            case 1: return TrailerFragment.getFragment(movieId);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
switch (position){
    case 0: return context.getResources().getString(R.string.reviews);
    case 1: return context.getResources().getString(R.string.trailers);
    default: return "";

}
    }
}
