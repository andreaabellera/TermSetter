package comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseAccess {

    Connection connect = null;
    private final String dbPath;

    public CourseAccess(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public List<String> getAllFaculties() throws SQLException {
        // first connect
        connect= this.connection();
        List<String> facultyList = new ArrayList<>();

        //query
        PreparedStatement statement = connect.prepareStatement("select * from faculty;");
        ResultSet resultSet = statement.executeQuery();

        // collect
        while(resultSet.next()) {

            String f = resultSet.getString("faculty_name");
            facultyList.add(f);
            
            //now return it
        }
        return facultyList;
    }

    public List<String> getCourseByFaculty(String facultyName) throws SQLException{
        //connect
        connect= this.connection();
        List<String> courseCatalog = new ArrayList<>();

        //query
        PreparedStatement statement = connect.prepareStatement("select * from courses where faculty = ?;");
        statement.setString(1, facultyName);
        ResultSet resultSet = statement.executeQuery();

        // collect
        while(resultSet.next()) {
            final String course_id = resultSet.getString("course_id");
            final String course_name = resultSet.getString("course_name");
            final String course_cred = resultSet.getString("CREDIT_HOURS");

            courseCatalog.add(course_id);
            courseCatalog.add(course_name);
            courseCatalog.add(course_cred);
        }
        return courseCatalog;
    }

    public List<String> getSectionByCourse(String facultyName, String courseID) throws SQLException{
        //connect
        connect= this.connection();
        List<String> sectionDetails = new ArrayList<>();

        //query
        PreparedStatement statement = connect.prepareStatement("select * from courses where faculty = ? and course_id = ?;");
        statement.setString(1, facultyName);
        statement.setString(2, courseID);
        ResultSet resultSet = statement.executeQuery();

        // collect
        while(resultSet.next()) {
            final String section = resultSet.getString("section");
            final String days = resultSet.getString("days");
            final String time = resultSet.getString("time");
            final String period = resultSet.getString("period");

            sectionDetails.add(section);
            sectionDetails.add(days);
            sectionDetails.add(time);
            sectionDetails.add(period);
        }
        return sectionDetails;
    }


}
