package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class theEndActivity extends AppCompatActivity {
    Intent intent;
    TextView header, countRight, countFalse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_end);
        intent = new Intent(this, MainActivity.class);
        header = findViewById(R.id.header);
        countRight = findViewById(R.id.countRight);
        countFalse = findViewById(R.id.countFalse);
        header.setText("Тренировка закончена");
        if(activityTest.testOrTraining) {
            countRight.setText("Правильно: " + activityTest.countRight);
            countFalse.setText("Не правильно: " + activityTest.countFalse);
            activityTest.countRight = 0;
            activityTest.countFalse = 0;
            activityTest.testOrTraining = false;
        } else{
            countRight.setText("Правильно: " + worldTraining.countRight);
            countFalse.setText("Не правильно: " + worldTraining.countFalse);
            worldTraining.countRight = 0;
            worldTraining.countFalse = 0;
            worldTraining.testOrTraining = false;
        }
    }

    public void goHome(View v) {
        worldTraining.countRight = 0;
        worldTraining.countFalse = 0;
        startActivity(intent);
    }
}
