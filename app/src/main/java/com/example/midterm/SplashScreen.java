package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int waktu_loading = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashscreen = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(splashscreen);
                finish();
            }
        }, waktu_loading);
    }
}