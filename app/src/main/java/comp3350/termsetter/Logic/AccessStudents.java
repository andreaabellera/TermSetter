package comp3350.termsetter.Logic;

import android.content.Context;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import comp3350.termsetter.Persistence.DomainSpecific.Student;
import comp3350.termsetter.Persistence.StudentPersistence;

public class AccessStudents implements Serializable
{
    private StudentPersistence studentPersistence;
    private List<Student> students;
    private Student student;
    private int currentStudent;


    public AccessStudents() {
        studentPersistence = Services.getRealStudentAccess();

        students = null;
        student = null;
        currentStudent = 0;
    }


    public AccessStudents(Context context) {
        studentPersistence = Services.getFakeStudentAccess(context);
        students = null;
        student = null;
        currentStudent = 0;
    }

    public AccessStudents(final Student student) throws SQLException {
        this();
        this.insertStudent(student);
    }

    public StudentPersistence getStudentPersistence() {
        return studentPersistence;
    }

    public Student insertStudent(Student currentStudent) throws SQLException {
        return studentPersistence.insertStudent(currentStudent);
    }

    public Student getStudent(String student_id) throws SQLException
    {
        return studentPersistence.getStudent(student_id);
    }

}
