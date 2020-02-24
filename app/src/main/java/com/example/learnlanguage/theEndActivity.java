package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class theEndActivity extends AppCompatActivity {
    Intent intent;
    TextView countRight, countFalse;
    ImageView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_end);
        intent = new Intent(this, MainActivity.class);
        header = findViewById(R.id.header);
        countRight = findViewById(R.id.countRight);
        countFalse = findViewById(R.id.countFalse);
        if(MainActivity.testOrTraining.equals("test")) {
            countRight.setText("Правильно: " + activityTest.countRight);
            countFalse.setText("Не правильно: " + activityTest.countFalse);
            header.setImageResource(R.drawable.the_end_test);
            activityTest.countRight = 0;
            activityTest.countFalse = 0;
            MainActivity.testOrTraining = "";
        } else{
            countRight.setText("Правильно: " + worldTraining.countRight);
            countFalse.setText("Не правильно: " + worldTraining.countFalse);
            header.setImageResource(R.drawable.training_the_end);
            worldTraining.countRight = 0;
            worldTraining.countFalse = 0;
            MainActivity.testOrTraining = "";
        }
    }

    public void goHome(View v) {
        startActivity(intent);
    }
}
