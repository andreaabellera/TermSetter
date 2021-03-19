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
    String courseCode1 = "ENVR1000"; //shouldnt give error
    String courseCode2 = "COMP3350"; //should give error
    CourseSection cSection1 = new CourseSection("A03","TR", "14:30-15:30", "Mr.Awesome"); //error
    CourseSection cSection2 = new CourseSection("A01","MWF", "11:30-12:30", "Dr.Hello"); //no error


    @Test
    public void testAddCourse()
    {
        System.out.println("\nStarting testAddCourse: \n");
    }

    @Test
    public void testAddSection()
    {
        System.out.println("\nStarting testAddSection: \n");
    }

}
