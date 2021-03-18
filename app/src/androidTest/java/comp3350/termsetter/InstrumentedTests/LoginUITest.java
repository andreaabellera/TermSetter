package comp3350.termsetter.InstrumentedTests;
import comp3350.termsetter.R;
import comp3350.termsetter.Presentation.LoginPage;
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
        onView(withId(R.id.loginEdtxt1))
                .perform(typeText(validUser), closeSoftKeyboard());
        onView(withId(R.id.loginEdtxt2))
                .perform(typeText(validPasswd), closeSoftKeyboard());
        onView(withId(R.id.loginBtn)).perform(click());

        onView(withId(R.id.loginEdtxt1))
                .check(matches(withText(validUser)));
        onView(withId(R.id.loginEdtxt2))
                .check(matches(withText(validPasswd)));
    }
}
