package com.example.mypostuz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        preferences = getSharedPreferences("BAZA", MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (preferences.getString("kirish", "").length() > 0) {
                    startActivity(new Intent(MainActivity.this,Asosiy.class));
                }
                else {
                    startActivity(new Intent(MainActivity.this,Login.class));
                }
                finish();
            }
        },3000);


    }
}