package comp3350.termsetter.Persistence;

import java.sql.SQLException;
import comp3350.termsetter.Persistence.DomainSpecific.Student;

public interface StudentPersistence {

    Student insertStudent(Student student) throws SQLException;
           
    Student getStudent(String sID) throws SQLException;

    Student getCurrentStudentID() throws SQLException;

    boolean isEmpty() throws SQLException;

    boolean updatePassword(String password) throws SQLException;

    boolean updateEmail(String email) throws SQLException;

    void setCurrentStudentID(String inputID);
}
