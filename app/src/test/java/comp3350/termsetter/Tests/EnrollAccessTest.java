package comp3350.termsetter.Tests;

import android.app.Application;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.*;
import comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects.EnrollAccess;
import comp3350.termsetter.utils.TestUtils;;

public class EnrollAccessTest {

    EnrollAccess ea;
    private File tempDB;

    @Before
    public void setup() throws IOException {
        this.tempDB = TestUtils.copyDB();
        ea = new EnrollAccess(this.tempDB.getAbsolutePath().replace(".script", ""));
    }

    @Test
    public void testEnrollAccessExists() throws SQLException{
        System.out.println("\nStarting testEnrollAccessExists: object exists after creation\n");
        assertNotNull(ea);
        System.out.println("End testEnrollAccessExists: object exists after creation\n");
    }

    @Test
    public void testGetEnrollments() throws SQLException {
        System.out.println("\nStarting testGetEnrollments: objects are retrieved\n");
        String testStudent = "test1";
        List<String> enrollments = ea.getStudentEnrollment(testStudent);
        assertNotNull(enrollments);
        System.out.println("End testGetEnrollments: objects are retrieved\n");
    }

    @Test
    public void testGetEnrollmentsResultSetComplete() throws SQLException {
        System.out.println("\nStarting testGetEnrollmentsResultSetComplete: objects are retrieved\n");
        String testStudent = "test1";
        List<String> enrollments = ea.getStudentEnrollment(testStudent);
        String[] resultSet = enrollments.get(0).split("@");
        assertEquals(resultSet.length, 7);
        System.out.println("End testGetEnrollmentsResultSetComplete: objects are retrieved\n");
    }

}
