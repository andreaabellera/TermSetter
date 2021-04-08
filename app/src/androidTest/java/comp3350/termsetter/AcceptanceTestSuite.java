package comp3350.termsetter;

import comp3350.termsetter.AcceptanceTests.CreateAccountTest;
import comp3350.termsetter.AcceptanceTests.LoginTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        CreateAccountTest.class
})


public class AcceptanceTestSuite {

}