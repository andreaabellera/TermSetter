package com.example.myapplication;

import java.io.Serializable;

public class User implements Serializable {

    private String Name;
    private String Password;
    private String Email;
    private String Phone;
    private String StudentNumber;

    // constructor
    public User(String name, String password, String email, String phone)
    {
        this.Name = name;
        this.Password = password;
        this.Email= email;
        this.Phone = phone;
        this.StudentNumber = "1234567";
    }

    /* Getters */

    public String getName()
    {
        return this.Name;
    }

    public String getPassword()
    {
        return this.Password;
    }

    public String getEmailAddress()
    {
        return this.Email;
    }

    public String getPhoneNumber()
    {
        return this.Phone;
    }


    /* Setters */

    // purpose: sets username
    // input: the String to assign to user id
    public void setUserName(String input)
    {
            this.Name = input;
    }

    public void setPassword(String input)
    {
            this.Password = input;
    }

    public void setEmail(String input)
    {
        this.Email = input;
    }
}
