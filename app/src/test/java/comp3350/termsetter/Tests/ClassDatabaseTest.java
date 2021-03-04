package comp3350.termsetter.Tests;


import org.junit.Test;

import java.util.ArrayList;

import comp3350.termsetter.Persistence.*;
import static org.junit.Assert.*;

public class ClassDatabaseTest {

    @Test
    public void testCreateCourseCategories() {
        System.out.println("\nStarting testCreateCourseCategories: object exists after creation\n");
        CourseCategories ct = new CourseCategories();
        assertNotNull(ct);
        System.out.println("\nEnd testCreateCourseCategories: object exists after creation\n");
    }

    @Test
    public void testAddFaculty() {
        System.out.println("\nStarting testAddFaculty: correct object retrieved\n");
        CourseCategories ct = new CourseCategories();
        String fName = "Faculty of tests";
        ct.addFaculty(new Faculty(fName));
        Faculty myFaculty = ct.getFaculty(0);
        assertEquals(myFaculty.getName(), fName);
        System.out.println("\nEnd testAddFaculty: correct object retrieved\n");
    }

    @Test
    public void testGetFacultyArray() {
        System.out.println("\nStarting testGetFacultyArray: retrieving a list\n");
        CourseCategories ct = new CourseCategories();
        String fName1 = "Faculty of tests";
        String fName2 = "Faculty of exams";
        ct.addFaculty(new Faculty(fName1));
        ct.addFaculty(new Faculty(fName2));
        ArrayList<Faculty> faculties = (ArrayList<Faculty>) ct.getFaculties();
        assertEquals(faculties.get(0).getName(), fName1);
        assertEquals(faculties.get(1).getName(), fName2);
        System.out.println("\nEnd testGetFacultyArray: retrieving a list\n");
    }

    @Test
    public void testCreateFaculty() {
        System.out.println("\nStarting testCreateFaculty: object exists after creation\n");
        Faculty f = new Faculty("A Faculty");
        assertNotNull(f);
        System.out.println("\nEnd testCreateFaculty: object exists after creation\n");
    }

    @Test
    public void testAddCourse() {
        System.out.println("\nStarting testAddCourse: correct object retrieved\n");
        Faculty f = new Faculty("Faculty of tests");
        String courseName = "Testing1020";
        f.addCourses(new CourseOffering("TEST1020", courseName, 3));
        CourseOffering myCourse = f.getCourse(0);
        assertEquals(myCourse.getName(), courseName);
        System.out.println("\nEnd testAddCourse: correct object retrieved\n");
    }

    @Test
    public void testGetCourseArray() {
        System.out.println("\nStarting testGetCourseArray: retrieving a list\n");
        Faculty f = new Faculty("Computer Science");
        String code1 = "COMP4040";
        String code2 = "COMP5050";
        f.addCourses(new CourseOffering(code1, "Arbitrary", 2));
        f.addCourses(new CourseOffering(code2, "Arbitrary", 3));
        ArrayList<CourseOffering> co = (ArrayList<CourseOffering>) f.getCourses();
        assertEquals(co.get(0).getCourseCode(), code1);
        assertEquals(co.get(1).getCourseCode(), code2);
        System.out.println("\nEnd testGetCourseArray: retrieving a list\n");
    }

    @Test
    public void testCreateCourseOffering() {
        System.out.println("\nStarting testCreateCourseOffering: object exists after creation\n");
        CourseOffering co = new CourseOffering("COU8888", "How to not fail as tester", 3);
        assertNotNull(co);
        System.out.println("\nEnd testCreateCourseOffering: object exists after creation\n");
    }

    @Test
    public void testAddSection() {
        System.out.println("\nStarting testAddSection: correct object retrieved\n");
        CourseOffering co = new CourseOffering("COFF1000", "Drinking Coffee", 3);
        String prof = "A Coffee Mug";
        co.addSection(new CourseSection("A01", "MW", "1:00am - 2:00am", prof));
        CourseSection mySection = co.getCourse(0);
        assertEquals(mySection.getInstructor(), prof);
        System.out.println("\nEnd testAddSection: correct object retrieved\n");
    }

    @Test
    public void testGetSectionArray() {
        System.out.println("\nStarting testGetSectionArray: retrieving a list\n");
        CourseOffering co = new CourseOffering("YES2021", "We're so Done", 3);
        String red = "Red Prof";
        String yellow = "Yellow Prof";
        co.addSection(new CourseSection("A01", "Everyday", "3:30 - 9:20", red));
        co.addSection(new CourseSection("A02", "M", "9:20 - 3:30", yellow));
        ArrayList<CourseSection> s = (ArrayList<CourseSection>) co.getSections();
        assertEquals(s.get(0).getInstructor(), red);
        assertEquals(s.get(1).getInstructor(), yellow);
        System.out.println("\nEnd testGetSectionArray: retrieving a list\n");
    }

    @Test
    public void testCreateSection() {
        System.out.println("\nStarting testCreateSection: object exists after creation\n");
        CourseSection s = new CourseSection("T01", "MTWRF", "8:30pm - 9:30pm", "Test Dr.");
        assertNotNull(s);
        System.out.println("\nEnd testCreateSection: object exists after creation\n");
    }
}

