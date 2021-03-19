package comp3350.termsetter.Tests;


import org.junit.Before;
import org.junit.Test;

import comp3350.termsetter.Logic.AccountValidation;
import comp3350.termsetter.Persistence.DomainSpecific.User;

import static org.junit.Assert.*;

public class AccountValidationTest {

    AccountValidation av;
    String validName = "Name Surname";
    String validID = "username";
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

    String newPass = "Tuan123";
    String newPassFalse = "Tuan321";
    String newPassTrue = "Tuan123";

    String newEmail = "mailAndrea@myumanitoba.ca";
    String confirmEmailTrue = "mailAndrea@myumanitoba.ca";
    String confirmEmailFalse = "mailTuan@myumanitoba.ca";

    User currentUser = new User(validName, validPasswd, validEmail, validPhone, validID);


    @Before
    public void setup(){
        av = new AccountValidation();
    }

    @Test
    public void testValidAccount() {
        System.out.println("\nStarting testValidAccount: given values are valid\n");
        boolean result = av.validAccount(validName, validID, validPasswd, validEmail, validPhone);
        assertTrue(result);
        System.out.println("End testValidAccount: given values are valid\n");
    }

    @Test
    public void testInvalidNameEmpty() {
        System.out.println("\nStarting testInvalidNameEmpty: given name is not valid\n");
        boolean result = av.validName(empty);
        assertFalse(result);
        System.out.println("End testInvalidNameEmpty: given name is not valid\n");
    }

    @Test
    public void testInvalidNameLong() {
        System.out.println("\nStarting testInvalidNameLong: given name is not valid\n");
        boolean result = av.validName(longName);
        assertFalse(result);
        System.out.println("End testInvalidNameLong: given name is not valid\n");
    }

    @Test
    public void testInvalidNameNoSpace() {
        System.out.println("\nStarting testInvalidNameNoSpace: given name is not valid\n");
        String nospace = "notavalidname";
        boolean result = av.validName(nospace);
        assertFalse(result);
        System.out.println("End testInvalidNameNoSpace: given name is not valid\n");
    }

    @Test
    public void testInvalidIDEmpty() {
        System.out.println("\nStarting testInvalidIDEmpty: given ID is not valid\n");
        boolean result = av.validName(empty);
        assertFalse(result);
        System.out.println("End testInvalidIDEmpty: given ID is not valid\n");
    }

    @Test
    public void testInvalidIDLong() {
        System.out.println("\nStarting testInvalidIDLong: given ID is not valid\n");
        boolean result = av.validName(longName);
        assertFalse(result);
        System.out.println("End testInvalidIDLong: given ID is not valid\n");
    }

    @Test
    public void testInvalidPasswordEmpty() {
        System.out.println("\nStarting testInvalidPasswordEmpty: given password is not valid\n");
        boolean result = av.validPassword(empty);
        assertFalse(result);
        System.out.println("End testInvalidPasswordEmpty: given password is not valid\n");
    }

    @Test
    public void testInvalidPasswordLong() {
        System.out.println("\nStarting testInvalidPasswordLong: given password is not valid\n");
        boolean result = av.validPassword(longPass);
        assertFalse(result);
        System.out.println("End testInvalidPasswordLong: given password is not valid\n");
    }

    @Test
    public void testInvalidPasswordNoLetter() {
        System.out.println("\nStarting testInvalidPasswordNoLetter: given password is not valid\n");
        boolean result = av.validPassword(noLetterPass);
        assertFalse(result);
        System.out.println("End testInvalidPasswordNoLetter: given password is not valid\n");
    }

    @Test
    public void testInvalidPasswordNoNumber() {
        System.out.println("\nStarting testInvalidPasswordNoNumber: given password is not valid\n");
        boolean result = av.validPassword(noNumberPass);
        assertFalse(result);
        System.out.println("End testInvalidPasswordNoNumber: given password is not valid\n");
    }

    @Test
    public void testInvalidEmailEmpty() {
        System.out.println("\nStarting testInvalidEmailEmpty: given email is not valid\n");
        boolean result = av.validEmail(empty);
        assertFalse(result);
        System.out.println("End testInvalidEmailEmpty: given email is not valid\n");
    }

    @Test
    public void testInvalidEmailEmptyName() {
        System.out.println("\nStarting testInvalidEmailEmptyName: given email is not valid\n");
        boolean result = av.validEmail(emptyEmailName);
        assertFalse(result);
        System.out.println("End testInvalidEmailEmptyName: given email is not valid\n");
    }

    @Test
    public void testInvalidEmailLong() {
        System.out.println("\nStarting testInvalidEmailLong: given email is not valid\n");
        boolean result = av.validEmail(longEmailName);
        assertFalse(result);
        System.out.println("End testInvalidEmailLong: given email is not valid\n");
    }

    @Test
    public void testInvalidEmailDomain() {
        System.out.println("\nStarting testInvalidEmailDomain: given email is not valid\n");
        boolean result = av.validEmail(invalidDomain);
        assertFalse(result);
        System.out.println("End testInvalidEmailDomain: given email is not valid\n");
    }

    @Test
    public void testInvalidEmailNoDomain() {
        System.out.println("\nStarting testInvalidEmailNoDomain: given email is not valid\n");
        boolean result = av.validEmail(noDomain);
        assertFalse(result);
        System.out.println("End testInvalidEmailNoDomain: given email is not valid\n");
    }

    @Test
    public void testValidPhoneWithDash() {
        System.out.println("\nStarting testValidPhoneWithDash: given phone number is valid\n");
        boolean result = av.validPhone(validPhoneDash);
        assertTrue(result);
        System.out.println("End testValidPhoneWithDash: given phone number is valid\n");
    }

    @Test
    public void testValidPhoneWithBrackets() {
        System.out.println("\nStarting testValidPhoneWithBrackets: given phone number is valid\n");
        boolean result = av.validPhone(validPhoneBrackets);
        assertTrue(result);
        System.out.println("End testValidPhoneWithBrackets: given phone number is valid\n");
    }

    @Test
    public void testValidPhoneWithCountryCode() {
        System.out.println("\nStarting testValidPhoneWithCountryCode: given phone number is valid\n");
        boolean result = av.validPhone(validPhoneCountryCode);
        assertTrue(result);
        System.out.println("End testValidPhoneWithCountryCode: given phone number is valid\n");
    }

    @Test
    public void testInvalidPhoneEmpty() {
        System.out.println("\nStarting testInvalidPhoneEmpty: given phone number is not valid\n");
        boolean result = av.validPhone(empty);
        assertFalse(result);
        System.out.println("End testInvalidPhoneEmpty: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneLong() {
        System.out.println("\nStarting testInvalidPhoneLong: given phone number is not valid\n");
        boolean result = av.validPhone(longPhone);
        assertFalse(result);
        System.out.println("End testInvalidPhoneLomg: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneChar() {
        System.out.println("\nStarting testInvalidPhoneChar: given phone number is not valid\n");
        boolean result = av.validPhone(phoneWithInvalidChar);
        assertFalse(result);
        System.out.println("End testInvalidPhoneChar: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneCharOff() {
        System.out.println("\nStarting testInvalidPhoneCharOff: given phone number is not valid\n");
        boolean result = av.validPhone(phoneWithOffChar);
        assertFalse(result);
        System.out.println("End testInvalidPhoneCharOff: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneOpenBracket() {
        System.out.println("\nStarting testInvalidPhoneOpenBrackets: given phone number is not valid\n");
        boolean result = av.validPhone(phoneWithOpenBracket);
        assertFalse(result);
        System.out.println("End testInvalidPhoneOpenBracket: given phone number is not valid\n");
    }

    @Test
    public void testInvalidPhoneWrongBracket() {
        System.out.println("\nStarting testInvalidPhoneWrongBrackets: given phone number is not valid\n");
        boolean result = av.validPhone(phoneWithWrongBracket);
        assertFalse(result);
        System.out.println("End testInvalidPhoneWrongBracket: given phone number is not valid\n");
    }

    @Test
    public void testConfirmPasswordTrue() {
        System.out.println("\nStarting testConfirmPasswordTrue: given 2 passwords are valid\n");
        boolean result = newPass.equals(newPassTrue);
        assertTrue(result);
        System.out.println("End testConfirmPasswordTrue: given 2 passwords are valid\n");
    }

    @Test
    public void testConfirmPasswordFalse() {
        System.out.println("\nStarting testConfirmPasswordFalse: given 2 passwords are invalid\n");
        boolean result = newPass.equals(newPassFalse);
        assertFalse(result);
        System.out.println("End testConfirmPasswordFalse: given 2 passwords are invalid\n");
    }

    @Test
    public void testConfirmEmailTrue() {
        System.out.println("\nStarting testConfirmEmailTrue: given 2 emails are valid\n");
        boolean result = newEmail.equals(confirmEmailTrue);
        assertTrue(result);
        System.out.println("End testConfirmEmailTrue: given 2 emails are valid\n");
    }

    @Test
    public void testConfirmEmailFalse() {
        System.out.println("\nStarting testConfirmEmailTrue: given 2 emails are valid\n");
        boolean result = newEmail.equals(confirmEmailTrue);
        assertTrue(result);
        System.out.println("End testConfirmEmailTrue: given 2 emails are valid\n");
    }

    @Test
    public void testVerifyPasswordTrue() {
        System.out.println("\nStarting testVerifyPasswordTrue: given 2 passwords are valid\n");
        boolean result = validPasswd.equals(currentUser.getPassword());
        assertTrue(result);
        System.out.println("End testVerifyPasswordTrue: given 2 passwords are valid\n");
    }

    @Test
    public void testVerifyPasswordFalse() {
        System.out.println("\nStarting testVerifyPasswordFalse: given 2 passwords are invalid\n");
        boolean result = newPass.equals(currentUser.getPassword());
        assertFalse(result);
        System.out.println("End testVerifyPasswordFalse: given 2 passwords are invalid\n");
    }
}
