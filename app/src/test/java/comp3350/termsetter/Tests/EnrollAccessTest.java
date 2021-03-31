package comp3350.termsetter.Tests;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.*;
import comp3350.termsetter.Logic.OfferedClassLogic;
import comp3350.termsetter.Persistence.CourseCategoryPersistence;
import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CourseSection;
import comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects.CourseAccess;
import comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects.EnrollAccess;
import comp3350.termsetter.Persistence.Faculty;
import comp3350.termsetter.Persistence.Main;
import comp3350.termsetter.Presentation.OfferedClassesCategories;

public class EnrollAccessTest {

    EnrollAccess ea;

    @Before
    public void setup(){
        String path = Main.getDBPathName();
        ea = new EnrollAccess(path);
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

}
