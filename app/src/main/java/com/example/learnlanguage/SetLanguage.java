package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetLanguage extends AppCompatActivity {
    public static String language = "";
    Intent intent;
    static Button bt1;
    static Button bt2;
    static Button bt3;
    boolean canBool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_language);
        bt1 = findViewById(R.id.laksky);
        bt2 = findViewById(R.id.lezgi);
        bt3 = findViewById(R.id.avar);
        intent = new Intent(this, MainActivity.class);
    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.laksky:
                System.out.println(language);
                language = "laksky";
                bt1.setTextColor(Color.parseColor("#FF5722"));
                bt3.setTextColor(Color.BLACK);
                bt2.setTextColor(Color.BLACK);
                startActivity(intent);
                break;
            case R.id.lezgi:
                language = "lezgi";
                bt2.setTextColor(Color.parseColor("#FF5722"));
                bt3.setTextColor(Color.BLACK);
                bt1.setTextColor(Color.BLACK);
                startActivity(intent);
                break;
            case R.id.avar:
                language = "avar";
                bt3.setTextColor(Color.parseColor("#FF5722"));
                bt2.setTextColor(Color.BLACK);
                bt1.setTextColor(Color.BLACK);
                startActivity(intent);
                break;
        }
    }
}
