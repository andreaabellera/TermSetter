package comp3350.termsetter;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.termsetter.Tests.AccountValidationTest;
import comp3350.termsetter.Tests.StudentTest;
import comp3350.termsetter.Tests.ClassDataStructureTest;
import comp3350.termsetter.Tests.CourseAccessTest;
import comp3350.termsetter.Tests.CourseCategoryIntegrationTest;
import comp3350.termsetter.Tests.EnrollmentLogicTest;
import comp3350.termsetter.Tests.EnrollAccessTest;
import comp3350.termsetter.Tests.EnrollmentIntegrationTest;
import comp3350.termsetter.Tests.TimetableLogicTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        StudentTest.class,
        AccountValidationTest.class,
        ClassDataStructureTest.class,
        CourseCategoryIntegrationTest.class,
        CourseAccessTest.class,
        EnrollmentLogicTest.class,
        EnrollmentIntegrationTest.class,
        EnrollAccessTest.class,
        TimetableLogicTest.class
})


public class UnitTestSuite {

}
