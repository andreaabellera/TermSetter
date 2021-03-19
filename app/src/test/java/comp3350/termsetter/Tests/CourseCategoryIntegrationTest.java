package comp3350.termsetter.Tests;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import comp3350.termsetter.Logic.OfferedClassLogic;

import static org.junit.Assert.*;

public class CourseCategoryIntegrationTest {

    OfferedClassLogic stub;
    OfferedClassLogic sql;

    @Test
    public void testStubDatabaseCreate() throws IOException {
        System.out.println("\nStarting testStubDatabaseCreate: object exists after creation\n");
        stub = new OfferedClassLogic(false, null);
        assertNotNull(stub);
        System.out.println("End testStubDatabaseCreate: object exists after creation\n");
    }

    @Test
    public void testSQLDatabaseCreate() throws SQLException {
        System.out.println("\nStarting testSQLDatabaseCreate: object exists after creation\n");
        sql = new OfferedClassLogic(true, null);
        assertNotNull(sql);
        System.out.println("End testSQLDatabaseCreate: object exists after creation\n");
    }

}
