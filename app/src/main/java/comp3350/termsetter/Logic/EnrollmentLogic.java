package comp3350.termsetter.Logic;

import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CourseSection;
//import comp3350.termsetter.Persistence.DomainSpecific.User;


public class EnrollmentLogic
{
    private static List<CourseSection> currClasses;    //Sections for currClasses
    private static List<CourseOffering> currCourseCodes;           //CourseCodes for currClasses

    //private String courseCode;
    //private CourseSection selectedClass;
    private static String message;

    private static List<String> startTimes;    //startTimes of currClasses
    private static List<String> endTimes;      //EndTimes of currClasses

    //EnrollmentLogic Constructor
    public EnrollmentLogic()
    {
        //String courseCode, CourseSection selectedClass
        //this.courseCode = courseCode;
        //this.selectedClass = selectedClass;
        currClasses = new ArrayList<>();
        currCourseCodes = new ArrayList<>();
        startTimes = new ArrayList<>();
        endTimes = new ArrayList<>();
        message = "";
        //access = new EnrollmentAccess(user);

        loadClasses();
    }

    public void loadClasses()
    {
        /* will replace access.getClasses() from database **/

        //adding Course Sections to current classes
        CourseSection cS1 = new CourseSection("A01","MWF", "10:30-11:30", "Mr.Awesome");
        currClasses.add(cS1);
        CourseSection cS2 = new CourseSection("A02","TR", "12:30-13:30", "Mr Insto");
        currClasses.add(cS2);
        CourseSection cS3 = new CourseSection("A01","MWF", "13:30-14:15", "Mr yellow");
        currClasses.add(cS3);
        CourseSection cS4 = new CourseSection("A03","TR", "14:30-15:30", "Mr.Awesome");
        currClasses.add(cS4);

        //adding Course Codes to current courseCodes
        CourseOffering cO1 = new CourseOffering("COMP3350", "SE", 3);
        currCourseCodes.add(cO1);
        CourseOffering cO2 = new CourseOffering("BUSS4350", "Bus", 3);
        currCourseCodes.add(cO2);
        CourseOffering cO3 = new CourseOffering("COMP3450", "OS", 3);
        currCourseCodes.add(cO3);
        CourseOffering cO4 = new CourseOffering("PSYC3300", "Psy", 3);
        currCourseCodes.add(cO4);

    }

    public static boolean addSection(CourseSection courseSection)
    {
        boolean added = false;

        if (!checkConflict(courseSection))
        {
            currClasses.add(courseSection);
            added = true;
        }
        else
        {
            message = "Error: Failed to enrol due to a time conflict!";
            System.out.println(message);
        }
        return added;
    }

    public static boolean addCourse(CourseOffering courseOffering)
    {
        boolean added = false;

        if (!checkCodeDup(courseOffering))
        {
            currCourseCodes.add(courseOffering);
            added = true;
        }
        else
        {
            message = "Error: Already enrolled in this course! ";
            System.out.println(message);
        }
        return added;
    }



    //Conflict check method
    public static boolean checkConflict(CourseSection courseSection)
    {
        boolean conflict = false;

        //get timesSlots from currClasses
        getClassTimes(currClasses);

        //add timeSlot of new class to start&endTime lists
        //parseTimeSlots(courseSection);

        String timeS = courseSection.getTimeSlot();
        String[] tSlots = timeS.split("-");
        int start = parseTime(tSlots[0]);
        int end = parseTime(tSlots[1]);


        for (int i=0; i<startTimes.size(); i++)
        {
            int classStart = parseTime(startTimes.get(i));
            int classEnd = parseTime(endTimes.get(i));

            if (end > classStart && end < classEnd)
                conflict = true;

            else if (start > classStart && start < classEnd)
                conflict = true;

            /**
            //end of each class checked with each starting time
            for(int e=0; e<endTimes.size(); e++)
            {
                //if (e==i) continue;
                int end = parseTime(endTimes.get(e));
                if (end > classStart && end < classEnd )
                {
                    conflict = true;
                }
            }

            //start of class between a time slot
            for (int s=0; s<startTimes.size(); s++)
            {
                //if (s == i) continue;
                int start = parseTime(startTimes.get(s));
                if (start > classStart && start < classEnd)
                {
                    conflict = true;
                }
            } **/
        }

        return conflict;
    }

    //function to check code duplicates
     public static boolean checkCodeDup (CourseOffering courseOffering)
     {
         boolean conflict = false;
         String courseCode = courseOffering.getCourseCode();

         for (int i=0; i<currCourseCodes.size(); i++)
         {
             if (courseCode.equals(currCourseCodes.get(i).getCourseCode()))
             {
                conflict = true;
             }
         }
         return conflict;
     }


    //function to add time slots for each class to start&endTimes arrays
    public static void getClassTimes(List<CourseSection> currClasses)
    {
        for (int i=0; i<currClasses.size(); i++)
        {
            CourseSection cs = currClasses.get(i);
            parseTimeSlots(cs);
        }
    }


    //function to parse timeslots and add them to start and end time arrays
    public static void parseTimeSlots(CourseSection courseSection)
    {
        String timeS = courseSection.getTimeSlot();
        String[] tSlots = timeS.split("-");
        startTimes.add(tSlots[0]);              //add starting time to startTimes
        endTimes.add(tSlots[1]);                //add ending time to endTimes
    }

    //function to parse time
    public static int parseTime(String time)
    {
        String[] timeParts = time.split(":");
        int hour = Integer.parseInt(timeParts[0].trim());
        int mins = Integer.parseInt(timeParts[1].trim());

        return calculateMinutes(hour,mins);
    }

    //helper for changing time into minutes
    public static int calculateMinutes(int hour, int minute)
    {
        return hour*60+minute;
    }

}
