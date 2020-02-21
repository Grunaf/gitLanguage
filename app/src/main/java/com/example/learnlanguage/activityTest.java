package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class activityTest extends AppCompatActivity {
    public static boolean testOrTraining = false;
    Intent intent;
    Random random = new Random();
    SQLiteOpenHelper langDatebaseHelper;
    SQLiteDatabase db;
    TextView WordRuss;
    TextView WordTrue;
    CharSequence word;
    Cursor cursorCount, cursor;
    String valuesTrue, getAnswer;
    CharSequence wordInBt;
    boolean next = false, exit = false, canBool = true, updateBool = true, repeatBool = true, first = true;
    int[] busyX;
    int maxRand;
    int id_arr = 0, c = 0, count, rand1, rand2, randomInt, x, o, b;
    static int countRight = 0;
    static int countFalse = 0;
    Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = new Intent(this, theEndActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        langDatebaseHelper = new LlanguageDatabaseHelper(this);
        db = langDatebaseHelper.getReadableDatabase();
        WordRuss = findViewById(R.id.WordRuss);
        WordTrue = findViewById(R.id.WordTrue);
        btNext = findViewById(R.id.btNext);
        count = getCountDB();
        maxRand = random.nextInt(count) + 1;
        busyX = new int[count];
        printBD();
        getValuesDB();
    }

    public void verifyValues() {
        getAnswer = String.valueOf(WordTrue.getText()).toLowerCase();
        if (valuesTrue.equals(getAnswer)) {
            System.out.println(getAnswer);
            WordTrue.setTextColor(Color.parseColor("#FF4CAF50"));
            countRight++;
        } else {
            WordTrue.setTextColor(Color.RED);
            countFalse++;
        }
    }

    public void updateValues(View v) {
        System.out.println(wordInBt);
        if (first) {
            System.out.println("Ok");
            if (updateBool) {
                System.out.println("Ok");
                verifyValues();
                btNext.setText("Продолжить");
                canBool = true;
                first = false;
            } else {
                updateBool = true;
                first = false;
                verifyValues();
                testOrTraining = true;
                id_arr = 0;
                startActivity(intent);
            }
        } else {
            first = true;
            updateBool = true;
            WordTrue.setText("");
            WordTrue.setTextColor(Color.BLACK);
            btNext.setText("Проверить");
            getValuesDB();
        }
    }



    public void getValuesDB() {
        freeX();
        cursor = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE"}, "_id = ?", new String[]{String.valueOf(x)}, null, null, null);
        if (cursor.moveToFirst()) {
            valuesTrue = cursor.getString(1);
            WordRuss.setText(cursor.getString(2));
        }
    }
    public int setMaxRand() {
        System.out.println("MaxRand " + maxRand);
        int y;
        if (maxRand <= 10) {
            y = random.nextInt(11) + maxRand;
            System.out.println("MaxRand x " + y);
        } else if (maxRand + 10 >= count) {
            y = maxRand - random.nextInt(11);
            System.out.println("Max  x " + y);
        } else {
            y = random.nextInt(11) + maxRand;
            System.out.println("Ma x " + y);
        }
        return y;
    }
    public void freeX() {
        x = setMaxRand();
        while (repeatBool) {
            for (int intX : busyX) {
                System.out.println("IntX " + intX + " x " + x);
                if (x == intX) {
                    System.out.println("if");
                    o++;
                    break;
                }
            }
            if (o == 0) {
                System.out.println("Херня получае ");
                busyX[id_arr] = x;
                id_arr++;
                if (id_arr == 10) {
                    System.out.println("Херня получается " + count + " " + id_arr);
                    updateBool = false;
                }
                break;
            } else {
                x = setMaxRand();
            }
            o = 0;
        }
        o = 0;
    }


    public int getCountDB() {
        cursorCount = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, null, null, null, null, null);
        while (cursorCount.moveToNext()) {
            c++;
        }
        return c;
    }

    public void printBD() {
        cursorCount = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, null, null, null, null, null);
        while (cursorCount.moveToNext()) {
            System.out.println(
                    "id: " + cursorCount.getInt(0) + "\n"
                            + "Word: " + cursorCount.getString(1) + "\n"
                            + "Translate: " + cursorCount.getString(2) + "\n"
                            + "Src: " + cursorCount.getString(3) + "\n");
        }
    }
}

