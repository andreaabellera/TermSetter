package comp3350.termsetter.Persistence.DomainSpecific;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import comp3350.termsetter.Persistence.CourseOffering;
import comp3350.termsetter.Persistence.CreateAccount;

import static android.content.Context.MODE_PRIVATE;

public class StubDatabase {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    int count = 0;
    int lookupIndex = 0;

    public StubDatabase(Context context, String dbName){
        preferences = context.getApplicationContext().getSharedPreferences(dbName, MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void insert(User user){
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
    }

    public void delete(Activity activity, User user) {

    }

    public boolean checkUser(String studentID) {
        boolean found = false;
        String id;
        for (int i = 0; i < this.count; i++) {
            id = "id" + i;
            if (preferences.getString(id,"").equals(studentID)) {
                lookupIndex = i;
                found = true;
                break;
            }
        }
        return found;
    }

    public User getUser(String id) {
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

}
