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
    boolean canBool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_language);
        intent = new Intent(this, MainActivity.class);
    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.laksky:
                System.out.println(language);
                language = "laksky";
                startActivity(intent);
                break;
            case R.id.lezgi:
                language = "lezgi";
                startActivity(intent);
                break;
            case R.id.avar:
                language = "avar";
                startActivity(intent);
                break;
        }
    }
}
