package com.example.bayinnah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorsActivity extends AppCompatActivity {
    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        TextView mot_txt = findViewById(R.id.txt_mot);
        ImageView img_mot = findViewById(R.id.mot_img);
        Button btn_suivant= findViewById(R.id.btn_next);
        Button playButton = findViewById(R.id.btn_hear);
        Button buttonExit = findViewById(R.id.btn_exit);

        //button Exit
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ColorsActivity.this, HomeActivity.class);
                startActivity(intent); }
        });

        //Lire premiere mot
        playButton.setOnClickListener(new View.OnClickListener() {
            //mot 1
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    // Arrêter la lecture en cours
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                // Charger et jouer le fichier audio
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.black);
                mediaPlayer.start();
            }

        });
        btn_suivant.setOnClickListener(new View.OnClickListener() {
            //mot2
            @Override
            public void onClick(View v) {
                img_mot.setImageResource(R.drawable.blue);
                mot_txt.setText("اللَّوْنُ الْأَزْرَقُ ");
                // Change the audio
                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                            // Arrêter la lecture en cours
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }
                        // Charger et jouer le fichier audio
                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.blue);
                        mediaPlayer.start();
                        //mot3
                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                img_mot.setImageResource(R.drawable.gray);
                                mot_txt.setText("اللَّوْنُ الرَّمَادِيُ ");
                                // Change the audio
                                playButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                            // Arrêter la lecture en cours
                                            mediaPlayer.stop();
                                            mediaPlayer.release();
                                            mediaPlayer = null;
                                        }
                                        // Charger et jouer le fichier audio
                                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.gray);
                                        mediaPlayer.start();
                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                            //mot4
                                            @Override
                                            public void onClick(View v) {
                                                img_mot.setImageResource(R.drawable.green);
                                                mot_txt.setText("اللَّوْنُ الْأَخْضَرُ ");
                                                // Change the audio
                                                playButton.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                                            // Arrêter la lecture en cours
                                                            mediaPlayer.stop();
                                                            mediaPlayer.release();
                                                            mediaPlayer = null;
                                                        }
                                                        // Charger et jouer le fichier audio
                                                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.green);
                                                        mediaPlayer.start();
                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                            //mot5
                                                            @Override
                                                            public void onClick(View v) {
                                                                img_mot.setImageResource(R.drawable.orange);
                                                                mot_txt.setText("اللَّوْنَ الْبُرْتُقَالِيُّ ");
                                                                // Change the audio
                                                                playButton.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                                                            // Arrêter la lecture en cours
                                                                            mediaPlayer.stop();
                                                                            mediaPlayer.release();
                                                                            mediaPlayer = null;
                                                                        }
                                                                        // Charger et jouer le fichier audio
                                                                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.orange);
                                                                        mediaPlayer.start();
                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                            //mot6
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                img_mot.setImageResource(R.drawable.pink);
                                                                                mot_txt.setText("اللَّوْنُ الْوَرْدِيُّ");
                                                                                // Change the audio
                                                                                playButton.setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                                                                            // Arrêter la lecture en cours
                                                                                            mediaPlayer.stop();
                                                                                            mediaPlayer.release();
                                                                                            mediaPlayer = null;
                                                                                        }
                                                                                        // Charger et jouer le fichier audio
                                                                                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.pink);
                                                                                        mediaPlayer.start();
                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                            //mot7
                                                                                            @Override
                                                                                            public void onClick(View v) {
                                                                                                img_mot.setImageResource(R.drawable.purpule);
                                                                                                mot_txt.setText("اللَّوْنُ الْبَنَفْسَجِيُّ");
                                                                                                // Change the audio
                                                                                                playButton.setOnClickListener(new View.OnClickListener() {
                                                                                                    @Override
                                                                                                    public void onClick(View v) {
                                                                                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                                                                                            // Arrêter la lecture en cours
                                                                                                            mediaPlayer.stop();
                                                                                                            mediaPlayer.release();
                                                                                                            mediaPlayer = null;
                                                                                                        }
                                                                                                        // Charger et jouer le fichier audio
                                                                                                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.purple);
                                                                                                        mediaPlayer.start();
                                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                                            //mot8
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                img_mot.setImageResource(R.drawable.red);
                                                                                                                mot_txt.setText("اللَّوْنُ الْأَحْمَرُ");
                                                                                                                // Change the audio
                                                                                                                playButton.setOnClickListener(new View.OnClickListener() {
                                                                                                                    @Override
                                                                                                                    public void onClick(View v) {
                                                                                                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                                                                                                            // Arrêter la lecture en cours
                                                                                                                            mediaPlayer.stop();
                                                                                                                            mediaPlayer.release();
                                                                                                                            mediaPlayer = null;
                                                                                                                        }
                                                                                                                        // Charger et jouer le fichier audio
                                                                                                                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.red);
                                                                                                                        mediaPlayer.start();
                                                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                                                            //mot8
                                                                                                                            @Override
                                                                                                                            public void onClick(View v) {
                                                                                                                                img_mot.setImageResource(R.drawable.white);
                                                                                                                                mot_txt.setText("اللَّوْنُ الْأَبْيَضُ");
                                                                                                                                // Change the audio
                                                                                                                                playButton.setOnClickListener(new View.OnClickListener() {
                                                                                                                                    @Override
                                                                                                                                    public void onClick(View v) {
                                                                                                                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                                                                                                                            // Arrêter la lecture en cours
                                                                                                                                            mediaPlayer.stop();
                                                                                                                                            mediaPlayer.release();
                                                                                                                                            mediaPlayer = null;
                                                                                                                                        }
                                                                                                                                        // Charger et jouer le fichier audio
                                                                                                                                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.white);
                                                                                                                                        mediaPlayer.start();
                                                                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                                                                            //mot8
                                                                                                                                            @Override
                                                                                                                                            public void onClick(View v) {
                                                                                                                                                img_mot.setImageResource(R.drawable.yellow);
                                                                                                                                                mot_txt.setText("اللَّوْنُ الْأَصْفَرُ");
                                                                                                                                                // Change the audio
                                                                                                                                                playButton.setOnClickListener(new View.OnClickListener() {
                                                                                                                                                    @Override
                                                                                                                                                    public void onClick(View v) {
                                                                                                                                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                                                                                                                                            // Arrêter la lecture en cours
                                                                                                                                                            mediaPlayer.stop();
                                                                                                                                                            mediaPlayer.release();
                                                                                                                                                            mediaPlayer = null;
                                                                                                                                                        }
                                                                                                                                                        // Charger et jouer le fichier audio
                                                                                                                                                        mediaPlayer = MediaPlayer.create(ColorsActivity.this, R.raw.yellow);
                                                                                                                                                        mediaPlayer.start();

                                                                                                                    }});}});}});}});}});}});}});}});}});}});}});}});}});}});}});}});}});}});
    }
}