import java.util.ArrayList;
import java.util.List;

public class CourseCategories {
    private List<Faculty> faculties;

    public CourseCategories() {
        faculties= new ArrayList<Faculty>();
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Faculty getFaculty(int index){
        return faculties.get(index);
    }
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void print() {
        //for debugging

        for(int i = 0; i < faculties.size(); i++) {
            System.out.println("Faculty");
            System.out.println(faculties.get(i).getName());
            faculties.get(i).print();

        }
    }

}