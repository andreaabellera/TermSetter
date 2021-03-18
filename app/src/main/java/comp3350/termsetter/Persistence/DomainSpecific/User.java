package comp3350.termsetter.Persistence.DomainSpecific;

public class User  {

    private String Name;
    private String Password;
    private String Email;
    private final String Phone;
    private final String studentID;

    // constructor
    public User(String name, String password, String email, String phone, String studentID) {
        this.Name = name;
        this.Password = password;
        this.Email = email;
        this.Phone = phone;
        this.studentID = studentID;
    }

    /* Getters */

    public String getName() {
        return this.Name;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getPhoneNumber() {
        return this.Phone;
    }

    public String getEmailAddress() {
        return this.Email;
    }

    public String getStudentID() {
        return this.studentID;
    }


    /* Setters */


    // purpose: sets username
    // input: the String to assign to user id
    public void setUserName(String input) {
        this.Name = input;
    }

    public void setPassword(String input) {
        this.Password = input;
    }

    public void setEmail(String input) {
        this.Email = input;
    }

    //public void setStudentNumber(String studentID){ this.StudentNumber = studentID}
}
