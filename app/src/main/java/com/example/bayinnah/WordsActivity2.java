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

import java.util.ArrayList;
import java.util.List;

public class WordsActivity2 extends AppCompatActivity {
    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words2);
        TextView mot_txt = findViewById(R.id.txt_mot);
        TextView categorie_txt = findViewById(R.id.txt_categorie);
        ImageView img_mot = findViewById(R.id.mot_img);
        Button btn_suivant= findViewById(R.id.btn_next);
        Button playButton = findViewById(R.id.btn_hear);
        Button buttonExit = findViewById(R.id.btn_exit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordsActivity2.this, HomeActivity.class);
                startActivity(intent);            }
        });

        // colorée la lettre:
        String word = "جَزَرَ";
        SpannableString spannable = new SpannableString(word);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        int start = word.indexOf('ج'); int end = start + 1;
        spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                mediaPlayer = MediaPlayer.create(WordsActivity2.this, R.raw.mot9);
                mediaPlayer.start();
            }

        });
        btn_suivant.setOnClickListener(new View.OnClickListener() {
            //mot2
            @Override
            public void onClick(View v) {
                img_mot.setImageResource(R.drawable.mot10);
                mot_txt.setText("جُبْنٌ");
                String word = String.valueOf(mot_txt.getText());
                SpannableString spannable = new SpannableString(word);
                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                int start = word.indexOf('ج'); int end = start + 1;
                spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                        mediaPlayer = MediaPlayer.create(WordsActivity2.this, R.raw.mot10);
                        mediaPlayer.start();
                        //mot3
                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                img_mot.setImageResource(R.drawable.mot11);
                                mot_txt.setText("حَلْوَى");
                                String word = String.valueOf(mot_txt.getText());
                                SpannableString spannable = new SpannableString(word);
                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                int start = word.indexOf('ح'); int end = start + 1;
                                spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                                        mediaPlayer = MediaPlayer.create(WordsActivity2.this, R.raw.mot11);
                                        mediaPlayer.start();
                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                            //mot4
                                            @Override
                                            public void onClick(View v) {
                                                img_mot.setImageResource(R.drawable.mot12);
                                                mot_txt.setText("لَحْمُ");
                                                String word = String.valueOf(mot_txt.getText());
                                                SpannableString spannable = new SpannableString(word);
                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                int start = word.indexOf('ح'); int end = start + 1;
                                                spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                                                        mediaPlayer = MediaPlayer.create(WordsActivity2.this, R.raw.mot12);
                                                        mediaPlayer.start();
                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                            //mot5
                                                            @Override
                                                            public void onClick(View v) {
                                                                img_mot.setImageResource(R.drawable.mot13);
                                                                mot_txt.setText("بِطِّيخٌ");
                                                                String word = String.valueOf(mot_txt.getText());
                                                                SpannableString spannable = new SpannableString(word);
                                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                                int start = word.indexOf('خ'); int end = start + 1;
                                                                spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                                                                        mediaPlayer = MediaPlayer.create(WordsActivity2.this, R.raw.mot13);
                                                                        mediaPlayer.start();
                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                            //mot6
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                img_mot.setImageResource(R.drawable.mot14);
                                                                                mot_txt.setText("خَوْخٍ");
                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                SpannableString spannable = new SpannableString(word);
                                                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                                                int start = word.indexOf('خ'); int end = start + 1;
                                                                                spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity2.this, R.raw.mot14);
                                                                                        mediaPlayer.start();
                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                            //mot7
                                                                                            @Override
                                                                                            public void onClick(View v) {
                                                                                                img_mot.setImageResource(R.drawable.mot15);
                                                                                                mot_txt.setText("أفوكادو");
                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                SpannableString spannable = new SpannableString(word);
                                                                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                                                                int start = word.indexOf('د'); int end = start + 1;
                                                                                                spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity2.this, R.raw.mot15);
                                                                                                        mediaPlayer.start();
                                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                                            //mot8
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                img_mot.setImageResource(R.drawable.mot16);
                                                                                                                mot_txt.setText("بقدونس");
                                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                                SpannableString spannable = new SpannableString(word);
                                                                                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                                                                                int start = word.indexOf('د'); int end = start + 1;
                                                                                                                spannable.setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
                                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity2.this, R.raw.mot16);
                                                                                                                        mediaPlayer.start();


                                                                                                                    }});}});}});}});}});}});}});}});}});}});}});}});}});}});}}


