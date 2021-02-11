package com.example.yellowtaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private Handler delayHandler = new Handler();
    private boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        YtSharedPreferences ytSharedPreferences = new YtSharedPreferences(this);
        isLoggedIn = ytSharedPreferences.checkIfLoggedIn();
        delayHandler.postDelayed(new Runnable() {

            @Override
            public void run() {

                try {
                    if(isLoggedIn = true){
                        Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }

                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        delayHandler.removeCallbacksAndMessages(null);
    }
}