package comp3350.termsetter.Persistence;

import java.sql.SQLException;

import comp3350.termsetter.Persistence.DomainSpecific.User;

public interface UserPersistence {
    void insertUser(User user) throws SQLException;
    
    void setCurrentUser(String sID);

    int findUserIndex(String sID);
           
    User getUser(String sID) throws SQLException;

    User getCurrentUser();
}
