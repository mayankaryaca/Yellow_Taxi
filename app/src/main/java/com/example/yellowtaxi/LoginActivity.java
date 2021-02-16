package com.example.yellowtaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    String username = null;
    String password = null;
    CheckBox cbRememberMe;
    ArrayList<User> users = new ArrayList<User>();
    YtSharedPreferences ytSharedPreferences = null;
    Boolean isUserNameCorrect = false;
    Boolean isPasswordCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btLogin = findViewById(R.id.btLogin);
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        users.add(new User("thanos@gmail.com", "1234", "User1"));
        users.add(new User("wonderwoman@yahoo.com", "abc!!", "User2"));
        ytSharedPreferences = new YtSharedPreferences(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPasswordCorrect = false;
                isUserNameCorrect = false;
                username = String.valueOf(etUsername.getText());
                password = String.valueOf(etPassword.getText());
                checkUserLoginDetails(username, password);
                if (isUserNameCorrect) {
                    if (isPasswordCorrect) {
                        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(myIntent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Incorrect password. Try again!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect username. Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void checkUserLoginDetails(String username, String password) {

        for (int i = 0; i < users.size(); i++) {
            String dbusername = users.get(i).getUserName();
            String dbpassword = users.get(i).getPassWord();
            String userId = users.get(i).getUserId();

            if (username.equals(dbusername)) {
                if (password.equals(dbpassword)) {
                    boolean check = cbRememberMe.isChecked();
                    ytSharedPreferences.saveLoginDetails(check, userId,username);
                    isPasswordCorrect = true;
                }
                isUserNameCorrect = true;
            }
        }
    }

}