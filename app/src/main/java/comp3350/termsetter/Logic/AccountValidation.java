package comp3350.termsetter.Logic;

import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import comp3350.termsetter.Persistence.DomainSpecific.User;
import comp3350.termsetter.Presentation.AccountChangePassword;

public class AccountValidation{

    final int MIN_NAME_LENGTH = 1;
    final int MAX_NAME_LENGTH = 20;
    final int MIN_PASS_LENGTH = 6;
    final int MAX_PASS_LENGTH = 10;
    final int MIN_PHONE_LENGTH = 10;
    final int MAX_PHONE_LENGTH = 12;
    Pattern p;
    Matcher m;

    public AccountValidation(){ }

    public boolean validAccount(String name, String password, String email, String phone){
        return validName(name) && validPassword(password) && validEmail(email) && validPhone(phone);
    }

    public boolean validName(String name){
//        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;


        // 1. Check Name
        p = Pattern.compile("^[a-zA-Z]+\\s{1}[a-zA-z]+$");
        m = p.matcher(name);

        if(!m.matches() || name.isEmpty() || !(name.length() <= 30)){
            Toast.makeText(mContext, "The name consist of First name, 1 whitespace, and Last name.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean validID(String id){
        p = Pattern.compile("^[a-zA-Z]+[0-9]*$");
        m = p.matcher(id);

        if(!m.matches() || id.isEmpty() || !(id.length() <= 20)){
            Toast.makeText(mContext, "Your student ID must begin with a character.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean validPassword(String password){
        boolean validLength = password.length() >= MIN_PASS_LENGTH && password.length() <= MAX_PASS_LENGTH;
        boolean hasLetter = false;
        boolean hasNumber = false;
        for(int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);
            if(Character.isLetter(ch)){
                hasLetter = true;
            }
            else if(Character.isDigit(ch)){
                hasNumber = true;
            }
        }
        return validLength && hasLetter && hasNumber;
    }

    public boolean validEmail(String email){
        String[] tokens = email.split("@");
        boolean validLength = tokens[1].length() >= MIN_NAME_LENGTH && tokens[1].length() <= MAX_NAME_LENGTH;
        boolean validDomain = tokens[2].contains("myumanitoba.ca");
        return validLength && validDomain;
    }

    public boolean validPhone(String phone){
        String digits = "";
        boolean hasInvalidChar = false;
        boolean hasOpenBracket = false;
        for(int i = 0; i < phone.length(); i++){
            char ch = phone.charAt(i);
            if(Character.isDigit(ch)){
                digits += ch;
            }
            else{
                if(ch != '+' || ch != ' ' || ch != '-' || ch != '(' || ch != ')'){
                    hasInvalidChar = true;
                }
                else{
                    if(ch == '+' && i > 0){
                        hasInvalidChar = true;
                    }
                    else if(ch == '(' && !hasOpenBracket){
                        hasOpenBracket = true;
                    }
                    else if(ch == ')' && hasOpenBracket){
                        hasOpenBracket = false;
                    }
                }
            }
        }
        boolean validLength = digits.length() >= MIN_PHONE_LENGTH && digits.length() <= MAX_PHONE_LENGTH;
        return validLength && !hasInvalidChar && !hasOpenBracket;
    }

    public boolean confirmPassword(String newPass, String newPassConfirm) {
        if (newPass.equals(newPassConfirm)) {
            return true;
        }
        return false;
    }

    public boolean verifyCurrentPassword(String currentPassword, User currentUser) {
        if (currentPassword.equals(currentUser.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean confirmEmail(String newEmail, String newEmailConfirm) {
        if (newEmail.equals(newEmailConfirm)) {
            return true;
        }
        return false;
    }
}