package comp3350.termsetter.AcceptanceTests;


import androidx.appcompat.app.AppCompatActivity;

import org.junit.Test;

import comp3350.termsetter.Persistence.DomainSpecific.StubDatabase;
import comp3350.termsetter.Persistence.DomainSpecific.Student;
import comp3350.termsetter.Persistence.StudentPersistence;

import static org.junit.Assert.*;

public class StudentDatabaseTest extends AppCompatActivity {


    String validName = "name";
    String validPasswd = "pass123";
    String validEmail = "mailme@myumanitoba.ca";
    String validPhone = "2045583887";
    String validID = "hohoho";

    @Test
    public void testDatabaseCreate() {
        System.out.println("\nStarting testDatabaseCreate: object exists after creation\n");
        StudentPersistence db = new StubDatabase(this,"test.db");
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
        assertNull(db.getStudent("1234567"));
        System.out.println("End testDatabaseEmptyGet: getUser on an empty list gives null\n");
    }

    @Test
    public void testDatabaseAdd() {
        System.out.println("\nStarting testDatabaseAdd: getUser maintains integrity of inputs in added object\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        db.insertStudent(new Student(validName, validPasswd, validEmail, validPhone, validID));

        boolean sameValues = true;
        sameValues = validName.equals(db.getStudent(validID).getName());
        sameValues = validPasswd.equals(db.getStudent(validID).getPassword());
        sameValues = validEmail.equals(db.getStudent(validID).getEmailAddress());
        sameValues = validPhone.equals(db.getStudent(validID).getPhoneNumber());

        assertTrue(sameValues);
        System.out.println("End testDatabaseAdd: getUser maintains integrity of inputs in added object\n");
    }

    @Test
    public void testDatabaseGetFirst() {
        System.out.println("\nStarting testDatabaseGetFirst: getUser only retrieves the first list element\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        db.insertStudent(new Student("first", validPasswd, validEmail, validPhone, validID));
        db.insertStudent(new Student("second", validPasswd, validEmail, validPhone, validID));
        db.insertStudent(new Student("third", validPasswd, validEmail, validPhone, validID));

        assertEquals(db.getStudent(validID).getName(), "first");
        System.out.println("End testDatabaseGetFirst: getUser only retrieves the first list element\n");
    }

    @Test
    public void testDatabaseUpdateUser() {
        System.out.println("\nStarting testDatabaseUpdateUser: new user overwrites the first user\n");
        StubDatabase db = new StubDatabase(this,"test.db");
        db.insertStudent(new Student("first", validPasswd, validEmail, validPhone, validID));
        db.updatePassword("pass456");
        assertEquals(db.getStudent(validID).getPassword(), "pass456");
        db.updateEmail("haha@myumanitoba.ca");
        assertEquals(db.getStudent(validID).getEmailAddress(), "haha@myumanitoba.ca");
        System.out.println("End testDatabaseUpdateUser: new user overwrites the first user\n");
    }

}
