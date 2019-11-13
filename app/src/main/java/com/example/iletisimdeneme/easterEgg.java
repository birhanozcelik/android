package com.example.iletisimdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class easterEgg extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);
        videoView = findViewById(R.id.videoView);

                String videoPath = "android.resource://com.example.iletisimdeneme/"+R.raw.deneme2;
                Uri uri = Uri.parse(videoPath);
                videoView.setVideoURI(uri);
                //videoView.setMediaController(null);
                videoView.start();
                //videoView.seekTo(1);
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });



    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
