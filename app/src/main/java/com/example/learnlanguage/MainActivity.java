package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickBt(View v) {
        switch(v.getId()) {
            case R.id.worlds_training:
                intent = new Intent(this, worldTraining.class);
                startActivity(intent);
                break;
            case R.id.Test:
                intent = new Intent(this, activityTest.class);
                startActivity(intent);
                break;
            case R.id.changelanguage:
                intent = new Intent(this, SetLanguage.class);
                SetLanguage.language = "";
                startActivity(intent);
        }
    }

}
