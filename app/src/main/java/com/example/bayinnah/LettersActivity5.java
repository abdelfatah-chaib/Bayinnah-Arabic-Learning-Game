package com.example.bayinnah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LettersActivity5 extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    public ImageView img_letter;
    public Button btn_suivant,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters5);

        ImageView img_letter= (ImageView) findViewById(R.id.letter_img);
        Button btn_suivant= findViewById(R.id.btn_next);
        Button playButton = findViewById(R.id.btn_hear);
        Button exit= findViewById(R.id.btn_exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LettersActivity5.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            //lettre 1
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    // Arrêter la lecture en cours
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                // Charger et jouer le fichier audio
                mediaPlayer = MediaPlayer.create(LettersActivity5.this, R.raw.l17);
                mediaPlayer.start();

            }
        });
        btn_suivant.setOnClickListener(new View.OnClickListener() {
            //lettre 2
            @Override
            public void onClick(View v) {
                //changeImageAndAudio();
                img_letter.setImageResource(R.drawable.let18);
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
                        mediaPlayer = MediaPlayer.create(LettersActivity5.this, R.raw.l18);
                        mediaPlayer.start();

                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                            //lettre 3
                            @Override
                            public void onClick(View v) {
                                //changeImageAndAudio();
                                img_letter.setImageResource(R.drawable.let19);
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
                                        mediaPlayer = MediaPlayer.create(LettersActivity5.this, R.raw.l19);
                                        mediaPlayer.start();

                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                            //lettre 4
                                            @Override
                                            public void onClick(View v) {
                                                //changeImageAndAudio();
                                                img_letter.setImageResource(R.drawable.let20);
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
                                                        mediaPlayer = MediaPlayer.create(LettersActivity5.this, R.raw.l20);
                                                        mediaPlayer.start();
                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                mediaPlayer.stop();
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(LettersActivity5.this);
                                                                builder.setTitle("Felicitations !");
                                                                builder.setMessage("Vous avez terminé le cinquieme stage d'apprentissage des lettres, nous allons maintenant passer à l'apprentissage de quelques mots dans la même stage...");
                                                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Intent intent = new Intent(LettersActivity5.this, WordsActivity5.class);
                                                                        startActivity(intent);
                                                                    }
                                                                });
                                                                builder.show();

                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }});
            }});
    }}
