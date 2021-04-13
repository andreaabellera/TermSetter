package comp3350.termsetter.Persistence.DomainSpecific;

import android.content.Context;
import android.content.SharedPreferences;


import comp3350.termsetter.Persistence.UserPersistence;

import static android.content.Context.MODE_PRIVATE;

public class StubDatabase implements UserPersistence {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static int count = 0;
    private static String currentID = null;

    public StubDatabase(Context context, String dbName){
        preferences = context.getApplicationContext().getSharedPreferences(dbName, MODE_PRIVATE);
        editor = preferences.edit();
    }

    public User insertUser(User user){
        String name = user.getName();
        String password = user.getPassword();
        String email = user.getEmailAddress();
        String phoneNumber = user.getPhoneNumber();
        String studentID = user.getStudentID();

        String nameKey = "name" + count;
        String passwordKey = "password" + count;
        String emailKey = "email" + count;
        String phoneKey = "phone" + count;
        String idKey = "id" + count;

        editor.putString(nameKey, name);
        editor.putString(passwordKey, password);
        editor.putString(emailKey, email);
        editor.putString(phoneKey, phoneNumber);
        editor.putString(idKey, studentID);
        editor.apply();

        count += 1;
        return user;
    }

    public void setCurrentUser(String sID) {
        this.currentID = sID;
    }

    public int findUserIndex(String sID) {
        if (this.count <= 0){
            return -1;
        }

        int lookupIndex = 0;
        String id;

        for (int i = 0; i < this.count; i++) {
            id = "id" + i;
            if (preferences.getString(id,"").equals(sID)) {
                lookupIndex = i;
                break;
            }
        }
        return lookupIndex;
    }

    public User getUser(String sID) {
        int lookupIndex = findUserIndex(sID);

        if (lookupIndex != -1) {
            String nameKey = "name" + lookupIndex;
            String passwordKey = "password" + lookupIndex;
            String emailKey = "email" + lookupIndex;
            String phoneKey = "phone" + lookupIndex;
            String idKey = "id" + lookupIndex;

            String name = preferences.getString(nameKey,"");
            String password = preferences.getString(passwordKey,"");
            String email = preferences.getString(emailKey,"");
            String phoneNumber = preferences.getString(phoneKey,"");
            String studentID = preferences.getString(idKey,"");

            return new User(name, password, email, phoneNumber, studentID);
        }
        else {
            return null;
        }
    }

    public User getCurrentUser() {
        return getUser(currentID);
    }

    public boolean updatePassword(String newPassword) {
        if (currentID != null) {
            int lookupIndex = findUserIndex(currentID);
            String passwordKey = "password" + lookupIndex;
            editor.putString(passwordKey, newPassword);
            editor.apply();
            return true;
        }

        return false;
    }

    public boolean updateEmail(String newEmail) {
        if (currentID != null) {
            int lookupIndex = findUserIndex(currentID);
            String emailKey = "email" + lookupIndex;
            editor.putString(emailKey, newEmail);
            editor.apply();
            return true;
        }

        return false;
    }

    public boolean isEmpty() {
        return (count == 0);
    }
}
