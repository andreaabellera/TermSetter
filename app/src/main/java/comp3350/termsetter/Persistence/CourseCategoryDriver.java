package comp3350.termsetter.Persistence;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class CourseCategoryDriver {

    private CourseCategories categories;

    public CourseCategoryDriver(InputStream is) throws IOException {
        init(is);
    }

    public Faculty getFaculty(int index) {
        return categories.getFaculty(index);
    }

    private void init(InputStream is) throws IOException {

        // max 3 sections per course
        final int MAX_VALUE = 3;

        // String Arrays to fill sections constructors
        String[] days = {"MWF", "TTR"};
        String[] timeSlots = {"8:30AM-9:20AM", "11:30AM-12:45PM", "4:00pm-5:15pm", "2:30PM-3:45PM", "12:30PM-1:20PM"};
        String[] sectionArray = {"A01", "A02", "A03"};
        String instructor = "TBD";
        Faculty faculty = null;
        categories = new CourseCategories();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //Read the file and populate Course Objects
        String i = br.readLine();
        while (i != null) {
            if (i.charAt(0) == '$') {
                faculty = new Faculty(i.substring(1));
                categories.addFaculty(faculty);
            } else {
                String[] p = i.split("@");
                CourseOffering course = new CourseOffering(p[0], p[1], parseInt(p[2]));
                faculty.addCourses(course);

                // populate the Section Objects
                for (int x = 0; x < MAX_VALUE; x++) {
                    int randomDays = (int) (Math.random() * days.length);
                    int randomTime = (int) (Math.random() * timeSlots.length);
                    CourseSection section = new CourseSection(sectionArray[x], days[randomDays], timeSlots[randomTime], instructor);
                    course.addSection(section);
                }
            }
            i = br.readLine();
        }
        br.close();
    } // end init

}
