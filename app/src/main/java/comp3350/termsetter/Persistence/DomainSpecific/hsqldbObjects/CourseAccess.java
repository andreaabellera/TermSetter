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
    //what does this need to work?
    //need all the courses
    private final String dbPath;

    public CourseAccess(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    public List<String> getAllCourses() throws SQLException {
        // first connect
        connect= this.connection();
        List<String> courseCatalog = new ArrayList<>();

        //query
        PreparedStatement statement = connect.prepareStatement("select * from courses");
        ResultSet resultSet = statement.executeQuery();

        // collect
        while(resultSet.next()) {

            final String course_id = resultSet.getString("course_id");
            final String course_name = resultSet.getString("course_name");

            // add more rows of what you need later
            //put them in a list for now
            final String course = course_id+ " " +course_name;
            courseCatalog.add(course);
            
            //now return it
            
            

        }
        return courseCatalog;
    }


}
