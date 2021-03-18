package comp3350.termsetter.Tests;


import org.junit.Test;

import comp3350.termsetter.Presentation.CreateAccount;
import static org.junit.Assert.*;

public class AccountValidationTest {

    String validName = "name";
    String validPasswd = "123pass";
    String validEmail = "mailme@myumanitoba.ca";
    String validPhone = "204";
    String longName = "pneumonoultramicroscopicsilicovulcanoconosis";
    String longPhone = "1234567890987654321";
    String empty = "";
    String passwordTypo = "123passs";

    @Test
    public void testValidValues() {
        System.out.println("\nStarting testValidValues: given values are valid\n");
        boolean result = CreateAccount.validate(validName, validPasswd, validEmail, validPasswd, validPhone);
        assertTrue(result);
        System.out.println("End testValidValues: given values are valid\n");
    }

    @Test
    public void testInvalidateName() {
        System.out.println("\nStarting testInvalidateName: given name is not valid\n");
        boolean result = CreateAccount.validate(longName, validPasswd, validEmail, validPasswd, validPhone);
        assertFalse(result);
        System.out.println("End testInvalidateName: given name is not valid\n");
    }

    @Test
    public void testInvalidateEmail() {
        System.out.println("\nStarting testInvalidateEmail: given email is not valid\n");
        boolean result = CreateAccount.validate(validName, validPasswd, empty, validPasswd, validPhone);
        assertFalse(result);
        System.out.println("End testInvalidateEmail: given email is not valid\n");
    }

    @Test
    public void testNotMatchingPasswords() {
        System.out.println("\nStarting testNotMatchingPasswords: values written under password and confirm password do not match\n");
        boolean result = CreateAccount.validate(validName, validPasswd, validEmail, passwordTypo, validPhone);
        assertFalse(result);
        System.out.println("testNotMatchingPasswords: values written under password and confirm password do not match\n");
    }

    @Test
    public void testInvalidatePhone() {
        System.out.println("\nStarting testInvalidatePhone: given phone number is not valid\n");
        boolean result = CreateAccount.validate(validName, validPasswd, validEmail, validPasswd, longPhone);
        assertFalse(result);
        System.out.println("End testInvalidatePhone: given phone number is not valid\n");
    }

}
