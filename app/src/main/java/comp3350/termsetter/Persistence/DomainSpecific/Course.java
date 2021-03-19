package comp3350.termsetter.Persistence.DomainSpecific;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseID;
    private String courseName;
    private int courseCreditHours;
    private String courseSection;
    private String courseDays;
    private String courseTime;
    private String coursePeriod;
    private String courseInstructor;

    public Course(String courseID, String courseName, int courseCreditHours,
                  String courseSection, String courseDays, String courseTime,
                  String coursePeriod, String courseInstructor){

        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCreditHours = courseCreditHours;
        this.courseSection = courseSection;
        this.courseDays = courseDays;
        this.courseTime = courseTime;
        this.coursePeriod = coursePeriod;
        this.courseInstructor = courseInstructor;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseCreditHours() {
        return courseCreditHours;
    }

    public String getCourseSection() {
        return courseSection;
    }

    public String getCourseDays() {
        return courseDays;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public String getCoursePeriod() {
        return coursePeriod;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }


}
