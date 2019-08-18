package com.zryx.company.model;

public class Users {

    private int userId;
    private String userName;
    private String password;
    private int status;

    public Users() {
    }

    public Users(int userId, String userName, String password, int status) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
