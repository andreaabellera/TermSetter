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

    public User getUser() {
        User user = null;
        if(users.size()>0){
            user = users.get(0);
        }
        return user;
    }

    public boolean isEmpty() {
        return users.isEmpty();
    }

}