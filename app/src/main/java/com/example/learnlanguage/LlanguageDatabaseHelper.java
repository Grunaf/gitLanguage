package com.example.learnlanguage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


class LlanguageDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "learnlanguage";
    private static final int DB_VERSION = 4;
    private String sql = "CREATE TABLE WORDS (_id INTEGER PRIMARY KEY AUTOINCREMENT, WORD TEXT, TRANSLATE TEXT, TRANSLATE_LAKSY TEXT, IMAGE_SRC TEXT);";

    LlanguageDatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        insertWord(db,1,"Любовь", "муьгьуьбат", "love","эшкьи");
        insertWord(db,2,"Семья", "килфет", "family", "кулпат");
        insertWord(db,3,"Мальчик", "гада", "boy", "оьрч");
        insertWord(db,4,"Битва", "йагъйагъун", "battle", "биябу");
        insertWord(db,5,"Лягушка", "къиб", "frog", "оьрватӀи");
        insertWord(db,6,"Медведь", "сев", "bear", "цуша");
        insertWord(db,7,"Бабочка", "чепелукь", "butterfly", "ц1иц1имк1ала");
        insertWord(db,8,"Курица", "верч", "chicken", "аьнакӀи");
        insertWord(db,9,"Лицо", "чин", "face", "лажин");
        insertWord(db,10,"Лиса", "сик1", "fox", "цулч1а");
        insertWord(db,11,"Лев", "аслан", "lion", "аслан");
        insertWord(db,12,"Мёд", "вирт", "honey", "мачча");
        insertWord(db,13,"Лёд", "мурк", "ice", "мик1");
        insertWord(db,14,"Луна", "варз", "moon", "барз");
        insertWord(db,15,"Мышь", "кьиф", "mouse", "к1улу");
        insertWord(db,16,"Ладонь", "капан юкь", "palms", "вит1яихъ");
        insertWord(db,17,"Люди", "инсан", "people", "инсан");
        insertWord(db,18,"Крыша", "къав", "roofs","магъи");
        insertWord(db,19,"Ложка", "т1ур", "spoon", "къуса");
        insertWord(db,20,"Лето", "гад", "summer", "гъи");
        insertWord(db,21,"Лебедь", "къугь", "swan", "урттил къаз");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE WORDS ADD COLUMN TRANSLATE_AVAR STRING;");
        updateWord(db,1,"Любовь", "муьгьуьбат", "love","эшкьи", "балай");
        updateWord(db,2,"Семья", "килфет", "family", "кулпат", "агьлу");
        updateWord(db,3,"Мальчик", "гада", "boy", "оьрч","вас");
        updateWord(db,4,"Битва", "йагъйагъун", "battle", "биябу", "рагъ");
        updateWord(db,5,"Лягушка", "къиб", "frog", "оьрватӀи", "къверкъ");
        updateWord(db,6,"Медведь", "сев", "bear", "цуша", "ци");
        updateWord(db,7,"Бабочка", "чепелукь", "butterfly", "ц1иц1имк1ала", "к1алк1уч1");
        updateWord(db,8,"Курица", "верч", "chicken", "аьнакӀи", "Г1анкӀу");
        updateWord(db,9,"Лицо", "чин", "face", "лажин","гьумер");
        updateWord(db,10,"Лиса", "сик1", "fox", "цулч1а", "цер");
        updateWord(db,11,"Лев", "аслан", "lion", "аслан", "Гъалбац1");
        updateWord(db,12,"Мёд", "вирт", "honey", "мачча", "гьоц1о");
        updateWord(db,13,"Лёд", "мурк", "ice", "мик1","ц1ер");
        updateWord(db,14,"Луна", "варз", "moon", "барз","моц1");
        updateWord(db,15,"Мышь", "кьиф", "mouse", "к1улу","г1унк1к1");
        updateWord(db,16,"Ладонь", "капан юкь", "palms", "вит1яихъ","огъохъат");
        updateWord(db,17,"Люди", "инсан", "people", "инсан","г1адамал");
        updateWord(db,18,"Крыша", "къав", "roofs","магъи","т1ох");
        updateWord(db,19,"Ложка", "т1ур", "spoon", "къуса","балухъ");
        updateWord(db,20,"Лето", "гад", "summer", "гъи","рии");
        updateWord(db,21,"Лебедь", "къугь", "swan", "урттил къаз","х1анкъва");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public static void insertWord(SQLiteDatabase db, int id, String word, String translate, String imageSrc, String translate_laksy) {
        ContentValues wordValues = new ContentValues();
        wordValues.put("WORD", word);
        wordValues.put("TRANSLATE", translate);
        wordValues.put("IMAGE_SRC", imageSrc);
        wordValues.put("TRANSLATE_LAKSY", translate_laksy);
        db.insert("WORDS", null, wordValues);
    }
    public static void updateWord(SQLiteDatabase db, int id, String word, String translate, String imageSrc, String translate_laksy, String translate_avar) {
        ContentValues wordValues = new ContentValues();
        wordValues.put("WORD", word);
        wordValues.put("TRANSLATE", translate);
        wordValues.put("IMAGE_SRC", imageSrc);
        wordValues.put("TRANSLATE_LAKSY", translate_laksy);
        wordValues.put("TRANSLATE_AVAR", translate_avar);
        db.update("WORDS", wordValues,"_id = ?", new String[] {String.valueOf(id)});
    }
}