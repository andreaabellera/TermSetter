import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;



/*  Needs abstraction badly.
    Read file and populate objects separately maybe?
 */

public class CourseCategoryDriver {
    public static void main(String[] args) throws FileNotFoundException {

        // max 3 sections per course
        final int MAX_VALUE = 3;

        // String Arrays to fill sections constructors
        String[] days = {"MWF", "TTR"};
        String[] timeSlots = {"8:30AM-9:20AM", "11:30AM-12:45PM", "4:00pm-5:15pm", "2:30PM-3:45PM", "12:30PM-1:20PM"};
        String[] sectionArray = {"A01", "A02", "A03"};
        String instructor = "TBD";


        CourseCategories categories = new CourseCategories();
        Faculty faculty = null;

        File courseTextFile = new File("src/DB Template.txt");
        if(!courseTextFile.exists())
            System.out.println("Try again");        // Make this look better

        Scanner sc = new Scanner(courseTextFile);

        //Read the file and populate Course Objects
        while(sc.hasNextLine()) {
            String i = sc.nextLine();
            if(i.equals("")) {
                i = sc.nextLine();
                faculty = new Faculty(i);
                categories.addFaculty(faculty);
            }
            else {
                String[] p = i.split("@");
                CourseOffering course = new CourseOffering(p[0],p[1], parseInt(p[2]));
                faculty.addCourses(course);

                // populate the Section Objects
                for(int x = 0; x < MAX_VALUE; x++) {
                    int randomDays = (int) (Math.random() * days.length);
                    int randomTime = (int) (Math.random() * timeSlots.length);
                    CourseSection section = new CourseSection(sectionArray[x], days[randomDays], timeSlots[randomTime], instructor);
                    course.addSection(section);
                }
            }
        }

        sc.close();
        categories.print();

    }
}
