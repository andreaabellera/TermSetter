package comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    private void getAllCourses() throws SQLException {
        // first connect
        connect= this.connection();

        //query
        PreparedStatement statement = connect.prepareStatement("select * from courses");
        ResultSet resultSet = statement.executeQuery();

        // collect
        while(resultSet.next()) {






        }
    }

}
