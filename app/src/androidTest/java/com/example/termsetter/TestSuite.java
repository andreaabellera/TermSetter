package com.example.termsetter;

import com.example.termsetter.InstrumentedTests.LoginUITest;
import com.example.termsetter.UnitTests.AccountValidationTest;
import com.example.termsetter.UnitTests.ClassDatabaseTest;
import com.example.termsetter.UnitTests.UserDatabaseTest;
import com.example.termsetter.UnitTests.UserTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginUITest.class,
        UserTest.class,
        UserDatabaseTest.class,
        AccountValidationTest.class,
        ClassDatabaseTest.class
})


public class TestSuite {

}