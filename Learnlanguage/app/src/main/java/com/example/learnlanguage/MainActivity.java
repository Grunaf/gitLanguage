package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.worlds_training:
                Intent intent = new Intent(this, worldTraining.class);
                startActivity(intent);
        }
    }
}
