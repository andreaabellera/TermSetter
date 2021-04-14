package comp3350.termsetter.Tests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Logic.EnrollmentLogic;
import comp3350.termsetter.Logic.TimetableLogic;
import comp3350.termsetter.Persistence.*;
import static org.junit.Assert.*;

public class TimetableLogicTest {
    TimetableLogic tL;
    List<CourseOffering> courseList;
    List<CourseSection> sectionList;

    CourseOffering earlyMWFCourse = new CourseOffering("COMP3010", "Distributed Computing", 3);
    CourseSection earlyMWFSection = new CourseSection("A01","MW", "10:30-11:30", "2021/01/18-2021/04/18");
    CourseOffering lateMWFCourse = new CourseOffering("COMP3350", "Software Engineering", 3);
    CourseSection lateMWFSection = new CourseSection("A01","MWF", "1:30-2:30", "2021/01/18-2021/04/18");
    CourseOffering earlyTRCourse = new CourseOffering("COMP4020", "Human-Computer Interaction 2", 3);
    CourseSection earlyTRSection = new CourseSection("A01","TR", "9:30-10:30", "2021/01/18-2021/04/18");
    CourseOffering lateTRCourse = new CourseOffering("COMP4380", "Database Implementation", 3);
    CourseSection lateTRSection = new CourseSection("A01","TR", "13:30-14:30", "2021/01/18-2021/04/18");
    CourseOffering thursdayCourse = new CourseOffering("SDC1000", "Single Day Course", 1);
    CourseSection thursdaySection = new CourseSection("A01","R", "8:30-9:30", "2021/01/18-2021/04/18");

    @Before
    public void setUp() {
        // Course list setup
        courseList = new ArrayList<CourseOffering>();
        courseList.add(lateMWFCourse);
        courseList.add(earlyMWFCourse);
        courseList.add(earlyTRCourse);
        courseList.add(lateTRCourse);
        courseList.add(thursdayCourse);

        // Section list setup
        sectionList = new ArrayList<CourseSection>();
        sectionList.add(lateMWFSection);
        sectionList.add(earlyMWFSection);
        sectionList.add(earlyTRSection);
        sectionList.add(lateTRSection);
        sectionList.add(thursdaySection);

        tL = new TimetableLogic(courseList, sectionList);
    }

    @Test
    public void testMondayItems() {
        System.out.println("\nStarting testMondayItems: correct number of items\n");

        List<CourseOffering> mondayClasses = tL.getCourse("M");
        assertEquals(mondayClasses.size(), 2);

        System.out.println("\nEnding testMondayItems: correct number of items\n");
    }

    @Test
    public void testMondaySequential() {
        System.out.println("\nStarting testMondaySequential: correct sequence of items\n");

        List<CourseOffering> mondayClasses = tL.getCourse("M");
        // TBD

        System.out.println("\nEnding testMondaySequential: correct sequence of items\n");
    }

    @Test
    public void testTuesdayItems() {
        System.out.println("\nStarting testTuesdayItems: correct number of items\n");

        List<CourseOffering> tuesdayClasses = tL.getCourse("T");
        assertEquals(tuesdayClasses.size(), 2);

        System.out.println("\nEnding testTuesdayItems: correct number of items\n");
    }

    @Test
    public void testTuesdaySequential() {
        System.out.println("\nStarting testTuesdaySequential: correct sequence of items\n");

        List<CourseOffering> tuesdayClasses = tL.getCourse("T");
        // TBD

        System.out.println("\nEnding testTuesdaySequential: correct sequence of items\n");
    }

    @Test
    public void testWednesdayItems() {
        System.out.println("\nStarting testWednesdayItems: correct number of items\n");

        List<CourseOffering> wednesdayClasses = tL.getCourse("W");
        assertEquals(wednesdayClasses.size(), 2);

        System.out.println("\nEnding testwednesdayItems: correct number of items\n");
    }

    @Test
    public void testWednesdaySequential() {
        System.out.println("\nStarting testWednesdaySequential: correct sequence of items\n");

        List<CourseOffering> wednesdayClasses = tL.getCourse("W");
        // TBD

        System.out.println("\nEnding testWednesdaySequential: correct sequence of items\n");
    }

    @Test
    public void testThursdayItems() {
        System.out.println("\nStarting testThursdayItems: correct number of items\n");

        List<CourseOffering> thursdayClasses = tL.getCourse("R");
        assertEquals(thursdayClasses.size(), 3);

        System.out.println("\nEnding testTuesdayItems: correct number of items\n");
    }

    @Test
    public void testThursdaySequential() {
        System.out.println("\nStarting testThursdaySequential: correct sequence of items\n");

        List<CourseOffering> thursdayClasses = tL.getCourse("R");
        // TBD

        System.out.println("\nEnding testThursdaySequential: correct sequence of items\n");
    }

    @Test
    public void testFridayItems() {
        System.out.println("\nStarting testFridayItems: correct number of items\n");

        List<CourseOffering> fridayClasses = tL.getCourse("F");
        assertEquals(fridayClasses.size(), 2);

        System.out.println("\nEnding testFridayItems: correct number of items\n");
    }

    @Test
    public void testFridaySequential() {
        System.out.println("\nStarting testFridaySequential: correct sequence of items\n");

        List<CourseOffering> fridayClasses = tL.getCourse("F");
        // TBD

        System.out.println("\nEnding testFridaySequential: correct sequence of items\n");
    }

    @Test
    public void testCourseSort() {
        System.out.println("\nStarting testCourseSort: correct sequence of items\n");

        List<CourseOffering> sortedCourses = tL.sort(courseList, sectionList);
        // TBD

        System.out.println("\nEnding testCourseSort: correct sequence of items\n");
    }

    @Test
    public void testSectionSort() {
        System.out.println("\nStarting testSectionSort: correct sequence of items\n");

        List<CourseSection> sortedSections = tL.sort(sectionList);
        // TBD

        System.out.println("\nEnding testSectionSort: correct sequence of items\n");
    }

    @Test
    public void testParseTime() {
        System.out.println("\nStarting testParseTime: expected return\n");

        String time = "0:15";
        assertEquals(tL.parseTime(time), 15);

        System.out.println("\nEnding testParseTime: expected return\n");
    }

    @Test
    public void testCalculateMinutes() {
        System.out.println("\nStarting testCalculateMinutes: expected return\n");

        int hours = 3;
        int minutes = 20;
        int totalMinutes = hours * 60 + minutes;
        assertEquals(tL.calculateMinutes(hours, minutes), totalMinutes);

        System.out.println("\nEnding testCalculateMinutes: expected return\n");
    }

}
