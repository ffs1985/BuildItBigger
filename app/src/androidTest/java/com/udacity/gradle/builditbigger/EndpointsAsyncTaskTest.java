package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.icu.util.TimeUnit;
import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

public class EndpointsAsyncTaskTest extends ActivityInstrumentationTestCase2<MainActivity>{
    String returnedJoke;
    EndpointsAsyncTask myTask;
    CountDownLatch signal = null;
    MainActivity mainActivity;

    public EndpointsAsyncTaskTest() {
        super(MainActivity.class);
    }
    public void setUp() throws Exception {
        super.setUp();
        returnedJoke = null;
        myTask = new EndpointsAsyncTask();
        signal = new CountDownLatch(1);
        mainActivity = getActivity();
        assertNotNull(mainActivity);

    }

    @Test
    public void testReturnJokeSuccess() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                EndpointsAsyncTask.EndpointsAsyncTaskListener listener = new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
                    @Override
                    public void onReturnedValue(String value) {
                        returnedJoke = value;
                        if(signal != null) {
                            signal.countDown();
                        }
                    }
                };
                myTask.setListener(listener);
                myTask.execute(mainActivity);
            }
        });
        try {
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(returnedJoke);
        assertFalse(returnedJoke.startsWith("Failed to connect to"));
    }
}