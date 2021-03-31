package comp3350.termsetter.Logic;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import comp3350.termsetter.Persistence.DomainSpecific.Student;

public class AccountValidation{

    final int MIN_NAME_LENGTH = 1;
    final int MAX_NAME_LENGTH = 20;
    final int MIN_PASS_LENGTH = 6;
    final int MAX_PASS_LENGTH = 10;
    final int MIN_PHONE_LENGTH = 10;
    final int MAX_PHONE_LENGTH = 12;
    AccessManager database = new AccessManager();

    public AccountValidation(){
        // Nothing to initialize
    }

    public boolean validAccount(String name, String id, String password, String email, String phone){
        return validName(name) && validID(id) && validPassword(password) && validEmail(email) && validPhone(phone);
    }

    public boolean validName(String name){
        Pattern p = Pattern.compile("^[a-zA-Z ]{1,20}$");
        Matcher m = p.matcher(name);

        return m.matches();
    }

    public boolean validID(String id){
        Pattern p = Pattern.compile("^([a-zA-Z]+[0-9]*){1,20}$");
        Matcher m = p.matcher(id);

        return m.matches();
    }

    public boolean validPassword(String password){
        // Minimum length of , at least 1 letter and 1 number each
//        Pattern p = Pattern.compile("^([a-zA-Z]+[0-9]+){6,10}$");
        Pattern p = Pattern.compile("^(?=.*?[a-zA-Z])(?=.*?[0-9]).{6,}$");
        Matcher m = p.matcher(password);

        return m.matches();
    }

    public boolean validEmail(String email){
        /*
        At least one letter (number is optional) then @myumanitoba.ca
        */
        Pattern p = Pattern.compile("^[a-zA-Z]+[0-9]*@myumanitoba\\.ca$");
        Matcher m = p.matcher(email);

        return m.matches();
    }

    public boolean validPhone(String phone){
        /*
        Following phone number formats will match:
            1. 123-456-7890
            2. (123) 456-7890
            3. 123 456 7890
            4. 123.456.7890
            5. +91 (123) 456-7890
        */
        Pattern p = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$");
        Matcher m = p.matcher(phone);

        return m.matches();
    }

    public boolean confirmPassword(String newPass, String newPassConfirm) {
        return newPass.equals(newPassConfirm);
    }

    public boolean verifyCurrentPassword(String currentPassword, Student currentStudent) {
        return currentPassword.equals(currentStudent.getPassword());
    }

    public boolean confirmEmail(String newEmail, String newEmailConfirm) {
        return newEmail.equals(newEmailConfirm);
    }

    public boolean verifyStudent(String sID, String password) {
        Student student = database.getStudent(sID);

        // check if a student exists, and has valid ID and password
        // then check if the student record matches
        if(student != null && validID(sID) && validPassword(password)) {
            if(student.getStudentID().equals(sID) && student.getPassword().equals(password))
                return true;
        }

        return false;
    }

}