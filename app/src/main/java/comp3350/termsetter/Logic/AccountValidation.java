package comp3350.termsetter.Logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountValidation{

    final int MIN_NAME_LENGTH = 1;
    final int MAX_NAME_LENGTH = 20;
    final int MIN_PASS_LENGTH = 6;
    final int MAX_PASS_LENGTH = 10;
    final int MIN_PHONE_LENGTH = 10;
    final int MAX_PHONE_LENGTH = 12;

    public AccountValidation(){ }

    public boolean validAccount(String name, String id, String password, String email, String phone){
        return validNewName(name) && validNewID(id) && validNewPassword(password) && validNewEmail(email) && validNewPhone(phone);
    }

    public boolean validNewName(String name){
        Pattern p = Pattern.compile("^[a-zA-Z]+\\s{1}[a-zA-z]+$");
        Matcher m = p.matcher(name);
        return m.matches() && name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    public boolean validNewID(String name){
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    public boolean validNewPassword(String password){
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

    public boolean validNewEmail(String email){
        boolean validLength = false;
        boolean validDomain = false;
        if(email.contains("@")){
            String[] tokens = email.split("@");
            validLength = tokens[0].length() >= MIN_NAME_LENGTH && tokens[0].length() <= MAX_NAME_LENGTH;
            validDomain = tokens[1].contains("myumanitoba.ca");
        }
        return validLength && validDomain;
    }

    public boolean validNewPhone(String phone){
        String digits = "";
        boolean hasInvalidChar = false;
        boolean hasOpenBracket = false;
        for(int i = 0; i < phone.length(); i++){
            char ch = phone.charAt(i);
            if(Character.isDigit(ch)){
                digits += ch;
            }
            else{
                if(ch != '+' && ch != ' ' && ch != '-' && ch != '(' && ch != ')'){
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
}