package comp3350.termsetter.Persistence.DomainSpecific;

import java.util.List;

public interface UserPersistence {
    User insertUser(User user);

    User getUser(String sID);

    User updateUser(final User currentUser);

    boolean updatePassword(String newPassword);

    boolean updateEmail(String newEmail);
}
