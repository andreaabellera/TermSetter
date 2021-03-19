package comp3350.termsetter.Persistence;

import java.sql.SQLException;
import java.util.List;

public class CourseCategorySQLDriver implements CourseCategoryPersistence{

    private CourseCategories categories;

    public CourseCategorySQLDriver() throws SQLException {
        init();
    }

    public List<Faculty> getFaculties(){
        return categories.getFaculties();
    }

    private void init(){
        // Connect to hsqldb
        // Execute retrieval queries
        // Result set items must be used as parameters to the create corresponding java course object
        // Close hsqldb

        /*
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
        */
    }
}