package com.example.learnlanguage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


class LlanguageDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "learlanguage";
    private static final int DB_VERSION = 1;
    private String sql = "CREATE TABLE WORDS (_id INTEGER PRIMARY KEY AUTOINCREMENT, WORD TEXT, TRANSLATE TEXT, IMAGE_SRC TEXT);";

    LlanguageDatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        insertWord(db,"Муьгьуьбат", "Любовь", "R.drawable.love");
        insertWord(db,"килфет", "Семья", "../../res/drawable/family.jpg");
        insertWord(db,"гада", "Мальчик", "../../res/drawable/boy.jpg");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static void insertWord(SQLiteDatabase db, String word, String translate, String image_src ) {
        ContentValues wordValues = new ContentValues();
        wordValues.put("WORD", word);
        wordValues.put("TRANSLATE", translate);
        wordValues.put("IMAGE_SRC", image_src);
        db.insert("WORDS", null, wordValues);
    }
}