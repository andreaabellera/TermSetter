package com.example.myapplication;

import android.app.Application;
import java.io.Serializable;

import java.util.ArrayList;

public class Database implements Serializable {

    private ArrayList<User> users;

    public Database() {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(User user) {
        users.remove(0);
        users.add(user);
    }

    public User getUser() {
        return users.get(0);
    }

    public boolean isEmpty() {
        return users.isEmpty();
    }

}