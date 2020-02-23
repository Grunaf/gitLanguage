package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class worldTraining extends AppCompatActivity {
    public static boolean testOrTraining = false;
    Intent intent;
    Random random = new Random();
    SQLiteOpenHelper langDatebaseHelper;
    SQLiteDatabase db;
    ImageView imagWord;
    TextView rusWord;
    String translateTrue, translate2, translate3, image_word, word;
    Cursor cursorCount, cursor, cursor2, cursor3;
    boolean next = false, exit = false, canBool = true, updateBool = true,repeatBool= true;
    int[] busyX;
    int maxRand;
    int id_arr = 0, c = 0, count, rand1, rand2, randomInt, x, o, b;
    static int countRight = 0;
    static int countFalse = 0;
    Button bt1, bt2, bt3;
    ImageButton btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = new Intent(this, theEndActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_training);
        langDatebaseHelper = new LlanguageDatabaseHelper(this);
        db = langDatebaseHelper.getReadableDatabase();
        rusWord = findViewById(R.id.rusWord);
        imagWord = findViewById(R.id.imageWord);
        btNext = findViewById(R.id.btNext);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        count = getCountDB();
        maxRand = random.nextInt(count)+1;
        busyX = new int[count];
        printBD();
        getValuesDB();
    }
    public void getColorValues(String whichBt) {
        if(b == 1) {
            bt1.setTextColor(Color.parseColor("#FF4CAF50"));
            switch(whichBt) {
                case "bt2":
                    bt2.setTextColor(Color.RED);
                    break;
                case "bt3":
                    bt3.setTextColor(Color.RED);
                    break;
            }
        } else if(b == 2) {
            bt2.setTextColor(Color.parseColor("#FF4CAF50"));
            switch(whichBt) {
                case "bt1":
                    bt1.setTextColor(Color.RED);
                    break;
                case "bt3":
                    bt3.setTextColor(Color.RED);
                    break;
            }
        } else if(b == 3) {
            bt3.setTextColor(Color.parseColor("#FF4CAF50"));
            switch(whichBt) {
                case "bt2":
                    bt2.setTextColor(Color.RED);
                    break;
                case "bt1":
                    bt1.setTextColor(Color.RED);
                    break;
            }
        }
    }
    public void verifyValues(View v) {
        if(canBool) {
            switch (v.getId()) {
                case R.id.bt1:
                    if (bt1.getText() == translateTrue) {
                        bt1.setTextColor(Color.parseColor("#FF4CAF50"));
                        countRight++;
                    } else {
                        getColorValues("bt1");
                        countFalse++;
                    }
                    break;
                case R.id.bt2:
                    if (bt2.getText() == translateTrue) {
                        bt2.setTextColor(Color.parseColor("#FF4CAF50"));
                        countRight++;
                    } else {
                        getColorValues("bt2");
                        countFalse++;
                    }
                    break;
                case R.id.bt3:
                    if (bt3.getText() == translateTrue) {
                        bt3.setTextColor(Color.parseColor("#FF4CAF50"));
                        countRight++;
                    } else {
                        getColorValues("bt3");
                        countFalse++;
                    }
                    break;
            }
            btNext.setVisibility(View.VISIBLE);
            canBool = false;
        }
    }


    public void updateValues(View v) {
        if(updateBool) {
            System.out.println("Ok");
            bt1.setTextColor(Color.BLACK);
            bt2.setTextColor(Color.BLACK);
            bt3.setTextColor(Color.BLACK);
            bt1.setText("");
            bt2.setText("");
            bt3.setText("");
            getValuesDB();
            btNext.setVisibility(View.INVISIBLE);
            canBool = true;
        } else {
            updateBool = true;
            testOrTraining = true;
            startActivity(intent);
            id_arr = 0;
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
        if (cursor.moveToFirst()){
            b = random.nextInt(3)+1;
            word = cursor.getString(1);
            rusWord.setText(word);
            image_word = cursor.getString(3);
            imagWord.setImageResource(getResources().getIdentifier(image_word, "drawable", getPackageName()));
            translateTrue = cursor.getString(2);
            if(b == 1) {
                bt1.setText(translateTrue);
            } else if(b == 2) {
                bt2.setText(translateTrue);
            } else {
                bt3.setText(translateTrue);
            }
            rand1 = setMaxRand();
            while (true) {
                if (rand1 == x) {
                    rand1 = setMaxRand();
                } else {
                    if (SetLanguage.language.equals("lezgi") ) {
                        cursor2 = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand1)}, null, null, null);
                    } else if(SetLanguage.language.equals("laksy")){
                        cursor2 = db.query("WORDS", new String[]{"_id", "WORD","TRANSLATE_LAKSY", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand1)}, null, null, null);
                    } else if(SetLanguage.language.equals("avar")) {
                        cursor2 = db.query("WORDS", new String[]{"_id", "WORD","TRANSLATE_AVAR", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand1)}, null, null, null);
                    }
                    break;
                }
            }
            System.out.println("4 " + SetLanguage.language);
            if(cursor2.moveToFirst()) {
                translate2 = cursor2.getString(2);
                setValueBt(translate2);
            }
            rand2 = setMaxRand();
            while (true) {
                if ((rand2 == x) | (rand2 == rand1)) {
                    rand2 = setMaxRand();
                } else if ((rand2 != x) & (rand2 != rand1)) {
                    if (SetLanguage.language.equals("lezgi") ) {
                        cursor3 = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand2)}, null, null, null);
                    } else if(SetLanguage.language.equals("laksy")){
                        cursor3 = db.query("WORDS", new String[]{"_id", "WORD","TRANSLATE_LAKSY", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand2)}, null, null, null);
                    } else if(SetLanguage.language.equals("avar")) {
                        cursor3 = db.query("WORDS", new String[]{"_id", "WORD","TRANSLATE_AVAR", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand2)}, null, null, null);
                    }
                    break;
                }
            }
            if(cursor3.moveToFirst()) {
                translate3 = cursor3.getString(2);
                setValueBt(translate3);
            }
            System.out.println("4 " + SetLanguage.language);
        }
        else {
            exit = true;
        }
        System.out.println(x +" "+ rand1 + " " +rand2);
    }

    public int getCountDB() {
        cursorCount = db.query("WORDS", new String[] {"_id"},null, null, null, null, null);
        while (cursorCount.moveToNext()) {
            c++;
        }
        return c;
    }
    public void setValueBt(String wrd) {
        if(bt1.getText() == "") {
            bt1.setText(wrd);
        } else if(bt2.getText() == "") {
            bt2.setText(wrd);
        } else if(bt3.getText() == "") {
            bt3.setText(wrd);
        }
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
    public int setMaxRand() {
        int y;
        if (maxRand+5 >= count) {
            y = maxRand - random.nextInt(6);
        } else {
            y = random.nextInt(6) + maxRand;
        }
        return y;
    }
    public void freeX() {
        x = setMaxRand();
        while (repeatBool) {
            for (int intX : busyX) {
                System.out.println("IntX " + intX + " x " + x);
                if (x == intX) {
                    o++;
                    break;
                }
            }
            if (o == 0) {
                System.out.println("Херня получае ");
                busyX[id_arr] = x;
                id_arr++;
                if (id_arr == 5) {
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
}
