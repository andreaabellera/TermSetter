package comp3350.termsetter.Tests;


import org.junit.Test;

import comp3350.termsetter.Persistence.DomainSpecific.Database;
import comp3350.termsetter.Persistence.DomainSpecific.User;
import static org.junit.Assert.*;

public class UserDatabaseTest {

    String validName = "name";
    String validPasswd = "123pass";
    String validEmail = "mailme@myumanitoba.ca";
    String validPhone = "204";
    String validID = "hohoho";

    @Test
    public void testDatabaseCreate() {
        System.out.println("\nStarting testDatabaseCreate: object exists after creation\n");
        Database db = new Database();
        assertNotNull(db);
        System.out.println("End testDatabaseCreate: object exists after creation\n");
    }

    @Test
    public void testDatabaseEmpty() {
        System.out.println("\nStarting testDatabaseEmpty: new object is empty after creation\n");
        Database db = new Database();
        assertTrue(db.isEmpty());
        System.out.println("End testDatabaseEmpty: new object is empty after creation\n");
    }

    @Test
    public void testDatabaseEmptyGet() {
        System.out.println("\nStarting testDatabaseEmptyGet: getUser on an empty list gives null\n");
        Database db = new Database();
        assertNull(db.getUser());
        System.out.println("End testDatabaseEmptyGet: getUser on an empty list gives null\n");
    }

    @Test
    public void testDatabaseAdd() {
        System.out.println("\nStarting testDatabaseAdd: getUser maintains integrity of inputs in added object\n");
        Database db = new Database();
        db.addUser(new User(validName, validPasswd, validEmail, validPhone, validID));

        boolean sameValues = true;
        sameValues = validName.equals(db.getUser().getName());
        sameValues = validPasswd.equals(db.getUser().getPassword());
        sameValues = validEmail.equals(db.getUser().getEmailAddress());
        sameValues = validPhone.equals(db.getUser().getPhoneNumber());

        assertTrue(sameValues);
        System.out.println("End testDatabaseAdd: getUser maintains integrity of inputs in added object\n");
    }

    @Test
    public void testDatabaseGetFirst() {
        System.out.println("\nStarting testDatabaseGetFirst: getUser only retrieves the first list element\n");
        Database db = new Database();
        db.addUser(new User("first", validPasswd, validEmail, validPhone, validID));
        db.addUser(new User("second", validPasswd, validEmail, validPhone, validID));
        db.addUser(new User("third", validPasswd, validEmail, validPhone, validID));

        assertEquals(db.getUser().getName(), "first");
        System.out.println("End testDatabaseGetFirst: getUser only retrieves the first list element\n");
    }

    @Test
    public void testDatabaseUpdateUser() {
        System.out.println("\nStarting testDatabaseUpdateUser: new user overwrites the first user\n");
        Database db = new Database();
        db.addUser(new User("first", validPasswd, validEmail, validPhone, validID));
        db.updateUser(new User("secondThatBecameFirst", validPasswd, validEmail, validPhone, validID));
        assertEquals(db.getUser().getName(), "secondThatBecameFirst");
        System.out.println("End testDatabaseUpdateUser: new user overwrites the first user\n");
    }

}
