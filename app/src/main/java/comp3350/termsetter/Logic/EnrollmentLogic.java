package comp3350.termsetter.Logic;

import java.util.ArrayList;
import java.util.List;
import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CourseSection;
import comp3350.termsetter.Persistence.DomainSpecific.hsqldbObjects.EnrollAccess;
import comp3350.termsetter.Persistence.Main;
import comp3350.termsetter.Persistence.StudentPersistence;

/************************
 * Andrea Notes (temporary)
 *
 * Hi Farjad, I got a good look at your branch and started to work on integration. I'll be off for the day and will continue working on this tomorrow evening (in Wpg).
 * However, you can continue working while I am away if you have time today. It's nice to have our process streamlined.
 *    > addCourse and addSection - No need to check against the list since all retrieved enrolled classes are guaranteed to have no dups/conflicts.
 *                                 Check dups with the "courseCode" and check conflicts with the "selectedClass.getTimeSlot()" and "selectedClass.getDays()" instead.
 *                                 I uncommented the constructor parameters and and also added a String parameter for studentID.
 *    > I'm so sorry, I missed the mechanic of checking days. To know if there is a conflict, there have to be similar days as well as overlapping times.
 *      For day conflicts, test string/char equality. Hopefully, it won't be so much work to add
 *    > Good job with the unit tests, they're a nice bunch!
 *      But with the above changes in mind, I have to make revisions so that they reflect the behavior of the methods we want to write. We'll know if our methods work as wanted if the unit tests pass
 ************************/

public class EnrollmentLogic
{
    private List<CourseSection> currClasses;    //Sections for currClasses
    private List<CourseOffering> currCourseCodes;           //CourseCodes for currClasses

    private String courseCode;
    private CourseSection selectedClass;
    private String message;

    private List<String> startTimes;    //startTimes of currClasses
    private List<String> endTimes;      //EndTimes of currClasses
    private EnrollAccess enrollAccess;
    private AccessManager accessManager;
    private StudentPersistence database;
    private String studentID;

    //EnrollmentLogic Constructor
    public EnrollmentLogic(String studentID, String courseCode, CourseSection selectedClass)
    {
        this.courseCode = courseCode;
        this.selectedClass = selectedClass;
        this.studentID = studentID;
        currClasses = new ArrayList<>();
        currCourseCodes = new ArrayList<>();
        startTimes = new ArrayList<>();
        endTimes = new ArrayList<>();
        message = "";
        String path = new String(Main.getDBPathName());
        enrollAccess = new EnrollAccess(path);

        loadClasses();
    }

    public void loadClasses()
    {
        /* SQL problems, Hold my phone
        List<String> results = enrollAccess.getStudentEnrollment(studentID);
        */
        ArrayList<String> results = new ArrayList<String>();

        boolean success = true;
        // adding enrollment results to currClasses
        for(int i = 0; i < results.size() && success; i++){
            String result = results.get(i);
            String[] tokens = result.split("@");
            CourseOffering currCourse = new CourseOffering(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            success = addCourse(currCourse);
            if(success){
                CourseSection currClass = new CourseSection(tokens[3], tokens[4], tokens[5], tokens[6]);
                success = addSection(currClass);
            }
        }


        /*
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
        */
    }

    public boolean addSection(CourseSection courseSection)
    {
        boolean added = false;

        if (!checkConflict(courseSection))
        {
            currClasses.add(courseSection);
            added = true;
        }
        else
        {
            message = "Error: Failed to enroll due to a time conflict!";
            System.out.println(message);
        }
        return added;
    }

    public boolean addCourse(CourseOffering courseOffering)
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

    public String getMessage(){
        return message;
    }

    private void confirmEnroll(){
        enrollAccess.enroll(studentID, selectedClass.getSection(), courseCode);
    }

    //Conflict check method
    public boolean checkConflict(CourseSection courseSection)
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
     public boolean checkCodeDup (CourseOffering courseOffering)
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
    public void getClassTimes(List<CourseSection> currClasses)
    {
        for (int i=0; i<currClasses.size(); i++)
        {
            CourseSection cs = currClasses.get(i);
            parseTimeSlots(cs);
        }
    }


    //function to parse timeslots and add them to start and end time arrays
    public void parseTimeSlots(CourseSection courseSection)
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
