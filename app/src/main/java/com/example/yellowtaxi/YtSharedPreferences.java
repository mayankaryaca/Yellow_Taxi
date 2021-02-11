package com.example.yellowtaxi;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class YtSharedPreferences {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static boolean isLoggedIn = false;
    String setting;

    public YtSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(String.valueOf(R.string.app_name),
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveLoginDetails(String username, String password, boolean rememberMe) {
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("logged", rememberMe);
        editor.commit();
    }

    public boolean checkIfLoggedIn(){
        setting = sharedPreferences.getString("username", "defaultValue");
        Log.d("TAG",setting);
        return isLoggedIn;
    }
}
