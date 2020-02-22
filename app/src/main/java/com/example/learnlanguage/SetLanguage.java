package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SetLanguage extends AppCompatActivity {
    static String language;
    Intent intent;
    boolean canBool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_language);
    }

    public void onClickBtn(View view) {
        switch(view.getId()) {
            case R.id.laksky:
                language= "laksky";
                canBool = true;
                break;
            case R.id.lezgi:
                language= "lezgi";
                canBool = true;
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
