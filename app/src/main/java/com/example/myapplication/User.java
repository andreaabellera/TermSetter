package com.example.myapplication;

public class User {

    private String UserId;
    private String Password;
    private String EmailAddress;

    private String StudentNumber;
    private String Name;
    private String PreferredName;

    // constructor
    public User(String id, String password, String email, String name)
    {
        this.UserId = id;
        this.Password = password;
        this.EmailAddress = email;
        this.Name = name;
        this.StudentNumber = "1234567"; // should access a database
        this.PreferredName = this.Name; //default
    }

    /* Getters */

    public String getUserId()
    {
        return this.UserId;
    }

    public String getPassword()
    {
        return this.Password;
    }

    public String getEmailAddress()
    {
        return this.EmailAddress;
    }

    public String getName()
    {
        return this.Name;
    }

    public String getPreferredName()
    {
        return this.PreferredName;
    }

    /* Setters */

    // purpose: sets user id
    // input: the String to assign to user id
    public void setUserId(String input)
    {
        if(validUserId(input))
            this.UserId = input;
    }

    private boolean validUserId(String userId)
    {
        boolean idValid = false;

        // requirements:
        // not empty
        // no symbols
        // min ? characters
        // max ? characters

        return idValid;
    }

    public void setPassword(String input)
    {
        if(validPassword(input))
            this.Password = input;
    }

    private boolean validPassword(String password)
    {
        boolean pwValid = false;

        // requirements
        // not empty
        // 1 number
        // 1 lowercase
        // 1 uppercase
        //

        return pwValid;
    }



}
