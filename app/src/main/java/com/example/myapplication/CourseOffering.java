package com.example.myapplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseOffering implements Serializable {
    private String courseCode;
    private String name;
    private int creditHours;
    private List<CourseSection> sections;

    public CourseOffering(String courseCode, String name, int creditHours) {
        this.courseCode = courseCode;
        this.name = name;
        this.creditHours = creditHours;
        sections = new ArrayList<>();
    }

    public List<CourseSection> getSections() {
        return sections;
    }

    public CourseSection getCourse(int index) {
        return sections.get(index);
    }

    public String getName() {
        return name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void addSection(CourseSection section) {
        sections.add(section);
    }

    public void print() {
        //for debugging
        System.out.println("Sections Details");
        for (int i = 0; i < sections.size(); i++) {
            sections.get(i).print();

        }
    }
}
