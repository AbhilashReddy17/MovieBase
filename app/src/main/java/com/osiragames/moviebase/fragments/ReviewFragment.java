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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osiragames.moviebase.Constants;
import com.osiragames.moviebase.MovieDetailActivity;
import com.osiragames.moviebase.MovieInterfaces.MovieReviewListener;
import com.osiragames.moviebase.MovieServices;
import com.osiragames.moviebase.R;
import com.osiragames.moviebase.models.MovieReviews;

import java.util.ArrayList;
import java.util.List;

public class ReviewFragment extends Fragment
{
    public static final String MOVIE_ID = "movie_id";

    public static ReviewFragment fragment;
    int movieId;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_layout,container,false);

        movieId =getArguments().getInt(Constants.MOVIE_ID);
        recyclerView = view.findViewById(R.id.reclerview_layout_id);
        MovieServices.getMovieReviews(movieId, getResources().getString(R.string.api_key), new MovieReviewListener() {
            @Override
            public void response(MovieReviews movieReview) {
                if(movieReview !=  null){
                          if(movieReview.getResults() != null){
                              recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                                      LinearLayoutManager.VERTICAL,false));
                              recyclerView.setAdapter(new RecyclerviewAdapter(movieReview.getResults()));
                          }
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

        List<MovieReviews.Result> results;

        public RecyclerviewAdapter(List<MovieReviews.Result> results){
            this.results = results;
        }

        @NonNull
        @Override
        public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.review_layout,null,false);

            return new ReviewViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

            holder.reviewAuthor.setText(results.get(position).getAuthor());
            holder.reviewContent.setText(results.get(position).getContent());
        }

        @Override
        public int getItemCount() {
            return results.size();
        }

    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder{
        TextView reviewContent,reviewAuthor;
        public ReviewViewHolder(View itemView) {
            super(itemView);

            reviewContent = itemView.findViewById(R.id.review_content_id);
            reviewAuthor = itemView.findViewById(R.id.review_author_id);
        }
    }
}
