package com.example.yellowtaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class AttractionDetails extends AppCompatActivity {
    private String name = null;
    private String website = null;
    private String phone = null;
    private String description = null;
    private String extra_pics_1 = null;
    private String extra_pics_2 = null;
    private String extra_pics_3 = null;
    private String extra_pics_4 = null;
    private int price = 0;
    private double rating = 0;
    private static JSONObject destinationDataObject = null;
    private static String key = null;
    private YtSharedPreferences ytSharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_details);
        ytSharedPreferences = new YtSharedPreferences(this);
        Intent intent = getIntent();
        key = intent.getStringExtra("key");
        refreshData(key);


        TextView tvHeading = findViewById(R.id.id_heading);
        TextView tvPhone = findViewById(R.id.id_phone);
        TextView tvWebsite = findViewById(R.id.id_website);
        TextView tvTicket = findViewById(R.id.id_price);
        TextView tvDescription = findViewById(R.id.id_description);
        RatingBar ratingBar = findViewById(R.id.id_rating);
        Button btnLogout = findViewById(R.id.btLogOut);
        Button btnBack = findViewById(R.id.btGoBack);


        ImageView iv_extra_pics_1 = findViewById(R.id.id_extra_pics_1);
        ImageView iv_extra_pics_2 = findViewById(R.id.id_extra_pics_2);
        ImageView iv_extra_pics_3 = findViewById(R.id.id_extra_pics_3);
        ImageView iv_extra_pics_4 = findViewById(R.id.id_extra_pics_4);


        tvHeading.setText(name);
        if (phone.equals("0")) {
            tvPhone.setText("Phone not available");
        } else {
            tvPhone.setText(phone);
        }
        if (price == 0) {
            tvTicket.setText("Free entry");
        } else {
            tvTicket.setText("$ " + String.valueOf(price));
        }
        tvDescription.setText(description);
        tvWebsite.setText(website);

        ratingBar.setRating((float) rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                double newRating = ratingBar.getRating();
                FileModifier fileModifier = new FileModifier(getApplicationContext());
                String respopnse = fileModifier.initializeReadJSON();
                fileModifier.appendRatingJSON(key, newRating, respopnse);
                Toast.makeText(getApplicationContext(), "Rating changed!", Toast.LENGTH_SHORT).show();

            }
        });


        btnBack.setVisibility(View.VISIBLE);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLogout.setText("LogOut  " + ytSharedPreferences.getUsername());
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ytSharedPreferences.logOutUser();
                Intent openLoginScreen = new Intent(getApplicationContext(), SplashActivity.class);
                openLoginScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(openLoginScreen);
            }
        });

        DrawableManager drawableManager = new DrawableManager(getApplicationContext());

        Drawable drawableExtraPic1 = drawableManager.getDrawable(extra_pics_1);
        iv_extra_pics_1.setImageDrawable(drawableExtraPic1);

        Drawable drawableExtraPic2 = drawableManager.getDrawable(extra_pics_2);
        iv_extra_pics_2.setImageDrawable(drawableExtraPic2);

        Drawable drawableExtraPic3 = drawableManager.getDrawable(extra_pics_3);
        iv_extra_pics_3.setImageDrawable(drawableExtraPic3);

        Drawable drawableExtraPic4 = drawableManager.getDrawable(extra_pics_4);
        iv_extra_pics_4.setImageDrawable(drawableExtraPic4);


        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phone));

                // Check if an Activity exists to perform this action.
                PackageManager pm = getPackageManager();
                ComponentName cn = intent.resolveActivity(pm);
                if (cn == null) {
                    Toast.makeText(getApplicationContext(), "Calling function is not available at the moment", Toast.LENGTH_SHORT).show();
                } else
                    startActivity(intent);
            }

        });

        tvWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intent);
            }
        });

    }

    public void refreshData(String key) {
        FileModifier fileModifier = new FileModifier(this);
        String response = fileModifier.initializeReadJSON();
        try {
            JSONObject jsonObject = new JSONObject(response);
            destinationDataObject = jsonObject.getJSONObject(key);
            name = destinationDataObject.getString("name");
            website = destinationDataObject.getString("website");
            phone = destinationDataObject.getString("phone");
            description = destinationDataObject.getString("description");
            price = destinationDataObject.getInt("price");
            extra_pics_1 = destinationDataObject.getString("extra_pics_1");
            extra_pics_2 = destinationDataObject.getString("extra_pics_2");
            extra_pics_3 = destinationDataObject.getString("extra_pics_3");
            extra_pics_4 = destinationDataObject.getString("extra_pics_4");
            String userId = ytSharedPreferences.getUserId();
            rating = destinationDataObject.getDouble("rating" + userId);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}