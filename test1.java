
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import io.selendroid.testapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class test1 {

    @Rule
    public ActivityTestRule<HomeScreenActivity> mActivityTestRule = new ActivityTestRule<>(HomeScreenActivity.class);

    @Test
    public void test1() {
        ViewInteraction button = onView(
allOf(withId(R.id.showToastButton), withText("Displays a Toast"), withContentDescription("showToastButtonCD"),
childAtPosition(
allOf(withId(R.id.visibleTestArea), withContentDescription("visibleTestAreaCD"),
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
6)),
0),
isDisplayed()));
        button.perform(click());
        
        ViewInteraction button2 = onView(
allOf(withId(R.id.showPopupWindowButton), withText("Display Popup Window"), withContentDescription("showPopupWindowButtonCD"),
childAtPosition(
allOf(withId(R.id.visibleTestArea), withContentDescription("visibleTestAreaCD"),
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
6)),
1),
isDisplayed()));
        button2.perform(click());
        
        ViewInteraction button3 = onView(
allOf(withId(R.id.popup_dismiss_button), withText("Dismiss"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
0),
2),
isDisplayed()));
        button3.perform(click());
        
        ViewInteraction button4 = onView(
allOf(withId(R.id.waitingButtonTest), withText("Show Progress Bar for a while"), withContentDescription("waitingButtonTestCD"),
childAtPosition(
allOf(withId(R.id.lastElementRow), withContentDescription("imageViewCD"),
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
4)),
0),
isDisplayed()));
        button4.perform(click());
        
        ViewInteraction editText = onView(
allOf(withId(R.id.inputUsername),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
2)));
        editText.perform(scrollTo(), click());
        
        ViewInteraction editText2 = onView(
allOf(withId(R.id.inputEmail), withContentDescription("email of the customer"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
4)));
        editText2.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());
        
        ViewInteraction editText3 = onView(
allOf(withId(R.id.inputUsername),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
2)));
        editText3.perform(scrollTo(), replaceText("amir"), closeSoftKeyboard());
        
        ViewInteraction spinner = onView(
allOf(withId(R.id.input_preferedProgrammingLanguage),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
10)));
        spinner.perform(scrollTo(), click());
        
        ViewInteraction viewInteraction = onView(
allOf(, isDisplayed()));
        viewInteraction.perform(click());
        
        ViewInteraction checkBox = onView(
allOf(withId(R.id.input_adds), withText("I accept adds"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
12)));
        checkBox.perform(scrollTo(), click());
        
        ViewInteraction button5 = onView(
allOf(withId(R.id.btnRegisterUser), withText("Register User (verify)"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
13)));
        button5.perform(scrollTo(), click());
        
        ViewInteraction button6 = onView(
allOf(withId(R.id.buttonRegisterUser), withText("Register User"),
childAtPosition(
allOf(withId(R.id.tableHeader),
childAtPosition(
withId(R.id.tableLayout1),
7)),
0),
isDisplayed()));
        button6.perform(click());
        
        ViewInteraction editText4 = onView(
allOf(withId(R.id.exceptionTestField),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
7),
isDisplayed()));
        editText4.perform(replaceText("h"), closeSoftKeyboard());
        
        }

        private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
