package com.example.yellowtaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class SetRating extends AppCompatActivity {
    String key = null;
    YtSharedPreferences ytSharedPreferences = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_rating);

        ytSharedPreferences = new YtSharedPreferences(getApplicationContext());
        RatingBar ratingBar = findViewById(R.id.rating_bar);
        Button btnSaveRating = findViewById(R.id.btn_saveRating);
        Button btnLogOut = findViewById(R.id.btLogOut);
        Button btnGoBack = findViewById(R.id.btGoBack);

        btnGoBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        key = intent.getStringExtra("key");
        btnSaveRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = Float.parseFloat(String.valueOf(ratingBar.getRating()));
                FileModifier fileModifier = new FileModifier(getApplicationContext());
                String respopnse = fileModifier.initializeReadJSON();
                fileModifier.appendRatingJSON(key, rating, respopnse);
                Intent intent = new Intent(getApplicationContext(),AttractionDetails.class);
                intent.putExtra("key",key);
                intent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        btnLogOut.setText("LogOut  " + ytSharedPreferences.getUsername());
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ytSharedPreferences.logOutUser();
                Intent openLoginScreen = new Intent(getApplicationContext(), LoginActivity.class);
                openLoginScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(openLoginScreen);
            }
        });

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}