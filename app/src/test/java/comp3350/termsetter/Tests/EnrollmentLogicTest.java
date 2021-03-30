package comp3350.termsetter.Tests;

import org.junit.Before;
import org.junit.Test;

import comp3350.termsetter.Logic.EnrollmentLogic;
import comp3350.termsetter.Persistence.*;
import static org.junit.Assert.*;

public class EnrollmentLogicTest
{
    EnrollmentLogic eL;

    @Before
    public void setContext()
    {
        String courseCode = "COMP3350";
        CourseSection selectedClass = new CourseSection("A01","MWF", "11:30-12:30", "2021/01/18-2021/04/18");
        eL = new EnrollmentLogic("test1", courseCode, selectedClass);
    }


    @Test
    public void testAddCourseSuccess()
    {
        System.out.println("\nStarting testAddCourseSuccess: course is not a duplicate\n");

        CourseOffering successCourse = new CourseOffering("ENVR1000", "Env", 3);
        assertTrue(eL.addCourse(successCourse));

        System.out.println("\nEnding testAddCourseSuccess: course is not a duplicate\n");
    }

    @Test
    public void testAddCourseFail()
    {
        System.out.println("\nStarting testAddCourseFail: course is a duplicate\n");

        CourseOffering failCourse = new CourseOffering("COMP3350", "SE", 3);
        assertFalse(eL.addCourse(failCourse));

        System.out.println("\nEnding testAddCourseFail: course is a duplicate\n");
    }

    @Test
    public void testAddSectionSuccess()
    {
        System.out.println("\nStarting testAddSectionSuccess: section does not have a conflict\n");

        CourseSection successSection = new CourseSection("A03","TR", "14:31-15:31", "2021/01/18-2021/04/18");
        assertTrue(eL.addSection(successSection));

        System.out.println("\nEnding testAddSection: section does not have a conflict\n");
    }

    @Test
    public void testAddSectionSameTimeDiffDay()
    {
        System.out.println("\nStarting testAddSectionSameTimeDiffDay: section does not have a conflict\n");

        CourseSection successSection = new CourseSection("A02","TR", "11:30-12:30", "2021/01/18-2021/04/18");
        assertTrue(eL.addSection(successSection));

        System.out.println("\nEnding testAddSectionSameTimeDiffDay: section does not have a conflict\n");
    }

    @Test
    public void testAddSectionFail()
    {
        System.out.println("\nStarting testAddSectionFail: section has a conflict\n");

        CourseSection failSection = new CourseSection("A01","MWF", "11:30-12:30", "2021/01/18-2021/04/18");
        assertFalse(eL.addSection(failSection));

        System.out.println("\nEnding testAddSectionFail: section has a conflict\n");
    }

}
