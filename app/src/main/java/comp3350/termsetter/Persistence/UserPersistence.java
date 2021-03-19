package comp3350.termsetter.Persistence;

import java.sql.SQLException;

import comp3350.termsetter.Persistence.DomainSpecific.User;

public interface UserPersistence {
    void insertUser(User user) throws SQLException;
           
    User getUser(String sID) throws SQLException;

    User getCurrentUser();

    boolean isEmpty();

    boolean updatePassword(String password);

    boolean updateEmail(String email);
}
