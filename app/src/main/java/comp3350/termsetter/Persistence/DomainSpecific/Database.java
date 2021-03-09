package comp3350.termsetter.Persistence.DomainSpecific;


import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {

    private final ArrayList<User> users;

    public Database() {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(User user) {
        users.remove(0);
        users.add(user);
    }

    public User getUser() {
        User user = null;
        if (users.size() > 0) {
            user = users.get(0);
        }
        return user;
    }

    public boolean isEmpty() {
        return users.isEmpty();
    }

}
