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
        countRight.setText("Правильно: " + worldTraining.countRight);
        countFalse.setText("Не правильно: " + worldTraining.countFalse);
    }

    public void goHome(View v) {
        worldTraining.countRight = 0;
        worldTraining.countFalse = 0;
        startActivity(intent);
    }
}
