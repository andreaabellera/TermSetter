package comp3350.termsetter.Tests;


import androidx.appcompat.app.AppCompatActivity;

import org.junit.Test;

import comp3350.termsetter.Persistence.DomainSpecific.StubDatabase;
import comp3350.termsetter.Persistence.DomainSpecific.User;
import static org.junit.Assert.*;

public class UserDatabaseTest extends AppCompatActivity {


    String validName = "name";
    String validPasswd = "123pass";
    String validEmail = "mailme@myumanitoba.ca";
    String validPhone = "204";
    String validID = "hohoho";

    @Test
    public void testDatabaseCreate() {
        System.out.println("\nStarting testDatabaseCreate: object exists after creation\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        assertNotNull(db);
        System.out.println("End testDatabaseCreate: object exists after creation\n");
    }

    @Test
    public void testDatabaseEmpty() {
        System.out.println("\nStarting testDatabaseEmpty: new object is empty after creation\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        assertTrue(db.isEmpty());
        System.out.println("End testDatabaseEmpty: new object is empty after creation\n");
    }

    @Test
    public void testDatabaseEmptyGet() {
        System.out.println("\nStarting testDatabaseEmptyGet: getUser on an empty list gives null\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        assertNull(db.getUser("1234567"));
        System.out.println("End testDatabaseEmptyGet: getUser on an empty list gives null\n");
    }

    @Test
    public void testDatabaseAdd() {
        System.out.println("\nStarting testDatabaseAdd: getUser maintains integrity of inputs in added object\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        db.insertUser(new User(validName, validPasswd, validEmail, validPhone, validID));

        boolean sameValues = true;
        sameValues = validName.equals(db.getUser(validID).getName());
        sameValues = validPasswd.equals(db.getUser(validID).getPassword());
        sameValues = validEmail.equals(db.getUser(validID).getEmailAddress());
        sameValues = validPhone.equals(db.getUser(validID).getPhoneNumber());

        assertTrue(sameValues);
        System.out.println("End testDatabaseAdd: getUser maintains integrity of inputs in added object\n");
    }

    @Test
    public void testDatabaseGetFirst() {
        System.out.println("\nStarting testDatabaseGetFirst: getUser only retrieves the first list element\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        db.insertUser(new User("first", validPasswd, validEmail, validPhone, validID));
        db.insertUser(new User("second", validPasswd, validEmail, validPhone, validID));
        db.insertUser(new User("third", validPasswd, validEmail, validPhone, validID));

        assertEquals(db.getUser(validID).getName(), "first");
        System.out.println("End testDatabaseGetFirst: getUser only retrieves the first list element\n");
    }

    @Test
    public void testDatabaseUpdateUser() {
        System.out.println("\nStarting testDatabaseUpdateUser: new user overwrites the first user\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        db.insertUser(new User("first", validPasswd, validEmail, validPhone, validID));
        db.updatePassword("456pass");
        assertEquals(db.getUser(validID).getPassword(), "456pass");
        db.updateEmail("haha@myumanitoba.ca");
        assertEquals(db.getUser(validID).getEmailAddress(), "haha@myumanitoba.ca");
        System.out.println("End testDatabaseUpdateUser: new user overwrites the first user\n");
    }

}
