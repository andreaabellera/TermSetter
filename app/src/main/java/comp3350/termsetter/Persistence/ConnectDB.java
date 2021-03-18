package comp3350.termsetter.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
    final String dbpath;
    public ConnectDB(String dbPath) {
        this.dbpath = dbPath;
        Connection con = null;

        try {
            //Registering the HSQLDB JDBC driver
            Class.forName("org.hsqldb.jdbcDriver");
            //Creating the connection with HSQLDB
            con = DriverManager.getConnection("jdbc:hsqldb:file:" + dbpath + ";shutdown=true", "SA", "");

            if (con != null) {
                System.out.println("Connection created successfully");
               /* try {
                    PreparedStatement ps = con.prepareStatement(
                            "select * from courses");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        System.out.println("ID = " + rs.getString("course_id") +
                                ", Name = " + rs.getString("course_name") + " Credit hours= "
                                + rs.getString("credit_hours"));

                    }
                    rs.close();
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }*/
            }
            else{
                System.out.println("Problem with creating connection");
            }

        }
          catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}