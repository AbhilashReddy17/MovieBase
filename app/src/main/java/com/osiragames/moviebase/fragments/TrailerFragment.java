package com.osiragames.moviebase.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.osiragames.moviebase.MovieInterfaces.MovieVideoListener;
import com.osiragames.moviebase.MovieServices;
import com.osiragames.moviebase.PlayYoutubeVideo;
import com.osiragames.moviebase.R;
import com.osiragames.moviebase.models.MovieVideos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.osiragames.moviebase.Constants.MOVIE_ID;
import static com.osiragames.moviebase.Constants.VIDEO_ID;

public class TrailerFragment extends Fragment {

    public static TrailerFragment fragment;
    int movieId;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_layout,container,false);

        movieId =getArguments().getInt(MOVIE_ID);
        recyclerView = view.findViewById(R.id.reclerview_layout_id);
        MovieServices.getMovieVideos(movieId, getResources().getString(R.string.api_key), new MovieVideoListener() {
            @Override
            public void response(MovieVideos movieVideos) {
                if(movieVideos != null){
                    if(movieVideos.getResults()!=null)
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                                LinearLayoutManager.VERTICAL,false));

                    recyclerView.setAdapter(new RecyclerviewAdapter(movieVideos.getResults()));
                }
            }
        });


        return view;
    }

    public static TrailerFragment getFragment(int movieId) {
        if(fragment == null) fragment= new TrailerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MOVIE_ID,movieId);
        fragment.setArguments(bundle);
        return fragment;
    }

    public class RecyclerviewAdapter extends RecyclerView.Adapter<ReviewViewHolder>{

        List<MovieVideos.Result> results;

        public RecyclerviewAdapter(List<MovieVideos.Result> results){
            this.results = results;
        }

        @NonNull
        @Override
        public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.trailer_thumbnail_layout,null,false);

            return new ReviewViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ReviewViewHolder holder, final int position) {
            holder.movieTitle.setText(results.get(position).getName());
            Picasso.get()
                    .load(getResources().getString(R.string.movieposter_baseurl_w185)+results.get(position).getName())
                    .placeholder(R.drawable.poster_notavailable)
                    .error(R.mipmap.ic_postererror)
                    .into(holder.posterThumbnail);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), PlayYoutubeVideo.class);
                    intent.putExtra(VIDEO_ID,results.get(position).getKey()+"");
                    getContext().startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return results.size();
        }

    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder{

        ImageView posterThumbnail;
        TextView movieTitle;
        View itemView;
        public ReviewViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterThumbnail = itemView.findViewById(R.id.trailer_thumbnailid);
            movieTitle = itemView.findViewById(R.id.image_video_name);
        }
    }
}
