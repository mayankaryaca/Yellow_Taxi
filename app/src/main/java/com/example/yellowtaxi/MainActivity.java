package com.example.yellowtaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Destination> destinationArrayList = new ArrayList<Destination>();
    private YtSharedPreferences ytSharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogOut = findViewById(R.id.btLogOut);
        ListView lvDestinations = findViewById(R.id.list_attractions);
        ytSharedPreferences = new YtSharedPreferences(getApplicationContext());


        //Loading data from stored file /data/user/0/com.example.yellowtaxi/files/FILE-NAME
        try {
            loadData(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //ListView Adapter for home screen
        DestinationListViewAdapter destinationListViewAdapter = new DestinationListViewAdapter(getApplicationContext(), 0, destinationArrayList);
        lvDestinations.setAdapter(destinationListViewAdapter);
        lvDestinations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openAtttractionDetails = new Intent(getApplicationContext(), AttractionDetails.class);
                openAtttractionDetails.putExtra("key", ("destination" + (position + 1)));
                startActivity(openAtttractionDetails);
            }
        });

        //Log out button
        btnLogOut.setText("LogOut  " + ytSharedPreferences.getUsername());
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ytSharedPreferences.logOutUser(); // clear shared preferennces for logged in user
                Intent openLoginScreen = new Intent(getApplicationContext(), LoginActivity.class);
                openLoginScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(openLoginScreen);
            }
        });


    }

    //Loading data from file
    public void loadData(Context context) throws JSONException {
        FileModifier fileModifier = new FileModifier(context);
        String data = fileModifier.initializeReadJSON();
        JSONObject jsonObject = new JSONObject(data);

        try {
            for (int i = 1; i < (jsonObject.length() + 1); i++) {
                JSONObject jsonObjectDestination = jsonObject.getJSONObject(("destination" + i));
                String name = jsonObjectDestination.getString("name");
                String address = jsonObjectDestination.getString("address");
                String pic_main = jsonObjectDestination.getString("pic_main");

                Destination destination = new Destination(name, address, pic_main);
                destinationArrayList.add(destination);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}