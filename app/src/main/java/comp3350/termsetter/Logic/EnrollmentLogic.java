package comp3350.termsetter.Logic;

import java.util.ArrayList;
import java.util.List;

import comp3350.termsetter.Persistence.CourseSection;
import comp3350.termsetter.Persistence.DomainSpecific.User;


public class EnrollmentLogic
{
    private List<CourseSection> currClasses;    //Sections for currClasses
    private String[] currCourseCodes;           //CourseCodes for currClasses

    private String courseCode;
    CourseSection selectedClass;
    String message;

    private String[] startTimes;    //startTimes of currClasses
    private String[] endTimes;      //EndTimes of currClasses

    int maxClasses = 6;             //maxNo.ofClassesAllowed

    //EnrollmentLogic Constructor
    public EnrollmentLogic(String courseCode, CourseSection selectedClass, User user)
    {
        this.courseCode = courseCode;
        this.selectedClass = selectedClass;
        currClasses = new ArrayList<>();
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
        currCourseCodes = addT(maxClasses, currCourseCodes, "COMP3350");
        currCourseCodes = addT(maxClasses, currCourseCodes, "BUSS4350");
        currCourseCodes = addT(maxClasses, currCourseCodes, "COMP3450");
        currCourseCodes = addT(maxClasses, currCourseCodes, "PSYC3300");

    }

    public boolean addSection(CourseSection courseSection)
    {
        boolean added = false;

        if (!checkConflict(courseSection))
        {
            currClasses.add(courseSection);
            added = true;
        }
        return added;
    }

    public boolean addCourse(String courseCode)
    {
        boolean added = false;

        if (!checkCodeDup(courseCode))
        {
            currCourseCodes = addT(maxClasses,currCourseCodes,courseCode);
            added = true;
        }
        return added;
    }



    //Conflict check method
    public boolean checkConflict(CourseSection courseSection)
    {
        boolean conflict = false;

        //get timesSlots from currClasses
        getClassTimes(currClasses);

        //add timeSlot of new class to start&endTime arrays
        parseTimeSlots(courseSection);

        for (int i=0; i<maxClasses; i++)
        {
            int classStart = parseTime(startTimes[i]);
            int classEnd = parseTime(endTimes[i]);

            //end of each class checked with each starting time
            for(int e=0; e<maxClasses; e++)
            {
                if (e==i) continue;
                int end = parseTime(endTimes[e]);
                if (end > classStart && end < classEnd )
                {
                    conflict = true;
                }
            }

            //start of class between a time slot
            for (int s=0; s<maxClasses; s++)
            {
                if (s == i) continue;
                int start = parseTime(startTimes[s]);
                if (start > classStart && start < classEnd)
                {
                    conflict = true;
                }
            }
        }
        return conflict;
    }

    //function to check code duplicates
     public boolean checkCodeDup (String courseCode)
     {
        boolean conflict = false;

         for (int i=0; i<currClasses.size(); i++)
         {
             if (courseCode.equals(currCourseCodes[i]))
             {
                conflict = true;
            }
         }
        return conflict;
     }


    //function to add time slots for each class to start&endTimes arrays
    public void getClassTimes(List<CourseSection> currClasses)
    {
        for (int i=0; i<currClasses.size(); i++) {
            CourseSection cs = currClasses.get(i);
            parseTimeSlots(cs);
        }
    }


    //function to parse timeslots and add them to start and end time arrays
    public void parseTimeSlots(CourseSection courseSection)
    {
        String timeS = courseSection.getTimeSlot();
        String[] tSlots = timeS.split("-");
        startTimes = addT(maxClasses, startTimes, tSlots[0]);              //add starting time to startTimes
        endTimes = addT(maxClasses, endTimes, tSlots[1]);                //add ending time to endTimes
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

    //adder method for arrays
    private static String[] addT(int n, String[] array, String item)
    {
        String[] newArray = new String[n+1];

        for(int i=0; i<n; i++)
            newArray[i] = array[i];

        newArray[n] = item;

        return newArray;
    }

    public List<CourseSection> getCurrClasses() { return currClasses; }

    public boolean isEmpty() { return currClasses.isEmpty(); }
}
