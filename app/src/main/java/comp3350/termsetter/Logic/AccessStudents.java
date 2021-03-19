package comp3350.termsetter.Logic;

import android.content.Context;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import comp3350.termsetter.Persistence.UserPersistence;
import comp3350.termsetter.Persistence.DomainSpecific.User;

public class AccessStudents implements Serializable
{
    private UserPersistence studentPersistence;
    private List<User> students;
    private User student;
    private int currentStudent;

    public AccessStudents()
    {
        studentPersistence = Services.getRealStudentAccess();
        students = null;
        student = null;
        currentStudent = 0;
    }
    public AccessStudents(Context context){
        studentPersistence = Services.getFakeStudentAccess(context);
        students = null;
        student = null;
        currentStudent = 0;
    }

    public AccessStudents(final User student) throws SQLException {
        this();
        this.insertStudent(student);
    }

    public UserPersistence getStudentPersistence() {
        return studentPersistence;
    }

    public User insertStudent(User currentStudent) throws SQLException {
        return studentPersistence.insertUser(currentStudent);
    }

    public User getStudent(String student_id) throws SQLException
    {
        return studentPersistence.getUser(student_id);
    }

}
