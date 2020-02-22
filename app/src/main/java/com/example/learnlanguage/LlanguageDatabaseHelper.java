package com.example.learnlanguage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


class LlanguageDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "learlanguage";
    private static final int DB_VERSION = 30;
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
        updateWord(db,1,"Любовь", "муьгьуьбат", "love","эшкьи");
        updateWord(db,2,"Семья", "килфет", "family", "кулпат");
        updateWord(db,3,"Мальчик", "гада", "boy", "оьрч");
        updateWord(db,4,"Битва", "йагъйагъун", "battle", "биябу");
        updateWord(db,5,"Лягушка", "къиб", "frog", "оьрватӀи");
        updateWord(db,6,"Медведь", "сев", "bear", "цуша");
        updateWord(db,7,"Бабочка", "чепелукь", "butterfly", "цӀицӀимкӀала");
        updateWord(db,8,"Курица", "верч", "chicken", "аьнакӀи");
        updateWord(db,9,"Лицо", "чин", "face", "лажин");
        updateWord(db,10,"Лиса", "сик1", "fox", "цулчӀа");
        updateWord(db,11,"Лев", "аслан", "lion", "аслан");
        updateWord(db,12,"Мёд", "вирт", "honey", "мачча");
        updateWord(db,13,"Лёд", "мурк", "ice", "мик1");
        updateWord(db,14,"Луна", "варз", "moon", "барз");
        updateWord(db,15,"Мышь", "кьиф", "mouse", "кӀулу");
        updateWord(db,16,"Ладонь", "капан юкь", "palms", "витӀяихъ");
        updateWord(db,17,"Люди", "инсан", "people", "инсан");
        updateWord(db,18,"Крыша", "къав", "roofs","магъи");
        updateWord(db,19,"Ложка", "т1ур", "spoon", "къуса");
        updateWord(db,20,"Лето", "гад", "summer", "гъи");
        updateWord(db,21,"Лебедь", "къугь", "swan", "урттил къаз");
    }

    public static void insertWord(SQLiteDatabase db, String word, String translate, String imageName ) {
        ContentValues wordValues = new ContentValues();
        wordValues.put("WORD", word);
        wordValues.put("TRANSLATE", translate);
        wordValues.put("IMAGE_SRC", imageName);
        db.insert("WORDS", null, wordValues);
    }
    public static void updateWord(SQLiteDatabase db, int id, String word, String translate, String imageSrc, String translate_laksy) {
        ContentValues wordValues = new ContentValues();
        wordValues.put("WORD", word);
        wordValues.put("TRANSLATE", translate);
        wordValues.put("IMAGE_SRC", imageSrc);
        wordValues.put("TRANSLATE_LAKSY", translate_laksy);
        db.update("WORDS", wordValues,"_id = ?", new String[] {String.valueOf(id)});
    }
}