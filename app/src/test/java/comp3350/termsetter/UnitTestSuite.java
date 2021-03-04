package comp3350.termsetter;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.termsetter.Tests.AccountValidationTest;
import comp3350.termsetter.Tests.ClassDatabaseTest;
import comp3350.termsetter.Tests.UserDatabaseTest;
import comp3350.termsetter.Tests.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserTest.class,
        UserDatabaseTest.class,
        AccountValidationTest.class,
        ClassDatabaseTest.class
})


public class UnitTestSuite {

}
