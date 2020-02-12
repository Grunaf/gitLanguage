package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class worldTraining extends AppCompatActivity {
    Random random = new Random();
    SQLiteOpenHelper langDatebaseHelper;
    SQLiteDatabase db;
    Cursor cursorCount;
    Cursor cursor;
    Cursor cursor2;
    Cursor cursor3;
    ImageView imagWord;
    TextView rusWord;
    boolean next = false;
    boolean exit = false;
    String wordTrue;
    String word2;
    String word3;
    String image_word;
    String translate;
    int x = 1;
    int c = 0;
    int count;
    int rand1;
    int rand2;

    Button btNext;
    Button bt1;
    Button bt2;
    Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_training);
        rusWord = findViewById(R.id.rusWord);
        imagWord = findViewById(R.id.imageWord);
        btNext = findViewById(R.id.bt1);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        langDatebaseHelper = new LlanguageDatabaseHelper(this);
        db = langDatebaseHelper.getReadableDatabase();
        count = getCountDB();
        getValuesDB();
        printBD();
    }

    public void getValuesDB() {
        System.out.println(count);
        cursor = db.query("WORDS", new String[] {"_id","WORD", "TRANSLATE", "IMAGE_SRC"},"_id = ?", new String[] {String.valueOf(x)}, null, null, null);
        if (cursor.moveToFirst()){
            wordTrue = cursor.getString(2);
            System.out.println(wordTrue);
            bt1.setText(wordTrue);
            translate = cursor.getString(1);
            rusWord.setText(translate);
            image_word = cursor.getString(3);
            imagWord.setImageResource(R.drawable.love);
            rand1 = random.nextInt(count)+1;
            System.out.println("All is norm");
            while (true) {
                if (rand1 == x) {
                    rand1 = random.nextInt(count)+1;
                } else {
                    System.out.println(rand1);
                    cursor2 = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand1)}, null, null, null);
                    System.out.println("break");
                    break;
                }
            }
            if(cursor2.moveToFirst()) {
                word2 = cursor2.getString(2);
                System.out.println(word2);
                bt2.setText(word2);
            }
            rand2 = random.nextInt(count)+1;
            System.out.println("All isn't norm");
            while (true) {
                System.out.println("hi" + rand2);
                if ((rand2 == x) | (rand2 == rand1)) {
                    rand2 = random.nextInt(count)+1;
                    System.out.println("Rand2 " + rand2);
                } else if ((rand2 != x) & (rand2 != rand1)) {
                    System.out.println(rand2);
                    cursor3 = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand2)}, null, null, null);
                    System.out.println("break");
                    break;
                }
            }
            if(cursor3.moveToFirst()) {
                word3 = cursor3.getString(2);
                bt3.setText(word3);
            }
        }
        else {
            exit = true;
            System.out.println("Hi");
        }
        System.out.println(x +" "+ rand1 + " " +rand2);
        x++;
    }

    public int getCountDB() {
        cursorCount = db.query("WORDS", new String[] {"_id","WORD", "TRANSLATE", "IMAGE_SRC"},null, null, null, null, null);
        while (cursorCount.moveToNext()) {
            c++;
        }
        return c;
    }

    public void printBD() {
        cursorCount = db.query("WORDS", new String[] {"_id","WORD", "TRANSLATE", "IMAGE_SRC"},null, null, null, null, null);
        while (cursorCount.moveToNext()) {
            System.out.println(
                     "id: " + cursorCount.getInt(0)+ "\n"
                    + "Word: " + cursorCount.getString(1)+ "\n"
                    + "Translate: " + cursorCount.getString(2)+ "\n"
                    + "Src: " + cursorCount.getString(3)+ "\n" );
        }
    }

}
