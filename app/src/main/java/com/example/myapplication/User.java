package com.example.myapplication;

public class User {

    private String Name;
    private String Password;
    private String EmailAddress;
    private String Phone;
    private String StudentNumber;

    // constructor
    public User(String name, String password, String email, String phone)
    {
        this.Name = name;
        this.Password = password;
        this.EmailAddress = email;
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
        return this.EmailAddress;
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
}
