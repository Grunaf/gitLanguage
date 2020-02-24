package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    public static String testOrTraining = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickBt(View v) {
        switch(v.getId()) {
            case R.id.words_training:
                intent = new Intent(this, worldTraining.class);
                worldTraining.countRight = 0;
                worldTraining.countFalse = 0;
                testOrTraining = "training";
                startActivity(intent);
                break;
            case R.id.test:
                intent = new Intent(this, activityTest.class);
                activityTest.countRight = 0;
                activityTest.countFalse = 0;
                testOrTraining = "test";
                startActivity(intent);
                break;
            case R.id.changelanguage:
                intent = new Intent(this, SetLanguage.class);
                SetLanguage.language = "";
                startActivity(intent);
        }
    }

}



