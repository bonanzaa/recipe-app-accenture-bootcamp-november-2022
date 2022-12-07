package com.team3.recipesapp;

public class TestUser {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int ID;
    private String username;
    private String password;

    public TestUser(){}
    public TestUser(int ID,String username,String password){
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "UserID=" + ID +
                ", Username='" + username + '\'' +
                ", Password='" + password +
                '}';
    }

}
