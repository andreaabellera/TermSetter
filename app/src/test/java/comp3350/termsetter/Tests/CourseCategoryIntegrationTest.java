package comp3350.termsetter.Tests;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import comp3350.termsetter.Logic.OfferedClassLogic;
import comp3350.termsetter.Presentation.OfferedClassesCategories;

import static org.junit.Assert.*;

public class CourseCategoryIntegrationTest {

    OfferedClassLogic sql;
    OfferedClassesCategories act;

    @Before
    public void setContext(){
        act = new OfferedClassesCategories();
    }

    @Test
    public void testSQLDatabaseCreate() throws SQLException {
        System.out.println("\nStarting testSQLDatabaseCreate: object exists after creation\n");
        sql = new OfferedClassLogic(true, act);
        assertNotNull(sql);
        System.out.println("End testSQLDatabaseCreate: object exists after creation\n");
    }

}
