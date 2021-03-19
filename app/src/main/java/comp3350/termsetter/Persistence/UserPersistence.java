package comp3350.termsetter.Persistence;

import java.sql.SQLException;

import comp3350.termsetter.Persistence.DomainSpecific.User;

public interface UserPersistence {

    User insertUser(User user) throws SQLException;
           
    User getUser(String sID) throws SQLException;

    User getCurrentUser() throws SQLException;

    boolean isEmpty() throws SQLException;

    boolean updatePassword(String password) throws SQLException;

    boolean updateEmail(String email) throws SQLException;

    void setCurrentUser(String inputID);
}
