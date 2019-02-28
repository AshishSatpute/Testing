package com.example.videoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoPlayer extends AppCompatActivity {
    VideoView videoView;
    private Uri uri;
    String uriPath = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        //Set MediaController  to enable play, pause, forward, etc options.
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        //Location of Media File
        uri = Uri.parse(uriPath);
        //Starting VideView By Setting MediaController and URI
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
