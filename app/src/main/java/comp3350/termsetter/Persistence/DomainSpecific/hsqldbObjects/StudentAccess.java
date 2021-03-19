package comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects;

import android.content.Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Persistence.DomainSpecific.User;
import comp3350.termsetter.Persistence.UserPersistence;

public class StudentAccess implements UserPersistence {

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


    public void insertUser(User user) throws SQLException {

        // first connect
        connect = this.connection();

        //get Data from user
        String name = user.getName();
        String password = user.getPassword();
        String email = user.getEmailAddress();
        String phoneNumber = user.getPhoneNumber();
        String studentID = user.getStudentID();


        //query
        PreparedStatement statement = connect.prepareStatement("INSERT INTO students VALUES (?,?, ?, ?, ?);");
        statement.setString(1, user.getStudentID());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getEmailAddress());
        statement.setString(5, user.getPhoneNumber());
        // ResultSet resultSet = statement.executeQuery();

        //Update DB
        statement.executeUpdate();
    }

    public User getUser(String student_id) throws SQLException {
        //will change this later
        connect = this.connection();

        List<String> student = new ArrayList<>();
        User user = null;

        //query
        PreparedStatement statement = connect.prepareStatement("select * from students where student_id = ?");
        statement.setString(1, student_id);
        ResultSet resultSet = statement.executeQuery();

        //collect the data from the query
        while (resultSet.next()) {

            // Enter data into fields and create a new user
            final String studentID = resultSet.getString("student_id");
            final String name = resultSet.getString("name");
            final String passID = resultSet.getString("password");
            final String phoneNumber = resultSet.getString("phoneNum");
            final String email = resultSet.getString("email");

            user = new User(studentID, name, passID, phoneNumber, email);


        }

        //whoever uses this method, check if the user is null or not.
        return user;
    }

    @Override
    public boolean isEmpty() throws SQLException {
        List<String> studentIDs = new ArrayList<>();
        // first connect
        connect = this.connection();

        //query
        PreparedStatement statement = connect.prepareStatement("select * from students");

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
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
        return studentIDs;
    }

    public void setCurrentUser(String sID) {
        this.currentID = sID;
    }

    @Override
    public User getCurrentUser() throws SQLException {
        return getUser(currentID);
    }

    @Override
    public boolean updatePassword(String password) throws SQLException {
        if ((currentID != null) && (getUser(currentID)) != null) {
            User user = getUser(currentID);
            connect = this.connection();

            PreparedStatement statement = connect.prepareStatement("UPDATE students " +
                    "SET password = ? WHERE student_id = ?");
            statement.setString(1, password);
            statement.setString(2, currentID);

            statement.executeUpdate();


        }
        return false;
    }

    @Override
    public boolean updateEmail(String email) throws SQLException {
        if ((currentID != null) && (getUser(currentID)) != null) {
            User user = getUser(currentID);
            connect = this.connection();

            PreparedStatement statement = connect.prepareStatement("UPDATE students " +
                    "SET email = ? WHERE student_id = ?");
            statement.setString(1, email);
            statement.setString(2, currentID);

            statement.executeUpdate();


        }
        return false;
    }
}
