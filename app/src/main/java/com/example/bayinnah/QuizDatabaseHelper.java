package com.example.bayinnah;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Bayinnah.db";
    private static final int DATABASE_VERSION =11;
    private Context context;

    public QuizDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.setMaximumSize(100000000); // 64 MB
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE quiz_questions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "question TEXT, " +
                "option1 TEXT, " +
                "option2 TEXT, " +
                "option3 TEXT, " +
                "option4 TEXT, " +
                "answer INTEGER, " +
                "categorie TEXT, " +
                "stage INTEGER, " +
                "image BLOB" + // add new column for the image
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.delete("quiz_questions", null, null);
    }



/*
    void insertQuizQuestion(SQLiteDatabase db, String question, String option1, String option2, String option3, String option4, int answer,String categorie,int stage, byte[] image) {
        ContentValues quizQuestionValues = new ContentValues();
        quizQuestionValues.put("question", question);
        quizQuestionValues.put("option1", option1);
        quizQuestionValues.put("option2", option2);
        quizQuestionValues.put("option3", option3);
        quizQuestionValues.put("option4", option4);
        quizQuestionValues.put("answer", answer);
        quizQuestionValues.put("categorie", categorie);
        quizQuestionValues.put("stage", stage);
        quizQuestionValues.put("image", image);// add new column for the image
        db.insert("quiz_questions", null, quizQuestionValues);
    }
    void insertLevelScore(SQLiteDatabase db, int stage, int score) {
        ContentValues levelScoreValues = new ContentValues();
        levelScoreValues.put("stage", stage);
        levelScoreValues.put("score", score);
        db.insert("level_score", null, levelScoreValues);
    }
*/
}
