package comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Persistence.DomainSpecific.User;

public class StudentAccess {

    //what should this do?
    //add students
    //tell them what they enrolled in
    //get the student

    Connection connect = null;
    //what does this need to work?
    //need all the courses
    private final String dbPath;

    public StudentAccess(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private List<String> getEnrollment(User user) throws SQLException {
        List<String> currentCourses= new ArrayList<>();
        // first connect
        connect = this.connection();

        //query
        PreparedStatement statement = connect.prepareStatement("select course_id, course_name from enrollment where student_id = ?");

        ResultSet resultSet = statement.executeQuery();

        // collect
        while(resultSet.next()) {
            final String course_id = resultSet.getString("course_id");
            final String course_name = resultSet.getString("course_name");

            //put them in a list for now
            final String course = course_id+ " " +course_name;
            currentCourses.add(course);
        }

        return currentCourses;
    }
}
