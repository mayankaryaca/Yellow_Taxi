package com.example.yellowtaxi;

public class User {
    private String userName;
    private String passWord;
    private String userId;


    public User(String userName, String passWord, String userId) {
        this.userName = userName;
        this.passWord = passWord;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserId() {
        return userId;
    }
}
