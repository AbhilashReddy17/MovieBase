package com.osiragames.moviebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static com.osiragames.moviebase.Constants.VIDEO_ID;

/**
 * Created by ABHI on 7/5/2018.
 */

public class PlayYoutubeVideo extends YouTubeBaseActivity {

YouTubePlayerView playerView;
ImageView youtubeLogo,notfoundImage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_player);

        final String videoId = getIntent().getStringExtra(VIDEO_ID);
        youtubeLogo = findViewById(R.id.youtube_logo_id);
        notfoundImage = findViewById(R.id.youtube_video_notfound_id);

        playerView = findViewById(R.id.youtubeplayer_id);
        playerView.initialize(Config.API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                notfoundImage.setVisibility(View.GONE);
                youtubeLogo.setVisibility(View.GONE);
                youTubePlayer.cueVideo(videoId);
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                notfoundImage.setVisibility(View.VISIBLE);
                youtubeLogo.setVisibility(View.GONE);
            }
        });


    }
}
