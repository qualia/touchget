package ug.drewb.touchget;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class ug.drewb.touchget.TouchGetTest \
 * ug.drewb.touchget.tests/android.test.InstrumentationTestRunner
 */
public class TouchGetTest extends ActivityInstrumentationTestCase2<TouchGet> {

    public TouchGetTest() {
        super("ug.drewb.touchget", TouchGet.class);
    }

}
