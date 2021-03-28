package comp3350.termsetter.Tests;

import org.junit.Before;
import org.junit.Test;

import comp3350.termsetter.Logic.EnrollmentLogic;
import comp3350.termsetter.Persistence.*;
import static org.junit.Assert.*;

public class EnrollmentLogicTest
{
    CourseOffering courseO1;
    CourseOffering courseO2;
    CourseSection cSection1;
    CourseSection cSection2;
    EnrollmentLogic eL;

    @Before
    public void setContext()
    {
        eL = new EnrollmentLogic();

        courseO1 = new CourseOffering("ENVR1000", "Env", 3); //no error
        courseO2 = new CourseOffering("COMP3350", "SE", 3); //error

        cSection1 = new CourseSection("A01","MWF", "11:30-12:30", "Dr.Hello"); //no error
        cSection2 = new CourseSection("A03","TR", "14:31-15:31", "Mr.Awesome"); //error
    }


    @Test
    public void testAddCourse()
    {
        System.out.println("\nStarting testAddCourse: object exists after creation\n");

        assertTrue(eL.addCourse(courseO1));
        assertFalse(eL.addCourse(courseO2));

        System.out.println("\nEnding testAddCourse: object exists after creation\n");
    }

    @Test
    public void testAddSection()
    {
        System.out.println("\nStarting testAddSection: object exists after creation\n");

        assertTrue(eL.addSection(cSection1));
        assertFalse(eL.addSection(cSection2));

        System.out.println("\nEnding testAddSection: object exists after creation\n");
    }

}
