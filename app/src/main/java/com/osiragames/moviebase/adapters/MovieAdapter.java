package com.osiragames.moviebase.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.osiragames.moviebase.MovieDetailActivity;
import com.osiragames.moviebase.R;
import com.osiragames.moviebase.models.SpecificMovieDetails;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by ABHI on 7/3/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;

    List<SpecificMovieDetails> moviesList;
    int movieType;

    public MovieAdapter(Context context,List<SpecificMovieDetails> moviesList,int movieType){

        //movie type 1 = popular movies, 2 = top rated movies
        this.context = context;
        this.movieType = movieType;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.movie_poster, null, false);
            MovieViewHolder holder = new MovieViewHolder(view);
            return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        Picasso.get()
                .load(context.getResources().getString(R.string.movieposter_baseurl_w185)+moviesList.get(position).getPosterPath())
                .placeholder(R.drawable.poster_notavailable)
                .error(R.mipmap.ic_postererror)
                .into(holder.poster);

        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.MOVIE_POSITION,position);
               intent.putExtra(MovieDetailActivity.MOVIE_TYPE,movieType);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        if(moviesList == null) return 0;
        return moviesList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        public MovieViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.movieposter_imageview_id);

        }
    }
}
