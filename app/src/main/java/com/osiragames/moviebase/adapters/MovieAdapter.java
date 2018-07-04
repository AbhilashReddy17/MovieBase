package com.osiragames.moviebase.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

    public MovieAdapter(Context context,List<SpecificMovieDetails> moviesList){

        this.context = context;
        this.moviesList = moviesList;
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
        Picasso.get()
                .load(moviesList.get(position).getPosterPath())
                .placeholder(R.mipmap.ic_movieposter_holder)
                .error(R.mipmap.ic_posterError)
                .centerCrop()
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
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
