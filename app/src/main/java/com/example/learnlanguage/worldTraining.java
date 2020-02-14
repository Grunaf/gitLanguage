package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class worldTraining extends AppCompatActivity {
    Intent intent;
    Random random = new Random();
    SQLiteOpenHelper langDatebaseHelper;
    SQLiteDatabase db;
    ImageView imagWord;
    TextView rusWord;
    String wordTrue, word2, word3, image_word, translate;
    Cursor cursorCount, cursor, cursor2, cursor3;
    boolean next = false, exit = false, canBool = true, updateBool = true,repeatBool= true;
    int[] busyX;
    int id_arr = 0, c = 0, count, rand1, rand2, randomInt, x, o;
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
        busyX = new int[count];
        getValuesDB();
        printBD();
    }

    public void verifyValues(View v) {
        if(canBool) {
            switch (v.getId()) {
                case R.id.bt1:
                    if (bt1.getText() == wordTrue) {
                        bt1.setTextColor(Color.parseColor("#FF4CAF50"));
                        countRight++;
                    } else {
                        bt1.setTextColor(Color.RED);
                        countFalse++;
                    }
                    break;
                case R.id.bt2:
                    if (bt2.getText() == wordTrue) {
                        bt2.setTextColor(Color.parseColor("#FF4CAF50"));
                        countRight++;
                    } else {
                        bt2.setTextColor(Color.RED);
                        bt1.setTextColor(Color.parseColor("#FF4CAF50"));
                        countFalse++;
                    }
                    break;
                case R.id.bt3:
                    if (bt3.getText() == wordTrue) {
                        bt3.setTextColor(Color.parseColor("#FF4CAF50"));
                        countRight++;
                    } else {
                        bt3.setTextColor(Color.RED);
                        bt1.setTextColor(Color.parseColor("#FF4CAF50"));
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
            getValuesDB();
            btNext.setVisibility(View.INVISIBLE);
            canBool = true;
        } else {
            updateBool = true;
            startActivity(intent);
        }
    }

    public void getValuesDB() {
        freeX();
        System.out.println(count);
        cursor = db.query("WORDS", new String[] {"_id","WORD", "TRANSLATE", "IMAGE_SRC"},"_id = ?", new String[] {String.valueOf(x)}, null, null, null);
        if (cursor.moveToFirst()){
            wordTrue = cursor.getString(2);
            bt1.setText(wordTrue);
            translate = cursor.getString(1);
            rusWord.setText(translate);
            image_word = cursor.getString(3);
            imagWord.setImageResource(R.drawable.love);
            rand1 = random.nextInt(count)+1;
            while (true) {
                if (rand1 == x) {
                    rand1 = random.nextInt(count)+1;
                } else {
                    cursor2 = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand1)}, null, null, null);
                    break;
                }
            }
            if(cursor2.moveToFirst()) {
                word2 = cursor2.getString(2);
                System.out.println(word2);
                bt2.setText(word2);
            }
            rand2 = random.nextInt(count)+1;
            while (true) {
                if ((rand2 == x) | (rand2 == rand1)) {
                    rand2 = random.nextInt(count)+1;
                } else if ((rand2 != x) & (rand2 != rand1)) {
                    cursor3 = db.query("WORDS", new String[]{"_id", "WORD", "TRANSLATE", "IMAGE_SRC"}, "_id = ?", new String[]{String.valueOf(rand2)}, null, null, null);
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
        }
        System.out.println(x +" "+ rand1 + " " +rand2);
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

    public void freeX() {
        x =random.nextInt(count)+1;
        while(repeatBool) {
            for (int intX : busyX) {
                System.out.println("IntX "+ intX + " x " + x);
                if (x == intX) {
                    System.out.println("if");
                    o++;
                    break;
                }
            }
            if(o==0) {
                System.out.println("Херня получае ");
                busyX[id_arr] = x;
                id_arr++;
                if (id_arr == count) {
                    System.out.println("Херня получается " + count +" "+ id_arr);
                    updateBool = false;
                }
                break;
            } else {
                x =random.nextInt(count)+1;
            }
            o = 0;
        }
        o = 0;
    }

}
