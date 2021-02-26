package com.example.myapplication;

import static org.junit.Assert.*;
import org.junit.Test;


public class AccountValidationTest{

    String validName = "name";
    String validPasswd = "123pass";
    String validEmail = "mailme@myumanitoba.ca";
    String validPhone = "204";
    String longName = "pneumonoultramicroscopicsilicovulcanoconosis";
    String longPhone = "1234567890987654321";
    String empty = "";
    String passwordTypo = "123passs";

    @Test
    public void testValidateName(){
        System.out.println("\nStarting testValidateName: given name is valid\n");
        boolean result = CreateAccount.validate(validName, validPasswd, validEmail, validPasswd, validPhone);
        assertTrue(result);
        System.out.println("End testValidateName: given name is valid\n");
    }

}
