package com.example.sagar.vehicledocumentverification; // 1. Corrected package name

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry; // 2. AndroidX import
import androidx.test.ext.junit.runners.AndroidJUnit4; // 2. AndroidX import

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class) // 3. Uses AndroidX runner (already correct if imported correctly)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() { // Removed "throws Exception" as it's often not needed for this simple test
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext(); // Correct way to get target context

        assertEquals("com.example.sager.vehicledocumentverification", appContext.getPackageName()); // 4. Corrected expected package name
    }
}