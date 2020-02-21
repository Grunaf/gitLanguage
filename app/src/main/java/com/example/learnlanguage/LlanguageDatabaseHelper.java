package com.example.learnlanguage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


class LlanguageDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "learlanguage";
    private static final int DB_VERSION = 19;
    private String sql = "CREATE TABLE WORDS (_id INTEGER PRIMARY KEY AUTOINCREMENT, WORD TEXT, TRANSLATE TEXT, IMAGE_SRC TEXT);";

    LlanguageDatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        insertWord(db,"Муьгьуьбат", "Любовь", "love");
        insertWord(db,"килфет", "Семья", "family");
        insertWord(db,"гада", "Мальчик", "boy");
        insertWord(db,"йагъйагъун", "Битва", "battle");
        insertWord(db,"къиб", "Лягушка", "frog");
        insertWord(db,"сев", "Медведь", "bear");
        insertWord(db,"чепелукь", "Бабочка", "butterfly");
        insertWord(db,"верч", "Курица", "chicken");
        insertWord(db,"чин", "Лицо", "face");
        insertWord(db,"сик1", "Лиса", "fox");
        insertWord(db,"аслан", "Лев", "lion");
        insertWord(db,"вирт", "Мёд", "honey");
        insertWord(db,"мурк", "Лёд", "ice");
        insertWord(db,"варз", "Луна", "moon");
        insertWord(db,"кьиф", "Мышь", "mouse");
        insertWord(db,"капан юкь", "Ладонь", "palms");
        insertWord(db,"инсан", "Люди", "people");
        insertWord(db,"къав", "Крыша", "roofs");
        insertWord(db,"т1ур", "Ложка", "spoon");
        insertWord(db,"гад", "Лето", "summer");
        insertWord(db,"къугь", "Лебедь", "swan");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        insertWord(db,"йагъйагъун", "Битва", "battle");
        insertWord(db,"къиб", "Лягушка", "frog");
        insertWord(db,"сев", "Медведь", "bear");
        insertWord(db,"чепелукь", "Бабочка", "butterfly");
        insertWord(db,"верч", "Курица", "chicken");
        insertWord(db,"чин", "Лицо", "face");
        insertWord(db,"сик1", "Лиса", "fox");
        insertWord(db,"аслан", "Лев", "lion");
        insertWord(db,"вирт", "Мёд", "honey");
        insertWord(db,"мурк", "Лёд", "ice");
        insertWord(db,"варз", "Луна", "moon");
        insertWord(db,"кьиф", "Мышь", "mouse");
        insertWord(db,"капан юкь", "Ладонь", "palms");
        insertWord(db,"инсан", "Люди", "people");
        insertWord(db,"къав", "Крыша", "roofs");
        insertWord(db,"т1ур", "Ложка", "spoon");
        insertWord(db,"гад", "Лето", "summer");
        insertWord(db,"къугь", "Лебедь", "swan");
    }

    public static void insertWord(SQLiteDatabase db, String word, String translate, String imageName ) {
        ContentValues wordValues = new ContentValues();
        wordValues.put("WORD", word);
        wordValues.put("TRANSLATE", translate);
        wordValues.put("IMAGE_SRC", imageName);
        db.insert("WORDS", null, wordValues);
    }
    public static void updateWord(SQLiteDatabase db, int id, String word, String translate, String imageName ) {
        ContentValues wordValues = new ContentValues();
        wordValues.put("_id", id);
        wordValues.put("WORD", word);
        wordValues.put("TRANSLATE", translate);
        wordValues.put("IMAGE_SRC", imageName);
        db.update("WORDS", wordValues,"TRANSLATE = ?", new String[] {translate});
    }
}