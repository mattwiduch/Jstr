package com.udacity.gradle.jstr;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends AndroidTestCase {

    private static final String LOG_TAG = "JSTR-AndroidTest";
    private String mResult = null;
    private CountDownLatch mSignal = null;

    /**
     * Tests if app receives valid response from GCE App Engine.
     *
     * @throws InterruptedException
     */
    @Test
    public void testEndpointsAsyncTask() throws InterruptedException {
        mSignal = new CountDownLatch(1);
        new EndpointsAsyncTask(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String result) {
                mResult = result;
                mSignal.countDown();
            }
        }).execute();
        mSignal.await(30, TimeUnit.SECONDS);

        assertFalse("Server not found", mResult.contains("404"));
        assertNotNull("Result is null", mResult);
        assertTrue("Result is empty", mResult.length() > 0);
    }
}