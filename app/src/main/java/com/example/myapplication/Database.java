package com.example.myapplication;

import android.app.Application;

import java.util.ArrayList;

public class Database extends Application {
    private ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getGlobalVariable() {
        return users;
    }

    public boolean addUser(User user) {
        users.add(user);
        return true;
    }

    public boolean isEmpty() {
        return users.isEmpty();
    }

    public User getUser() {
        return users.get(0);
    }
}