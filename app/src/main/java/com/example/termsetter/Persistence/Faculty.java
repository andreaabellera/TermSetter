package com.example.termsetter.Persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Faculty implements Serializable {
    private String name;
    private List<CourseOffering> listOfCourses;

    public Faculty(String name) {
        this.name = name;
        listOfCourses = new ArrayList<>();
    }

    public List<CourseOffering> getCourses(){
        return listOfCourses;
    }

    public String getName() {
        return name;
    }
    public CourseOffering getCourse(int index){
        return listOfCourses.get(index);
    }

    public void addCourses(CourseOffering course) {
        listOfCourses.add((course));
    }

    public void print() {
        //for debugging
        for(int i = 0; i < listOfCourses.size(); i++) {
            System.out.println("Course");
            System.out.print(listOfCourses.get(i).getCourseCode() + "\t");
            System.out.print(listOfCourses.get(i).getName()+ "\t\t");
            System.out.println(listOfCourses.get(i).getCreditHours());
            listOfCourses.get(i).print();
        }
    }
}

