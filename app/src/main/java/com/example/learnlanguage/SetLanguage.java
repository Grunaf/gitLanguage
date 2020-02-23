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
    Button bt1;
    Button bt2;
    Button bt3;
    boolean canBool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_language);
        bt1 = findViewById(R.id.laksky);
        bt2 = findViewById(R.id.lezgi);
        bt3 = findViewById(R.id.avar);
    }

    public void onClickBtn(View view) {
        switch(view.getId()) {
            case R.id.laksky:
                System.out.println(language);
                if (language.equals("")) {
                    language= "laksky";
                    bt1.setTextColor(Color.parseColor("#FF5722"));
                    canBool = true;
                    break;
                }
                break;
            case R.id.lezgi:
                if (language.equals("")) {
                    language= "lezgi";
                    bt2.setTextColor(Color.parseColor("#FF5722"));
                    canBool = true;
                    break;
                }
                break;
            case R.id.avar:
                if (language.equals("")) {
                    language= "avar";
                    bt3.setTextColor(Color.parseColor("#FF5722"));
                    canBool = true;
                    break;
                }
                break;
            case R.id.done:
                if (canBool) {
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);

                }
                break;
        }
    }
}
