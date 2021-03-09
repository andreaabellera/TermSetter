package com.example.termsetter.InstrumentedTests;
import com.example.termsetter.R;
import com.example.termsetter.Presentation.LoginPage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginUITest {
    private String validUser;
    private String validPasswd;

    @Rule
    public ActivityScenarioRule<LoginPage> activityRule
            = new ActivityScenarioRule<>(LoginPage.class);

    @Before
    public void initValidString() {
        validUser = "annabelle";
        validPasswd = "anna123";
    }

    @Test
    public void changeText() {
        onView(withId(R.id.idText))
                .perform(typeText(validUser), closeSoftKeyboard());
        onView(withId(R.id.passwordText))
                .perform(typeText(validPasswd), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());

        onView(withId(R.id.idText))
                .check(matches(withText(validUser)));
        onView(withId(R.id.passwordText))
                .check(matches(withText(validPasswd)));
    }
}
