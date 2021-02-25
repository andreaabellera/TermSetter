package com.example.myapplication;

public class User {

    private String UserId;
    private String Password;
    private String EmailAddress;

    private String StudentNumber;
    private String FirstName;
    private String LastName;
    private String PreferredName;

    // constructor
    public User()
    {
        init();
        this.StudentNumber = "1234567"; // should access a database
        this.PreferredName = this.FirstName; //default
    }

    // initializer
    private void init()
    {
        this.UserId = "";
        this.Password = "";
        this.StudentNumber = "";
        this.EmailAddress = "";
        this.FirstName = "";
        this.LastName = "";
        this.PreferredName = "";
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

    public String getFullName()
    {
        return this.FirstName + this.LastName;
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
