package com.glority.quality.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import com.glority.quality.BaseTask;
import com.glority.quality.failurehandler.impl.DefaultFailureHandler;

public class FailureHandlerFactoryTest {

    @Test
    public void testGetFailureHandler() {
        String name = MockTask.class.getName();
        Object obj = FailureHandlerFactory.getInstance().getFailureHandler(name);
        assertTrue(obj instanceof DefaultFailureHandler);
    }

    /**
     * Mock Task.
     *
     */
    private class MockTask extends BaseTask {
        /**
         * Dummpy
         */
        public void process() {
            // empty.
        }
    }

}
