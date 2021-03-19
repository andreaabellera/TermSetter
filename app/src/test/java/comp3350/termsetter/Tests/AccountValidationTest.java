package comp3350.termsetter.Tests;


import org.junit.Before;
import org.junit.Test;

import comp3350.termsetter.Logic.AccountValidation;
import static org.junit.Assert.*;

public class AccountValidationTest {

    AccountValidation av;
    String validName = "name";
    String validPasswd = "123pass";
    String validEmail = "mailme@myumanitoba.ca";
    String validPhone = "2045588878";
    String validPhoneDash = "204-558-8878";
    String validPhoneBrackets = "(204) 558 8878";
    String validPhoneCountryCode = "+1(204) 558-8878";

    String empty = "";
    String longName = "pneumonoultramicroscopicsilicovulcanoconosis";
    String noLetterPass = "123456";
    String noNumberPass = "abcdef";
    String longPass = "123456abcdefgh";
    String emptyEmailName = "@myumanitoba.ca";
    String longEmailName = "pneumonoultramicroscopicsilicovulcanoconosis@myumanitoba.ca";
    String invalidDomain = "@myumanitoba.com";
    String noDomain = "mailme-myumanitoba.ca";
    String phoneWithInvalidChar = "20455a8878";
    String phoneWithOpenBracket = "(2045588878";
    String phoneWithWrongBracket = ")204(5588878";
    String phoneWithOffChar = "2045+588878";
    String longPhone = "1234567890987654321";


    @Before
    public void setup(){
        av = new AccountValidation();
    }

    @Test
    public void testValidAccount() {
        System.out.println("\nStarting testValidAccount: given values are valid\n");
        boolean result = av.validAccount(validName, validPasswd, validEmail, validPhone);
        assertTrue(result);
        System.out.println("End testValidAccount: given values are valid\n");
    }

    @Test
    public void testInvalidNameEmpty() {
        System.out.println("\nStarting testInvalidNameEmpty: given name is not valid\n");
        boolean result = av.validNewName(empty);
        assertFalse(result);
        System.out.println("End testInvalidNameEmpty: given name is not valid\n");
    }

    @Test
    public void testInvalidNameLong() {
        System.out.println("\nStarting testInvalidNameLong: given name is not valid\n");
        boolean result = av.validNewName(longName);
        assertFalse(result);
        System.out.println("End testInvalidNameLong: given name is not valid\n");
    }

    @Test
    public void testInvalidPasswordEmpty() {
        System.out.println("\nStarting testInvalidPasswordEmpty: given password is not valid\n");
        boolean result = av.validNewPassword(empty);
        assertFalse(result);
        System.out.println("End testInvalidPasswordEmpty: given password is not valid\n");
    }

    @Test
    public void testInvalidPasswordLong() {
        System.out.println("\nStarting testInvalidPasswordLong: given password is not valid\n");
        boolean result = av.validNewPassword(longPass);
        assertFalse(result);
        System.out.println("End testInvalidPasswordLong: given password is not valid\n");
    }

    @Test
    public void testInvalidPasswordNoLetter() {
        System.out.println("\nStarting testInvalidPasswordNoLetter: given password is not valid\n");
        boolean result = av.validNewPassword(noLetterPass);
        assertFalse(result);
        System.out.println("End testInvalidPasswordNoLetter: given password is not valid\n");
    }

    @Test
    public void testInvalidPasswordNoNumber() {
        System.out.println("\nStarting testInvalidPasswordNoNumber: given password is not valid\n");
        boolean result = av.validNewPassword(noNumberPass);
        assertFalse(result);
        System.out.println("End testInvalidPasswordNoNumber: given password is not valid\n");
    }

    @Test
    public void testInvalidEmailEmpty() {
        System.out.println("\nStarting testInvalidEmailEmpty: given email is not valid\n");
        boolean result = av.validNewEmail(empty);
        assertFalse(result);
        System.out.println("End testInvalidEmailEmpty: given email is not valid\n");
    }

    @Test
    public void testInvalidEmailEmptyName() {
        System.out.println("\nStarting testInvalidEmailEmptyName: given email is not valid\n");
        boolean result = av.validNewEmail(emptyEmailName);
        assertFalse(result);
        System.out.println("End testInvalidEmailEmptyName: given email is not valid\n");
    }

    @Test
    public void testInvalidEmailLong() {
        System.out.println("\nStarting testInvalidEmailLong: given email is not valid\n");
        boolean result = av.validNewEmail(longEmailName);
        assertFalse(result);
        System.out.println("End testInvalidEmailLong: given email is not valid\n");
    }

    @Test
    public void testInvalidEmailDomain() {
        System.out.println("\nStarting testInvalidEmailDomain: given email is not valid\n");
        boolean result = av.validNewEmail(invalidDomain);
        assertFalse(result);
        System.out.println("End testInvalidEmailDomain: given email is not valid\n");
    }

    @Test
    public void testInvalidEmailNoDomain() {
        System.out.println("\nStarting testInvalidEmailNoDomain: given email is not valid\n");
        boolean result = av.validNewEmail(noDomain);
        assertFalse(result);
        System.out.println("End testInvalidEmailNoDomain: given email is not valid\n");
    }

    @Test
    public void testValidPhoneWithDash() {
        System.out.println("\nStarting testValidPhoneWithDash: given phone number is valid\n");
        boolean result = av.validNewPhone(validPhoneDash);
        assertTrue(result);
        System.out.println("End testValidPhoneWithDash: given phone number is valid\n");
    }

    @Test
    public void testValidPhoneWithBrackets() {
        System.out.println("\nStarting testValidPhoneWithBrackets: given phone number is valid\n");
        boolean result = av.validNewPhone(validPhoneBrackets);
        assertTrue(result);
        System.out.println("End testValidPhoneWithBrackets: given phone number is valid\n");
    }

    @Test
    public void testValidPhoneWithCountryCode() {
        System.out.println("\nStarting testValidPhoneWithCountryCode: given phone number is valid\n");
        boolean result = av.validNewPhone(validPhoneCountryCode);
        assertTrue(result);
        System.out.println("End testValidPhoneWithCountryCode: given phone number is valid\n");
    }

    @Test
    public void testInvalidPhoneEmpty() {
        System.out.println("\nStarting testInvalidPhoneEmpty: given phone number is not valid\n");
        boolean result = av.validNewPhone(empty);
        assertFalse(result);
        System.out.println("End testInvalidPhoneEmpty: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneLong() {
        System.out.println("\nStarting testInvalidPhoneLong: given phone number is not valid\n");
        boolean result = av.validNewPhone(longPhone);
        assertFalse(result);
        System.out.println("End testInvalidPhoneLomg: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneChar() {
        System.out.println("\nStarting testInvalidPhoneChar: given phone number is not valid\n");
        boolean result = av.validNewPhone(phoneWithInvalidChar);
        assertFalse(result);
        System.out.println("End testInvalidPhoneChar: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneCharOff() {
        System.out.println("\nStarting testInvalidPhoneCharOff: given phone number is not valid\n");
        boolean result = av.validNewPhone(phoneWithOffChar);
        assertFalse(result);
        System.out.println("End testInvalidPhoneCharOff: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneOpenBracket() {
        System.out.println("\nStarting testInvalidPhoneOpenBrackets: given phone number is not valid\n");
        boolean result = av.validNewPhone(phoneWithOpenBracket);
        assertFalse(result);
        System.out.println("End testInvalidPhoneOpenBracket: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneWrongBracket() {
        System.out.println("\nStarting testInvalidPhoneWrongBrackets: given phone number is not valid\n");
        boolean result = av.validNewPhone(phoneWithWrongBracket);
        assertFalse(result);
        System.out.println("End testInvalidPhoneWrongBracket: given phone number is not valid\n");
    }
}
