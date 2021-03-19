package comp3350.termsetter.Persistence.DomainSpecific;

import java.util.List;

public interface CoursePersistence {
    List<Course> getCourseSequential();

    List<Course> getCourseRandom(Course currentCourse);

    Course insertCourse(Course currentCourse);

    Course updateCourse(Course currentCourse);

    void deleteCourse(Course currentCourse);
}
