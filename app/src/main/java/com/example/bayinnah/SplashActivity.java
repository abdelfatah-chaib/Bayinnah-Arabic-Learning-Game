package com.example.bayinnah;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends Activity {

    private ProgressBar mProgressBar;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the status bar and make the activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setIndeterminate(false);
        mProgressBar.setProgress(0);
        mProgressBar.setMax(100);
        mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_horizontal));

        // Define the delay and increment amount for updating the progress bar
        final int delayMillis = 100; // Delay between each increment in milliseconds
        final int incrementAmount = 3; // Amount to increment the progress bar by

        // Create a handler to update the progress bar
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                // Increment the progress and update the progress bar
                progress += incrementAmount;
                mProgressBar.setProgress(progress);

                if (progress < mProgressBar.getMax()) {
                    // If progress is not yet complete, delay the next update
                    handler.postDelayed(this, delayMillis);
                } else {
                    // If progress is complete, start the MainActivity
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, delayMillis); // Start updating the progress bar after a short delay

        // Play the sound
        mMediaPlayer = MediaPlayer.create(this, R.raw.soundgame);
        mMediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer resources
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
