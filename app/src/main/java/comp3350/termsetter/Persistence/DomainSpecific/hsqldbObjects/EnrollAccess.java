package comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Persistence.DomainSpecific.EnrollPersistence;
import comp3350.termsetter.Persistence.DomainSpecific.Student;

public class EnrollAccess implements EnrollPersistence {


    Connection connect = null;

    private final String dbPath;

    public EnrollAccess(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public List<String> getStudentEnrollment(Student student) throws SQLException {
        List<String> currentCourses = new ArrayList<>();

        // connect
        connect = this.connection();

        // query
        PreparedStatement statement = connect.prepareStatement("select enrollment.course_id, " +
                "courses.course_name, courses.section from enrollment INNER JOIN courses " +
                "ON student_id = ? AND enrollment.course_id= courses.course_id");

        statement.setString(1, student.getStudentID());
        ResultSet resultSet = statement.executeQuery();

        // collect
        while (resultSet.next()) {
            final String course_id = resultSet.getString("course_id");
            final String course_name = resultSet.getString("course_name");

            // put them in a list for now
            final String course = course_id + " " + course_name;
            currentCourses.add(course);
        }

        connect.close();
        return currentCourses;
    }

    public void enroll(String sID, String section, String cID) throws SQLException {

            // assumes logic checked that user is valid
            // first connect
                connect = this.connection();
                //query
                PreparedStatement statement = connect.prepareStatement("INSERT INTO enrollment VALUES (?,?)");
                statement.setString(1, sID);
                statement.setString(2, cID);
              //  statement.setString(3, section);


                //Update DB
                statement.executeUpdate();
                connect.close();
    }


    public void unenroll(String sID, String section, String cID) throws SQLException {

        // assumes logic checked that user is valid
        // first connect
        connect = this.connection();
        //query
        PreparedStatement statement = connect.prepareStatement("DELETE FROM enrollment " +
                "where course_ID = ? AND student_id = ?");
        statement.setString(1, cID);
        statement.setString(2, sID);
        //  statement.setString(3, section);

        System.out.println(statement.toString());
        //Update DB
        statement.executeUpdate();
        connect.close();
    }


}
