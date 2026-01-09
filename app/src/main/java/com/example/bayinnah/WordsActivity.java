package com.example.bayinnah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

public class WordsActivity extends AppCompatActivity {
    public MediaPlayer mediaPlayer;
    private SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        TextView mot_txt = findViewById(R.id.txt_mot);
        TextView categorie_txt = findViewById(R.id.txt_categorie);
        ImageView img_mot = findViewById(R.id.mot_img);
        Button btn_suivant= findViewById(R.id.btn_next);
        Button playButton = findViewById(R.id.btn_hear);
        Button buttonExit = findViewById(R.id.btn_exit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordsActivity.this, HomeActivity.class);
                startActivity(intent);            }
        });

        // colorée la lettre:
        String word = "أَسَدٌ";
        SpannableString spannable = new SpannableString(word);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        int start = word.indexOf('أ'); int end = start + 1;
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
                mediaPlayer = MediaPlayer.create(WordsActivity.this, R.raw.mot1);
                mediaPlayer.start();
            }

        });
        btn_suivant.setOnClickListener(new View.OnClickListener() {
            //mot2
            @Override
            public void onClick(View v) {
                img_mot.setImageResource(R.drawable.mot2);
                mot_txt.setText("أَرْنَبٍ");
                String word = String.valueOf(mot_txt.getText());
                SpannableString spannable = new SpannableString(word);
                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                List<Integer> startIndices = new ArrayList<>();
                startIndices.add(word.indexOf('أ'));
                startIndices.add(word.indexOf('ب'));
                startIndices.add(word.indexOf('ت'));
                startIndices.add(word.indexOf('ث'));
                for (int i = 0; i < startIndices.size(); i++) {
                    int start = startIndices.get(i);
                    int end = start + 1;
                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
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
                        mediaPlayer = MediaPlayer.create(WordsActivity.this, R.raw.mot2);
                        mediaPlayer.start();
                        //mot3
                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                img_mot.setImageResource(R.drawable.mot3);
                                mot_txt.setText("بَطَّةَ");
                                String word = String.valueOf(mot_txt.getText());
                                SpannableString spannable = new SpannableString(word);
                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                List<Integer> startIndices = new ArrayList<>();
                                startIndices.add(word.indexOf('أ'));
                                startIndices.add(word.indexOf('ب'));
                                startIndices.add(word.indexOf('ت'));
                                startIndices.add(word.indexOf('ث'));
                                for (int i = 0; i < startIndices.size(); i++) {
                                    int start = startIndices.get(i);
                                    int end = start + 1;
                                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                }
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
                                        mediaPlayer = MediaPlayer.create(WordsActivity.this, R.raw.mot3);
                                        mediaPlayer.start();
                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                            //mot4
                                            @Override
                                            public void onClick(View v) {
                                                img_mot.setImageResource(R.drawable.mot4);
                                                mot_txt.setText("بِطَرِيقِ");
                                                String word = String.valueOf(mot_txt.getText());
                                                SpannableString spannable = new SpannableString(word);
                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                List<Integer> startIndices = new ArrayList<>();
                                                startIndices.add(word.indexOf('أ'));
                                                startIndices.add(word.indexOf('ب'));
                                                startIndices.add(word.indexOf('ت'));
                                                startIndices.add(word.indexOf('ث'));
                                                for (int i = 0; i < startIndices.size(); i++) {
                                                    int start = startIndices.get(i);
                                                    int end = start + 1;
                                                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                }
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
                                                        mediaPlayer = MediaPlayer.create(WordsActivity.this, R.raw.mot4);
                                                        mediaPlayer.start();
                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                            //mot5
                                                            @Override
                                                            public void onClick(View v) {
                                                                img_mot.setImageResource(R.drawable.mot5);
                                                                mot_txt.setText("تِمْسَاحٍ");
                                                                String word = String.valueOf(mot_txt.getText());
                                                                SpannableString spannable = new SpannableString(word);
                                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                                List<Integer> startIndices = new ArrayList<>();
                                                                startIndices.add(word.indexOf('أ'));
                                                                startIndices.add(word.indexOf('ب'));
                                                                startIndices.add(word.indexOf('ت'));
                                                                startIndices.add(word.indexOf('ث'));
                                                                for (int i = 0; i < startIndices.size(); i++) {
                                                                    int start = startIndices.get(i);
                                                                    int end = start + 1;
                                                                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                                }
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
                                                                        mediaPlayer = MediaPlayer.create(WordsActivity.this, R.raw.mot5);
                                                                        mediaPlayer.start();
                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                            //mot6
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                img_mot.setImageResource(R.drawable.mot6);
                                                                                mot_txt.setText("تَنِينَ");
                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                SpannableString spannable = new SpannableString(word);
                                                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                                                List<Integer> startIndices = new ArrayList<>();
                                                                                startIndices.add(word.indexOf('أ'));
                                                                                startIndices.add(word.indexOf('ب'));
                                                                                startIndices.add(word.indexOf('ت'));
                                                                                startIndices.add(word.indexOf('ث'));
                                                                                for (int i = 0; i < startIndices.size(); i++) {
                                                                                    int start = startIndices.get(i);
                                                                                    int end = start + 1;
                                                                                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                                                }
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
                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity.this, R.raw.mot6);
                                                                                        mediaPlayer.start();
                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                            //mot7
                                                                                            @Override
                                                                                            public void onClick(View v) {
                                                                                                img_mot.setImageResource(R.drawable.mot7);
                                                                                                mot_txt.setText("ثَعْلَبَ");
                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                SpannableString spannable = new SpannableString(word);
                                                                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                                                                List<Integer> startIndices = new ArrayList<>();
                                                                                                startIndices.add(word.indexOf('أ'));
                                                                                                startIndices.add(word.indexOf('ب'));
                                                                                                startIndices.add(word.indexOf('ت'));
                                                                                                startIndices.add(word.indexOf('ث'));
                                                                                                for (int i = 0; i < startIndices.size(); i++) {
                                                                                                    int start = startIndices.get(i);
                                                                                                    int end = start + 1;
                                                                                                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                                                                }
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
                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity.this, R.raw.mot7);
                                                                                                        mediaPlayer.start();
                                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                                            //mot8
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                img_mot.setImageResource(R.drawable.mot8);
                                                                                                                mot_txt.setText("ثُعْبَانٌ");
                                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                                SpannableString spannable = new SpannableString(word);
                                                                                                                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
                                                                                                                List<Integer> startIndices = new ArrayList<>();
                                                                                                                startIndices.add(word.indexOf('أ'));
                                                                                                                startIndices.add(word.indexOf('ب'));
                                                                                                                startIndices.add(word.indexOf('ت'));
                                                                                                                startIndices.add(word.indexOf('ث'));
                                                                                                                for (int i = 0; i < startIndices.size(); i++) {
                                                                                                                    int start = startIndices.get(i);
                                                                                                                    int end = start + 1;
                                                                                                                    spannable.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                                                                                                }
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
                                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity.this, R.raw.mot8);
                                                                                                                        mediaPlayer.start();


                                                                                                                    }});}});}});}});}});}});}});}});}});}});}});}});}});}});}}






