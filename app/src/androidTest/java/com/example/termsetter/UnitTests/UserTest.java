package com.example.termsetter.UnitTests;

import com.example.termsetter.Persistence.DomainSpecific.User;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest{

    String validName = "name";
    String validPasswd = "123pass";
    String validEmail = "mailme@myumanitoba.ca";
    String validPhone = "204";

    @Test
    public void testUserCreate(){
        System.out.println("\nStarting testUserCreate: object exists after creation\n");
        User user = new User(validName, validPasswd, validEmail, validPhone);
        assertNotNull(user);
        System.out.println("End testUserCreate: object exists after creation\n");
    }

    @Test
    public void testSetName(){
        System.out.println("\nStarting testSetName: set and return correct value\n");
        User user = new User(validName, validPasswd, validEmail, validPhone);
        String newValidName = "barney the dinosaur";
        user.setUserName(newValidName);
        assertEquals(user.getName(), newValidName);
        System.out.println("End testSetName: set and return correct value\n");
    }

    @Test
    public void testSetPassword(){
        System.out.println("\nStarting testSetPassword: set and return correct value\n");
        User user = new User(validName, validPasswd, validEmail, validPhone);
        String newValidPasswd = "pass123";
        user.setPassword(newValidPasswd);
        assertEquals(user.getPassword(),newValidPasswd);
        System.out.println("End testSetPassword: set and return correct value\n");
    }

    @Test
    public void testSetEmail(){
        System.out.println("\nStarting testSetEmail: set and return correct value\n");
        User user = new User(validName, validPasswd, validEmail, validPhone);
        String newValidEmail = "barneyhasmail@myumanitoba.ca";
        user.setEmail(newValidEmail);
        assertEquals(user.getEmailAddress(),newValidEmail);
        System.out.println("End testSetEmail: set and return correct value\n");
    }

    @Test
    public void testGetPhone(){
        System.out.println("\nStarting testGetPhone: return correct value\n");
        User user = new User(validName, validPasswd, validEmail, validPhone);
        assertEquals(user.getPhoneNumber(),validPhone);
        System.out.println("End testSetPhone: return correct value\n");
    }

}
