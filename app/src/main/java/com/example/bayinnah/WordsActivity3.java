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

public class WordsActivity3 extends AppCompatActivity {
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
        setContentView(R.layout.activity_words3);
        TextView mot_txt = findViewById(R.id.txt_mot);
        ImageView img_mot = findViewById(R.id.mot_img);
        Button btn_suivant= findViewById(R.id.btn_next);
        Button playButton = findViewById(R.id.btn_hear);
        Button buttonExit = findViewById(R.id.btn_exit);

        //button Exit
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordsActivity3.this, HomeActivity.class);
                startActivity(intent); }
        });

        // colorée la lettre:
        String word = "بِذلَةٌ";
        char letter = 'ذ';
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
                mediaPlayer = MediaPlayer.create(WordsActivity3.this, R.raw.mot17);
                mediaPlayer.start();
            }

        });
        btn_suivant.setOnClickListener(new View.OnClickListener() {
            //mot2
            @Override
            public void onClick(View v) {
                img_mot.setImageResource(R.drawable.mot18);
                mot_txt.setText("حِذاءٌ");
                String word = String.valueOf(mot_txt.getText());
                char letter = 'ذ';
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
                        mediaPlayer = MediaPlayer.create(WordsActivity3.this, R.raw.mot18);
                        mediaPlayer.start();
                        //mot3
                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                img_mot.setImageResource(R.drawable.mot19);
                                mot_txt.setText("جَوَاربٌ");
                                String word = String.valueOf(mot_txt.getText());
                                char letter = 'ر';
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
                                        mediaPlayer = MediaPlayer.create(WordsActivity3.this, R.raw.mot19);
                                        mediaPlayer.start();
                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                            //mot4
                                            @Override
                                            public void onClick(View v) {
                                                img_mot.setImageResource(R.drawable.mot20);
                                                mot_txt.setText("سُتْرةٌ");
                                                String word = String.valueOf(mot_txt.getText());
                                                char letter = 'ر';
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
                                                        mediaPlayer = MediaPlayer.create(WordsActivity3.this, R.raw.mot20);
                                                        mediaPlayer.start();
                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                            //mot5
                                                            @Override
                                                            public void onClick(View v) {
                                                                img_mot.setImageResource(R.drawable.mot21);
                                                                mot_txt.setText("قُفَّازاتٌ");
                                                                String word = String.valueOf(mot_txt.getText());
                                                                char letter = 'ز';
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
                                                                        mediaPlayer = MediaPlayer.create(WordsActivity3.this, R.raw.mot21);
                                                                        mediaPlayer.start();
                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                            //mot6
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                img_mot.setImageResource(R.drawable.mot22);
                                                                                mot_txt.setText("حِزامٌ");
                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                char letter = 'ز';
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
                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity3.this, R.raw.mot22);
                                                                                        mediaPlayer.start();
                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                            //mot7
                                                                                            @Override
                                                                                            public void onClick(View v) {
                                                                                                img_mot.setImageResource(R.drawable.mot23);
                                                                                                mot_txt.setText("فُستَانٌ");
                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                char letter = 'س';
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
                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity3.this, R.raw.mot23);
                                                                                                        mediaPlayer.start();
                                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                                            //mot8
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                img_mot.setImageResource(R.drawable.mot24);
                                                                                                                mot_txt.setText("سِرْوَالٌ");
                                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                                char letter = 'س';
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
                                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity3.this, R.raw.mot24);
                                                                                                                        mediaPlayer.start();
                                                                                                                    }});}});}});}});}});}});}});}});}});}});}});}});}});}});}}


