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

public class WordsActivity6 extends AppCompatActivity {
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
        setContentView(R.layout.activity_words6);
        TextView mot_txt = findViewById(R.id.txt_mot);
        ImageView img_mot = findViewById(R.id.mot_img);
        Button btn_suivant= findViewById(R.id.btn_next);
        Button playButton = findViewById(R.id.btn_hear);
        Button buttonExit = findViewById(R.id.btn_exit);

        //button Exit
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordsActivity6.this, HomeActivity.class);
                startActivity(intent); }
        });

        // colorée la lettre:
        String word = "قاعَةٌ ";
        char letter = 'ق';
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
                mediaPlayer = MediaPlayer.create(WordsActivity6.this, R.raw.mot41);
                mediaPlayer.start();
            }

        });
        btn_suivant.setOnClickListener(new View.OnClickListener() {
            //mot2
            @Override
            public void onClick(View v) {
                img_mot.setImageResource(R.drawable.mot42);
                mot_txt.setText("أَقلامٌ ");
                String word = String.valueOf(mot_txt.getText());
                char letter = 'ق';
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
                        mediaPlayer = MediaPlayer.create(WordsActivity6.this, R.raw.mot42);
                        mediaPlayer.start();
                        //mot3
                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                img_mot.setImageResource(R.drawable.mot43);
                                mot_txt.setText("كرَّاسَةٌ");
                                String word = String.valueOf(mot_txt.getText());
                                char letter = 'ك';
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
                                        mediaPlayer = MediaPlayer.create(WordsActivity6.this, R.raw.mot43);
                                        mediaPlayer.start();
                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                            //mot4
                                            @Override
                                            public void onClick(View v) {
                                                img_mot.setImageResource(R.drawable.mot44);
                                                mot_txt.setText("مَكتَبُ");
                                                String word = String.valueOf(mot_txt.getText());
                                                char letter = 'ك';
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
                                                        mediaPlayer = MediaPlayer.create(WordsActivity6.this, R.raw.mot44);
                                                        mediaPlayer.start();
                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                            //mot5
                                                            @Override
                                                            public void onClick(View v) {
                                                                img_mot.setImageResource(R.drawable.mot45);
                                                                mot_txt.setText("تَلامِيذٌ");
                                                                String word = String.valueOf(mot_txt.getText());
                                                                char letter = 'ل';
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
                                                                        mediaPlayer = MediaPlayer.create(WordsActivity6.this, R.raw.mot45);
                                                                        mediaPlayer.start();
                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                            //mot6
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                img_mot.setImageResource(R.drawable.mot46);
                                                                                mot_txt.setText("لوْحَةٌ");
                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                char letter = 'ل';
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
                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity6.this, R.raw.mot46);
                                                                                        mediaPlayer.start();
                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                            //mot7
                                                                                            @Override
                                                                                            public void onClick(View v) {
                                                                                                img_mot.setImageResource(R.drawable.mot47);
                                                                                                mot_txt.setText("معَلِّمٌ ");
                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                char letter = 'م';
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
                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity6.this, R.raw.mot47);
                                                                                                        mediaPlayer.start();
                                                                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                                                                            //mot8
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                img_mot.setImageResource(R.drawable.mot48);
                                                                                                                mot_txt.setText("مكْتَبَةٌ");
                                                                                                                String word = String.valueOf(mot_txt.getText());
                                                                                                                char letter = 'م';
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
                                                                                                                        mediaPlayer = MediaPlayer.create(WordsActivity6.this, R.raw.mot48);
                                                                                                                        mediaPlayer.start();
                                                                                                                    }});}});}});}});}});}});}});}});}});}});}});}});}});}});}
}
