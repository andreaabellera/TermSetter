package comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Logic.AccountValidation;
import comp3350.termsetter.Persistence.DomainSpecific.Student;
import comp3350.termsetter.Persistence.StudentPersistence;

public class StudentAccess implements StudentPersistence {

    Connection connect = null;
    private final String dbPath;
    private static String currentID = null;

    public StudentAccess(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {

        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath
                + ";shutdown=true", "SA", "");
    }


    public Student insertStudent(Student student) {

        // first connect
        try{
            connect = this.connection();
            //query
            PreparedStatement statement = connect.prepareStatement("INSERT INTO students VALUES (?,?,?,?,?);");
            statement.setString(5, student.getStudentID());
            statement.setString(1, student.getName());
            statement.setString(2, student.getPassword());
            statement.setString(3, student.getEmailAddress());
            statement.setString(4, student.getPhoneNumber());
            // ResultSet resultSet = statement.executeQuery();

            //Update DB
            statement.executeUpdate();
            connect.close();
        }
        catch (SQLException e){

        }
        return student;
    }

    public Student getStudent(String student_id) {
        // will change this later
        Student student = null;
        try {
            connect = this.connection();



            //query
            PreparedStatement statement = connect.prepareStatement("select * from students where student_id = ?");
            statement.setString(1, student_id);
            ResultSet resultSet = statement.executeQuery();

            //collect the data from the query
            while (resultSet.next()) {

                // Enter data into fields and create a new student
                final String studentID = resultSet.getString("student_id");
                final String name = resultSet.getString("name");
                final String passID = resultSet.getString("password");
                final String phoneNumber = resultSet.getString("phoneNum");
                final String email = resultSet.getString("email");

                student = new Student(name, passID, email, phoneNumber, studentID);


                //whoever uses this method, check if the student is null or not.
                connect.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean isEmpty() {
        List<String> studentIDs = new ArrayList<>();

        try {
            // first connect
            connect = this.connection();

            //query
            PreparedStatement statement = connect.prepareStatement("select * from students");

            ResultSet resultSet = statement.executeQuery();

            connect.close();
            return resultSet.next();
        }
        catch ()
    }


    public List<String> getAllStudents() throws SQLException {
        List<String> studentIDs = new ArrayList<>();
        // first connect
        connect = this.connection();

        //query
        PreparedStatement statement = connect.prepareStatement("select * from students");

        ResultSet resultSet = statement.executeQuery();

        //collect
        while (resultSet.next()) {

            //just get the ID's for now
            final String student_id = resultSet.getString("student_id");

            //put them in a list for now
            studentIDs.add(student_id);
        }
        connect.close();
        return studentIDs;
    }

    public void setCurrentStudentID(String sID) {
        this.currentID = sID;
    }

    @Override
    public Student getCurrentStudentID() throws SQLException {
        return getStudent(currentID);
    }

    @Override
    public boolean updatePassword(String password) throws SQLException {
        if ((currentID != null) && (getStudent(currentID)) != null) {
            Student student = getStudent(currentID);
            connect = this.connection();

            PreparedStatement statement = connect.prepareStatement("UPDATE students " +
                    "SET password = ? WHERE student_id = ?");
            statement.setString(1, password);
            statement.setString(2, currentID);

            statement.executeUpdate();
            connect.close();
            return true;
        }

        return false;
    }

    @Override
    public boolean updateEmail(String email) throws SQLException {
        if ((currentID != null) && (getStudent(currentID)) != null) {
            Student student = getStudent(currentID);
            connect = this.connection();

            PreparedStatement statement = connect.prepareStatement("UPDATE students " +
                    "SET email = ? WHERE student_id = ?");
            statement.setString(1, email);
            statement.setString(2, currentID);

            statement.executeUpdate();
            connect.close();
            return true;
        }

        return false;
    }

    /*
    //checks if student exists (no longer needed)
    public boolean validStudent(String sID, String password) throws SQLException {
        boolean check = false;
        // check if valid user exists
        if((accountValidation.validID(sID) && accountValidation.validPassword(password)))
        {
            //valid account so check DB
            connect = this.connection();

            PreparedStatement statement = connect.prepareStatement("SELECT * FROM students WHERE" +
                    " student_id = ? AND password = ?");
            statement.setString(1, sID);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            connect.close();
            return resultSet.next(); //false if nothing, true if something!
        }

        return check; //false
    }*/
}
