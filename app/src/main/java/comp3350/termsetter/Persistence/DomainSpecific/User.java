package comp3350.termsetter.Persistence.DomainSpecific;


import java.io.Serializable;

public class User implements Serializable {

    private String Name;
    private String Password;
    private String Email;
    private final String Phone;
    private final String StudentNumber;

    // constructor
    public User(String name, String password, String email, String phone) {
        this.Name = name;
        this.Password = password;
        this.Email = email;
        this.Phone = phone;
        this.StudentNumber = "1234567";
    }

    /* Getters */

    public String getName() {
        return this.Name;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String input) {
        this.Password = input;
    }

    public String getEmailAddress() {
        return this.Email;
    }



    /* Setters */

    public String getPhoneNumber() {
        return this.Phone;
    }

    // purpose: sets username
    // input: the String to assign to user id
    public void setUserName(String input) {
        this.Name = input;
    }

    public void setEmail(String input) {
        this.Email = input;
    }

    //public void setStudentNumber(String studentID){ this.StudentNumber = studentID}
}
