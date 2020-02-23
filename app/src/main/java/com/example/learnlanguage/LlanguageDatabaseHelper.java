package com.example.learnlanguage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


class LlanguageDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "learnLanguage";
    private static final int DB_VERSION =1;
    private String sql = "CREATE TABLE WORDS (_id INTEGER PRIMARY KEY AUTOINCREMENT, WORD TEXT, TRANSLATE TEXT, TRANSLATE_LAKSY TEXT, TRANSLATE_AVAR TEXT, IMAGE_SRC TEXT);";

    LlanguageDatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        insertWord(db,"Любовь", "муьгьуьбат", "love","эшкьи", "балай");
        insertWord(db,"Семья", "килфет", "family", "кулпат", "агьлу");
        insertWord(db,"Мальчик", "гада", "boy", "оьрч","вас");
        insertWord(db,"Битва", "йагъйагъун", "battle", "биябу", "рагъ");
        insertWord(db,"Лягушка", "къиб", "frog", "оьрват1и", "къверкъ");
        insertWord(db,"Медведь", "сев", "bear", "цуша", "ци");
        insertWord(db,"Бабочка", "чепелукь", "butterfly", "ц1иц1имк1ала", "к1алк1уч1");
        insertWord(db,"Курица", "верч", "chicken", "аьнакӀи", "г1анк1у");
        insertWord(db,"Лицо", "чин", "face", "лажин","гьумер");
        insertWord(db,"Лиса", "сик1", "fox", "цулч1а", "цер");
        insertWord(db,"Лев", "аслан", "lion", "аслан", "гъалбац1");
        insertWord(db,"Мёд", "вирт", "honey", "мачча", "гьоц1о");
        insertWord(db,"Лёд", "мурк", "ice", "мик1","ц1ер");
        insertWord(db,"Луна", "варз", "moon", "барз","моц1");
        insertWord(db,"Мышь", "кьиф", "mouse", "к1улу","г1унк1к1");
        insertWord(db,"Ладонь", "капан юкь", "palms", "вит1яихъ","огъохъат");
        insertWord(db,"Люди", "инсан", "people", "инсан","г1адамал");
        insertWord(db,"Крыша", "къав", "roofs","магъи","т1ох");
        insertWord(db,"Ложка", "т1ур", "spoon", "къуса","балухъ");
        insertWord(db,"Лето", "гад", "summer", "гъи","рии");
        insertWord(db,"Лебедь", "къугь", "swan", "урттил къаз","х1анкъва");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println(oldVersion);
        System.out.println(newVersion);
        updateWord(db,1,"Любовь", "муьгьуьбат", "love","эшкьи", "балай");
        updateWord(db,2,"Семья", "килфет", "family", "кулпат", "агьлу");
        updateWord(db,3,"Мальчик", "гада", "boy", "оьрч","вас");
        updateWord(db,4,"Битва", "йагъйагъун", "battle", "биябу", "рагъ");
        updateWord(db,5,"Лягушка", "къиб", "frog", "оьрватӀи", "къверкъ");
        updateWord(db,6,"Медведь", "сев", "bear", "цуша", "ци");
        updateWord(db,7,"Бабочка", "чепелукь", "butterfly", "ц1иц1имк1ала", "к1алк1уч1");
        updateWord(db,8,"Курица", "верч", "chicken", "аьнакӀи", "г1анкӀу");
        updateWord(db,9,"Лицо", "чин", "face", "лажин","гьумер");
        updateWord(db,10,"Лиса", "сик1", "fox", "цулч1а", "цер");
        updateWord(db,11,"Лев", "аслан", "lion", "аслан", "гъалбац1");
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
        db.execSQL("ALTER TABLE WORDS ADD COLUMN TRANSLATE_AVAR TEXT;");
        System.out.println(oldVersion);
        System.out.println(newVersion);
    }
    public static void insertWord(SQLiteDatabase db, String word, String translate, String imageSrc, String translate_laksy, String translate_avar) {
        ContentValues wordValues = new ContentValues();
        wordValues.put("WORD", word);
        wordValues.put("TRANSLATE", translate);
        wordValues.put("IMAGE_SRC", imageSrc);
        wordValues.put("TRANSLATE_LAKSY", translate_laksy);
        wordValues.put("TRANSLATE_AVAR", translate_avar);
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