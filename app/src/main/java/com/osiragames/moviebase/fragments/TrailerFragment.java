package com.osiragames.moviebase.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.osiragames.moviebase.MovieInterfaces.MovieVideoListener;
import com.osiragames.moviebase.MovieServices;
import com.osiragames.moviebase.R;
import com.osiragames.moviebase.models.MovieVideos;

import java.util.ArrayList;
import java.util.List;

import static com.osiragames.moviebase.Constants.MOVIE_ID;

public class TrailerFragment extends Fragment {

    public static ReviewFragment fragment;
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

    public static ReviewFragment getFragment(int movieId) {
        if(fragment == null) fragment= new ReviewFragment();
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
        public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return results.size();
        }

    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder{

        public ReviewViewHolder(View itemView) {
            super(itemView);

        }
    }
}
