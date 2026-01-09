package com.example.bayinnah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WordsActivity5 extends AppCompatActivity {
    public MediaPlayer mediaPlayer;
    // Fonction pour coloré la lettre
    public static SpannableString highlightLetter(String word, char letter) {
        SpannableString spannable = new SpannableString(word);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        int start = word.indexOf(letter);
        int end = start + 1;
        while (start >= 0) {
            spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            start = word.indexOf(letter, start + 1);
            end = start + 1;
        }
        return spannable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words5);
        TextView mot_txt = findViewById(R.id.txt_mot);
        ImageView img_mot = findViewById(R.id.mot_img);
        Button btn_suivant= findViewById(R.id.btn_next);
        Button playButton = findViewById(R.id.btn_hear);
        Button buttonExit = findViewById(R.id.btn_exit);

        //button Exit
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordsActivity5.this, HomeActivity.class);
                startActivity(intent); }
        });

        // colorée la lettre:
        String word = "مِظلَّةٌ ";
        char letter = 'ظ';
        SpannableString spannable = highlightLetter(word, letter);
        mot_txt.setText(spannable);
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
                mediaPlayer = MediaPlayer.create(WordsActivity5.this, R.raw.mot33);
                mediaPlayer.start();
            }

        });
        btn_suivant.setOnClickListener(new View.OnClickListener() {
            //mot2
            @Override
            public void onClick(View v) {
                img_mot.setImageResource(R.drawable.mot34);
                mot_txt.setText("نَظارَةٌ");
                String word = String.valueOf(mot_txt.getText());
                char letter = 'ظ';
                SpannableString spannable = highlightLetter(word, letter);
                mot_txt.setText(spannable);
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
                        mediaPlayer = MediaPlayer.create(WordsActivity5.this, R.raw.mot34);
                        mediaPlayer.start();
                        //mot3
                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                img_mot.setImageResource(R.drawable.mot35);
                                mot_txt.setText("شِرَاع");
                                String word = String.valueOf(mot_txt.getText());
                                char letter = 'ع';
                                SpannableString spannable = highlightLetter(word, letter);
                                mot_txt.setText(spannable);
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
                                        mediaPlayer = MediaPlayer.create(WordsActivity5.this, R.raw.mot35);
                                        mediaPlayer.start();
                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                            //mot4
                                            @Override
                                            public void onClick(View v) {
                                                img_mot.setImageResource(R.drawable.mot36);
                                                mot_txt.setText("عرَبَةٌ");
                                                String word = String.valueOf(mot_txt.getText());
                                                char letter = 'ع';
                                                SpannableString spannable = highlightLetter(word, letter);
                                                mot_txt.setText(spannable);
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
                                                        mediaPlayer = MediaPlayer.create(WordsActivity5.this, R.raw.mot36);
                                                        mediaPlayer.start();
                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                            //mot5
                                                            @Override
                                                            public void onClick(View v) {
                                                                img_mot.setImageResource(R.drawable.mot37);
                                                                mot_txt.setText("غسَّالَةٌ");
                                                                String word = String.valueOf(mot_txt.getText());
                                                                char letter = 'غ';
                                                                SpannableString spannable = highlightLetter(word, letter);
                                                                mot_txt.setText(spannable);
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
                                                                        mediaPlayer = MediaPlayer.create(WordsActivity5.this, R.raw.mot37);
                                                                        mediaPlayer.start();
                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                            //mot6
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                img_mot.setImageResource(R.drawable.mot38);
                                                                                mot_txt.setText("غرَاءٌ");
                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                char letter = 'غ';
                                                                                SpannableString spannable = highlightLetter(word, letter);
                                                                                mot_txt.setText(spannable);
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
                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity5.this, R.raw.mot38);
                                                                                        mediaPlayer.start();
                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                            //mot7
                                                                                            @Override
                                                                                            public void onClick(View v) {
                                                                                                img_mot.setImageResource(R.drawable.mot39);
                                                                                                mot_txt.setText("فأْسٌ ");
                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                char letter = 'ف';
                                                                                                SpannableString spannable = highlightLetter(word, letter);
                                                                                                mot_txt.setText(spannable);
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
                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity5.this, R.raw.mot39);
                                                                                                        mediaPlayer.start();
                                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                                            //mot8
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                img_mot.setImageResource(R.drawable.mot40);
                                                                                                                mot_txt.setText("صُوف");
                                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                                char letter = 'ف';
                                                                                                                SpannableString spannable = highlightLetter(word, letter);
                                                                                                                mot_txt.setText(spannable);
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
                                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity5.this, R.raw.mot40);
                                                                                                                        mediaPlayer.start();
                                                                                                                    }});}});}});}});}});}});}});}});}});}});}});}});}});}});}
    }
