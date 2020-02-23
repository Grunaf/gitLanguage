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
    TextView headerText;
    Cursor cursorCount, cursor;
    String translateTrue, getAnswer;
    boolean canBool = true, updateBool = true, repeatBool = true, first = true;
    int[] busyX;
    int maxRand;
    int id_arr = 0, c = 0, count, x, o;
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
        headerText = findViewById(R.id.HeaderTest);
        if(SetLanguage.language.equals("lezgi")) {
            headerText.setText("Переведите на лезгинский");
        } else {
            headerText.setText("Переведите на лакский");
        }
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
        if (translateTrue.equals(getAnswer)) {
            System.out.println(getAnswer);
            WordTrue.setTextColor(Color.parseColor("#FF4CAF50"));
            countRight++;
        } else {
            WordTrue.setTextColor(Color.RED);
            countFalse++;
        }
    }

    public void updateValues(View v) {
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
        if (SetLanguage.language.equals("lezgi") ) {
            cursor = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(x)}, null, null, null);
        } else if(SetLanguage.language.equals("laksy")){
            cursor = db.query("WORDS", new String[]{"_id", "WORD","TRANSLATE_LAKSY", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(x)}, null, null, null);
        } else if(SetLanguage.language.equals("avar")) {
            cursor = db.query("WORDS", new String[]{"_id", "WORD","TRANSLATE_AVAR", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(x)}, null, null, null);
        }
        if (cursor.moveToFirst()) {
            translateTrue = cursor.getString(2);
            WordRuss.setText(cursor.getString(1));
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
        cursorCount = db.query("WORDS", new String[]{"_id"}, null, null, null, null, null);
        while (cursorCount.moveToNext()) {
            c++;
        }
        return c;
    }

    public void printBD() {
        cursorCount = db.query("WORDS", new String[] {"_id","WORD", "TRANSLATE", "TRANSLATE_LAKSY","TRANSLATE_AVAR","IMAGE_SRC"},null, null, null, null, null);
        while (cursorCount.moveToNext()) {
            System.out.println(
                    "id: " + cursorCount.getInt(0)+ "\n"
                            + "Word: " + cursorCount.getString(1)+ "\n"
                            + "Translate: " + cursorCount.getString(2)+ "\n"
                            + "Translate laksy: " + cursorCount.getString(3)+ "\n"
                            + "Translate avar: " + cursorCount.getString(4)+ "\n"
                            + "Src: " + cursorCount.getString(5)+ "\n" );
        }
    }
}

