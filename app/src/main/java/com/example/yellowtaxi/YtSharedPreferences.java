package com.example.yellowtaxi;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class YtSharedPreferences {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static String userId = null;
    private static String username = null;
    private static boolean isRememberMe = false;

    public YtSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(String.valueOf(R.string.app_name),
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveLoginDetails(boolean isRememberMe, String userId, String username) {
        this.isRememberMe = isRememberMe;
        this.userId = userId;
        this.username = username;
        editor.putString("username", this.username);
        editor.putBoolean("rememberMe", this.isRememberMe);
        editor.putString("userId", userId);
        editor.commit();
    }


    public boolean checkIsRememberMe() {
        return sharedPreferences.getBoolean("rememberMe", false);
    }

    public void logOutUser() {
        editor.remove("username");
        editor.remove("rememberMe");
        editor.remove("userId");
        editor.commit();
    }

    public String getUserId() {
        return sharedPreferences.getString("userId", "");
    }

    public String getUsername() {
        String sharedPreferencesUsername = sharedPreferences.getString("username", "");
        String[] splitUsername = sharedPreferencesUsername.split("@");
        String mainUsername = splitUsername[0];
        return mainUsername;
    }

}
