package comp3350.termsetter.Logic;

import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CourseSection;

public class TimetableLogic {
    List<CourseOffering> studentCourses;
    List<CourseSection> studentSections;
    int coursesNum;

    public TimetableLogic (List<CourseOffering> enrolledCourses, List<CourseSection> enrolledSections) {
        studentCourses = enrolledCourses;
        studentSections = enrolledSections;
        coursesNum = studentCourses.size();
    }

    public List<CourseOffering> getCourse(String day) {
        List<CourseOffering> courses = new ArrayList<>();
        List<CourseSection> sections = new ArrayList<>();

        for (int i = 0; i < coursesNum; i++) {
            CourseOffering course = studentCourses.get(i);
            CourseSection section = studentSections.get(i);
            if (section.getDays().contains(day)) {
                courses.add(course);
            }
        }
        return courses;
    }

    public List<CourseSection> getSection(String day) {
        List<CourseSection> sections = new ArrayList<>();

        for (int i = 0; i < coursesNum; i++) {
            CourseSection section = studentSections.get(i);
            if (section.getDays().contains(day)) {
                sections.add(section);
            }
        }
        return sections;
    }
}