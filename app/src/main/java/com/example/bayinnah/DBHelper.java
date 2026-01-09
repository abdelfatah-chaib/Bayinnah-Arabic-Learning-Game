package com.example.bayinnah;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLData;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Bayinnah.db";
    private static final int DATABASE_VERSION = 11;

    public DBHelper(Context context) {
        super(context, "Bayinnah.db", null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase MyDb) {
        MyDb.execSQL("create Table users(username TEXT primary key, password TEXT, score INTEGER DEFAULT 0)");
        MyDb.execSQL("create table level_score (stage INTEGER primary key, score INTEGER)");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.setMaximumSize(2000000000); // 64 MB
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        //MyDB.execSQL("drop table if exists users");
        if (i < 7) {
            // Rename the old score column to old_score
           // MyDB.execSQL("ALTER TABLE users RENAME COLUMN score TO old_score2");
            // Add a new score column
           // MyDB.execSQL("ALTER TABLE users ADD COLUMN score INTEGER DEFAULT 0");
            // Copy values from old_score to new score
            //MyDB.execSQL("UPDATE users SET score = old_score");
            // Remove the old_score column
           // MyDB.execSQL("ALTER TABLE users DROP COLUMN old_score");;
           //MyDb.execSQL("create table level_score (stage INTEGER primary key, score INTEGER)");

        }
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("score", 0);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * From users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this. getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * From users where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return  false;
    }

    public Boolean updatepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        long result = MyDB.update("users", contentValues, "username = ?", new String[] {username});
        if (result == -1) return false;
        else
            return true;
    }
}
