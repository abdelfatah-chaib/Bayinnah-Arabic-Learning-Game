package com.example.bayinnah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    ImageButton lvl1, lvl2,lvl3,lvl4,lvl5,lvl6,lvl7,nums, colors;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvl1 = (ImageButton)  findViewById(R.id.stage1_word);
        home = (Button)  findViewById(R.id.home_btn2);
        lvl2 = (ImageButton) findViewById(R.id.stage2_word);
        lvl3 = (ImageButton) findViewById(R.id.stage3_word);
        lvl4 = (ImageButton) findViewById(R.id.stage4_word);
        lvl5 = (ImageButton) findViewById(R.id.stage5_word);
        lvl6 = (ImageButton) findViewById(R.id.stage6_word);
        lvl7 = (ImageButton) findViewById(R.id.stage7_word);
        colors = (ImageButton) findViewById(R.id.stage8_word);
        nums = (ImageButton) findViewById(R.id.stage9_word);

        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LettersActivity.class);
                startActivity(intent);
            }
        });

        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LettersActivity2.class);
                startActivity(intent);
            }
        });

        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LettersActivity3.class);
                startActivity(intent);
            }
        });

        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LettersActivity4.class);
                startActivity(intent);
            }
        });

        lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LettersActivity5.class);
                startActivity(intent);
            }
        });

        lvl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LettersActivity6.class);
                startActivity(intent);
            }
        });

        lvl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LettersActivity7.class);
                startActivity(intent);
            }
        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ColorsActivity.class);
                startActivity(intent);
            }
        });
        nums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NumbersActivity.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainPageActivity.class);
                startActivity(intent);
            }
        });
    }
}
