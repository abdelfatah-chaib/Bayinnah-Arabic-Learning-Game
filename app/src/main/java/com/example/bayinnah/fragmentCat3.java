package com.example.bayinnah;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class fragmentCat3 extends Fragment {
    private TextView questionText;
    private int score = 0;
    private AppCompatButton option1Button;
    private AppCompatButton option2Button;
    private AppCompatButton option3Button;
    private AppCompatButton option4Button;

    private SQLiteDatabase quizDb;
    private Cursor quizCursor;
    ImageView questionImage;
    private int questionCounter = 0;
    private int totalQuestions = 10;
    private Cursor cursor;
    private int score1;
    public fragmentCat3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cat3, container, false);
        questionText = view.findViewById(R.id.question);
        option1Button = view.findViewById(R.id.option1);
        option2Button = view.findViewById(R.id.option2);
        option3Button = view.findViewById(R.id.option3);
        option4Button = view.findViewById(R.id.option4);
        questionImage = view.findViewById(R.id.ImageViewQ2);

        QuizDatabaseHelper quizDbHelper = new QuizDatabaseHelper(getActivity());
        quizDb = quizDbHelper.getWritableDatabase();

        loadNextQuestion();

        MediaPlayer correctSound = MediaPlayer.create(getActivity(), R.raw.correct_sound);
        MediaPlayer incorrectSound = MediaPlayer.create(getActivity(), R.raw.incorrect_sound);
        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1, correctSound, incorrectSound);
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2, correctSound, incorrectSound);
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(3, correctSound, incorrectSound);
            }
        });

        option4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(4, correctSound, incorrectSound);
            }
        });

        return view;
    }

    private void loadNextQuestion() {
        if (quizCursor != null) {
            quizCursor.close();
        }

        if (questionCounter < totalQuestions) { // Check if there are more questions to load
            quizCursor = quizDb.rawQuery("SELECT  question, option1, option2, option3, option4, image,answer,stage FROM quiz_questions WHERE stage=3 ORDER BY RANDOM() LIMIT 10", null);

            if (quizCursor != null && quizCursor.getCount() > 0 && quizCursor.moveToFirst()) {
                int questionIndex = quizCursor.getColumnIndex("question");
                int option1Index = quizCursor.getColumnIndex("option1");
                int option2Index = quizCursor.getColumnIndex("option2");
                int option3Index = quizCursor.getColumnIndex("option3");
                int option4Index = quizCursor.getColumnIndex("option4");
                int imageIndex = quizCursor.getColumnIndex("image");

                // Retrieve the question, options, and image from the selected row
                String question = quizCursor.getString(questionIndex);
                String option1 = quizCursor.getString(option1Index);
                String option2 = quizCursor.getString(option2Index);
                String option3 = quizCursor.getString(option3Index);
                String option4 = quizCursor.getString(option4Index);
                byte[] imageBytes = quizCursor.getBlob(imageIndex);

                // Convert the image byte array to a Bitmap
                Bitmap image = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                // Set the question, options, and image in the UI
                questionText.setText(question);
                option1Button.setText(option1);
                option2Button.setText(option2);
                option3Button.setText(option3);
                option4Button.setText(option4);
                questionImage.setImageBitmap(image);

                // Enable all buttons
                option1Button.setEnabled(true);
                option2Button.setEnabled(true);
                option3Button.setEnabled(true);
                option4Button.setEnabled(true);

                questionCounter++; // Increment the question counter
            }
        } else {
            QuizDatabaseHelper quizDbHelper = new QuizDatabaseHelper(getActivity());
            quizDb = quizDbHelper.getWritableDatabase();
            // Get a reference to the SQLite database
            SQLiteDatabase db = quizDbHelper.getReadableDatabase();

            // Define the query to retrieve the score where stage=1
            String query = "SELECT score FROM level_score WHERE stage=3";

            // Execute the query and get a cursor to the results
            cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                // Retrieve the score value from the cursor
                score1 = cursor.getInt(0);
                // Do something with the score1 value here
            }
            if(score1<score) {
                String strSQL = "UPDATE level_score SET score=" + score + " WHERE stage =3 ";
                quizDb.execSQL(strSQL);
            }
            ScoreFragment scoreFragment2 = new ScoreFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("score", score);
            scoreFragment2.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, scoreFragment2)
                    .commit();

        }
    }


    private void checkAnswer(int selectedOption, MediaPlayer correctSound, MediaPlayer incorrectSound) {
        if (quizCursor != null && quizCursor.getCount() > 0) {
            int answerIndex = quizCursor.getColumnIndex("answer");
            String answer = quizCursor.getString(answerIndex);

            // Disable all buttons to prevent multiple clicks
            option1Button.setEnabled(false);
            option2Button.setEnabled(false);
            option3Button.setEnabled(false);
            option4Button.setEnabled(false);

            // Check if the user's answer is correct
            boolean isCorrect = selectedOption == Integer.parseInt(answer);

            // Change the background color of the selected button
            switch (selectedOption) {
                case 1:
                    option1Button.setBackgroundColor(isCorrect ? Color.GREEN : Color.RED);
                    break;
                case 2:
                    option2Button.setBackgroundColor(isCorrect ? Color.GREEN : Color.RED);
                    break;
                case 3:
                    option3Button.setBackgroundColor(isCorrect ? Color.GREEN : Color.RED);
                    break;
                case 4:
                    option4Button.setBackgroundColor(isCorrect ? Color.GREEN : Color.RED);
                    break;
            }

            // Change the background color of the correct answer button
            switch (Integer.parseInt(answer)) {
                case 1:
                    option1Button.setBackgroundColor(Color.GREEN);
                    break;
                case 2:
                    option2Button.setBackgroundColor(Color.GREEN);
                    break;
                case 3:
                    option3Button.setBackgroundColor(Color.GREEN);
                    break;
                case 4:
                    option4Button.setBackgroundColor(Color.GREEN);
                    break;
            }

            // Play the sound effect based on the correctness of the answer
            if (isCorrect) {
                score++;
                correctSound.start();
            } else {
                incorrectSound.start();
            }

            // Load the next question after a delay
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadNextQuestion();

                    // Reset the background color of all buttons
                    option1Button.setBackgroundColor(Color.LTGRAY);
                    option2Button.setBackgroundColor(Color.LTGRAY);
                    option3Button.setBackgroundColor(Color.LTGRAY);
                    option4Button.setBackgroundColor(Color.LTGRAY);
                    option1Button.setBackgroundResource(R.drawable.button_rounded);
                    option2Button.setBackgroundResource(R.drawable.button_rounded);
                    option3Button.setBackgroundResource(R.drawable.button_rounded);
                    option4Button.setBackgroundResource(R.drawable.button_rounded);


                    // Enable all buttons again
                    option1Button.setEnabled(true);
                    option2Button.setEnabled(true);
                    option3Button.setEnabled(true);
                    option4Button.setEnabled(true);
                }
            }, 1500); // Delay for 1 second before loading the next question
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (quizCursor != null) {
            quizCursor.close();
        }
        if (quizDb != null) {
            quizDb.close();
        }
    }
}
