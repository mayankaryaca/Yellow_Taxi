package com.example.yellowtaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private Handler delayHandler = new Handler();
    private boolean isRememberMe = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        YtSharedPreferences ytSharedPreferences = new YtSharedPreferences(getApplicationContext());
        isRememberMe = ytSharedPreferences.checkIsRememberMe();
        delayHandler.postDelayed(new Runnable() {

            @Override
            public void run() {

                try {
                    if(isRememberMe){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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