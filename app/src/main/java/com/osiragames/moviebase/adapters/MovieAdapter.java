package com.osiragames.moviebase.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osiragames.moviebase.R;

/**
 * Created by ABHI on 7/3/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;

    public MovieAdapter(Context context){

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_poster,null,false);
        MovieViewHolder holder = new MovieViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public MovieViewHolder(View itemView) {
            super(itemView);
        }
    }
}
