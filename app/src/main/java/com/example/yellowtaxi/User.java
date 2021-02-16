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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
