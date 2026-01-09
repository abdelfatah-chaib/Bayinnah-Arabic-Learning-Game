package com.example.bayinnah;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;

public class LettersActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;
    public ImageView img_letter;
    public Button btn_suivant, btn_exit2;
    private SQLiteDatabase db;
    //private DataBaseManager motDbHelper;
    private Cursor quizCursor;

    private byte[] getImageData() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mot3);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        ImageView img_letter= (ImageView) findViewById(R.id.letter_img);
        Button btn_suivant= findViewById(R.id.btn_next);
        Button playButton = findViewById(R.id.btn_hear);
        Button btn_exit2 = findViewById(R.id.btn_exit);

        btn_exit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LettersActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

       // DataBaseManager dbHelper = new DataBaseManager(this);
       // db = dbHelper.getWritableDatabase();

         //Insert a question with an image
        //byte[] imageData = getImageData();
        //dbHelper.insertMot(db, 3 , "أناناس", "Fruits and Vegetables", 1, imageData);

        //boolean playButtonClicked = false;

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
                    mediaPlayer = MediaPlayer.create(LettersActivity.this, R.raw.let1);
                    mediaPlayer.start();

                }

        });
        btn_suivant.setOnClickListener(new View.OnClickListener() {
            //lettre 2
            @Override
            public void onClick(View v) {


                //mediaPlayer.stop();
                //changeImageAndAudio();
                img_letter.setImageResource(R.drawable.let2);
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
                        mediaPlayer = MediaPlayer.create(LettersActivity.this, R.raw.let2);
                        mediaPlayer.start();

                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                            //lettre 3
                            @Override
                            public void onClick(View v) {

                                mediaPlayer.stop();
                                //changeImageAndAudio();
                                img_letter.setImageResource(R.drawable.let3);
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
                                        mediaPlayer = MediaPlayer.create(LettersActivity.this, R.raw.let3);
                                        mediaPlayer.start();

                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                            //lettre 4
                                            @Override
                                            public void onClick(View v) {

                                                mediaPlayer.stop();
                                                //changeImageAndAudio();
                                                img_letter.setImageResource(R.drawable.let4);
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
                                                        mediaPlayer = MediaPlayer.create(LettersActivity.this, R.raw.let4);
                                                        mediaPlayer.start();

                                                        // interface de mots
                                                        btn_suivant.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                mediaPlayer.stop();
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(LettersActivity.this);
                                                                builder.setTitle("Felicitations !");
                                                                builder.setMessage("Vous avez terminé le premièr stage d'apprentissage des lettres, nous allons maintenant passer à l'apprentissage de quelques mots dans la même stage...");
                                                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Intent intent = new Intent(LettersActivity.this, WordsActivity.class);
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
            }
        });

    }








}
