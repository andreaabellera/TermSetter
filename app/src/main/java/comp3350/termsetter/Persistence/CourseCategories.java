package comp3350.termsetter.Persistence;


import java.util.ArrayList;
import java.util.List;

public class CourseCategories {
    private final List<Faculty> faculties;

    public CourseCategories() {
        faculties = new ArrayList<Faculty>();
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Faculty getFaculty(int index) {
        return faculties.get(index);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

}