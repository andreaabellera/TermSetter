package comp3350.termsetter.Persistence;

import java.io.Serializable;

public class CourseSection implements Serializable
{
    private final String section;
    private final String days;
    private final String timeSlot;
    private final String instructor;
    private int occupants;
    private int maxOccupancy;
    //private boolean labRequired = false;          // TBD

    public CourseSection(String section, String days, String timeSlot, String instructor)
    {
        this.section = section;
        this.days = days;
        this.timeSlot = timeSlot;
        this.instructor = instructor;
        this.occupants = 0;
    }

    public String getSection() {
        return section;
    }

    public String getDays() { return days; }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getOccupancy(){ return occupants; }

    public void setMaxOccupancy(int max) {
        maxOccupancy = max;
    }

    public void enroll()
    {
        if (courseAvailable())
            occupants++;
    }

    public boolean courseAvailable() {
        return occupants < maxOccupancy;
    }

}

