package comp3350.termsetter;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.termsetter.Tests.AccountValidationTest;
import comp3350.termsetter.Tests.ClassDatabaseTest;
import comp3350.termsetter.Tests.StudentDatabaseTest;
import comp3350.termsetter.Tests.StudentTest;
import comp3350.termsetter.Tests.CourseCategoryIntegrationTest;
import comp3350.termsetter.Tests.CourseAccessTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StudentTest.class,
        StudentDatabaseTest.class,
        AccountValidationTest.class,
        ClassDatabaseTest.class,
        CourseCategoryIntegrationTest.class,
        CourseAccessTest.class
})


public class UnitTestSuite {

}
