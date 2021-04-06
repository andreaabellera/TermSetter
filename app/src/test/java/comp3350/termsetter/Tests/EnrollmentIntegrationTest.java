package comp3350.termsetter.Tests;

import org.junit.Before;
import org.junit.Test;

import comp3350.termsetter.Logic.EnrollmentLogic;
import comp3350.termsetter.Persistence.*;
import static org.junit.Assert.*;

public class EnrollmentIntegrationTest
{
    EnrollmentLogic eL;

    @Before
    public void init()
    {
        String courseCode = "COMP3350";
        CourseSection selectedClass = new CourseSection("A01","MWF", "11:30-12:30", "2021/01/18-2021/04/18");
        eL = new EnrollmentLogic("test1", courseCode, selectedClass);

        // TBD by Andrea
        // Create EnrollAccess
        // Add first class
        // Add second class
    }


    @Test
    public void testGetSuccessMessage()
    {
        System.out.println("\nStarting testGetSuccessMessage: success message present\n");

        // things
        assertTrue(eL.getMessage().contains("Successfully enrolled"));

        System.out.println("\nEnding testGetSuccessMessage: success message present\n");
    }

    @Test
    public void testGetConflictMessage()
    {
        System.out.println("\nStarting testGetConflictMessage: conflict message present\n");

        // things
        assertTrue(eL.getMessage().contains("Error: Failed to enroll due to a time conflict"));

        System.out.println("\nEnding testGetConflictMessage: conflict message present\n");
    }

    @Test
    public void testGetDuplicateMessage()
    {
        System.out.println("\nStarting testGetDuplicateMessage: duplicate message present\n");

        // things
        assertEquals(eL.getMessage(), "Error: Already enrolled in this course!");

        System.out.println("\nEnding testGetDuplicateMessage: duplicate message present\n");
    }
}
