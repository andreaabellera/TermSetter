package com.example.termsetter;

import com.example.termsetter.Tests.AccountValidationTest;
import com.example.termsetter.Tests.ClassDatabaseTest;
import com.example.termsetter.Tests.UserDatabaseTest;
import com.example.termsetter.Tests.UserTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserTest.class,
        UserDatabaseTest.class,
        AccountValidationTest.class,
        ClassDatabaseTest.class
})


public class UnitTestSuite{

}
