package comp3350.termsetter.Tests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Logic.EnrollmentLogic;
import comp3350.termsetter.Persistence.*;
import static org.junit.Assert.*;

public class EnrollmentLogicTest
{
    String courseCode1;
    String courseCode2;
    CourseSection cSection1;
    CourseSection cSection2;


    @Test
    public void testAddCourse()
    {
        System.out.println("\nStarting testAddCourse: object exists after creation\n");

        courseCode1 = "ENVR1000"; //no error
        assertTrue(EnrollmentLogic.addCourse(courseCode1));

        courseCode2 = "COMP3350"; //error
        assertFalse(EnrollmentLogic.addCourse(courseCode2));

        System.out.println("\nEnding testAddCourse: object exists after creation\n");
    }

    @Test
    public void testAddSection()
    {
        System.out.println("\nStarting testAddSection: object exists after creation\n");

        cSection1 = new CourseSection("A01","MWF", "11:30-12:30", "Dr.Hello"); //no error
        assertTrue(EnrollmentLogic.addSection(cSection1));

        cSection2 = new CourseSection("A03","TR", "14:30-15:30", "Mr.Awesome"); //error
        assertFalse(EnrollmentLogic.addSection(cSection2));

        System.out.println("\nEnding testAddSection: object exists after creation\n");
    }

}
