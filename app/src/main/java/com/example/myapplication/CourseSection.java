package com.example.myapplication;

import java.io.Serializable;

public class CourseSection implements Serializable {
    private String section;
    private String days;
    private String timeSlot;
    private String instructor;

    public CourseSection(String section, String days, String timeSlot, String instructor){
        this.section = section;
        this.days = days;
        this.timeSlot = timeSlot;
        this.instructor = instructor;
    }

    public String getSection() {
        return section;
    }

    public String getDays() {

        return days;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getInstructor() {
        return instructor;
    }

    public void print() {
        //for debugging

        System.out.print(section + "\t");
        System.out.print(days + "\t");
        System.out.print(timeSlot + "\t");
        System.out.print(instructor + "\t");
        }
    }

