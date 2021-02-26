package com.example.myapplication;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.example.myapplication.UserTest;
import com.example.myapplication.UserDatabaseTest;
import com.example.myapplication.AccountValidationTest;
import com.example.myapplication.ClassDatabaseTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserTest.class,
        UserDatabaseTest.class,
        AccountValidationTest.class,
        ClassDatabaseTest.class
})


public class UnitTestSuite{

}
