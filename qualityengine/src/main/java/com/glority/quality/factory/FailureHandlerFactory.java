package com.glority.quality.factory;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.glority.quality.StringUtil;
import com.glority.quality.failurehandler.TaskFailureHandler;
import com.glority.quality.failurehandler.impl.DefaultFailureHandler;

/**
 * A factory class used to create the FailureHandler instance from configuration file. In the configuration file, the
 * key is class name of Task, and the value is the full class name of the FailureHandler.
 * <p>
 * If no configuration found for the given task class, a default handler instance will be created.
 * </p>
 * 
 * @author Chen.hong
 */
public final class FailureHandlerFactory {

    private static ResourceBundle failureHandlerBundle;

    private static FailureHandlerFactory instance = new FailureHandlerFactory();

    static {
        failureHandlerBundle = ResourceBundle.getBundle(FailureHandlerFactory.class.getName());
    }

    public static FailureHandlerFactory getInstance() {
        return instance;
    }

    /**
     * Private ctor.
     */
    private FailureHandlerFactory() {
        // empty.
    }

    /**
     * Get the TaskFailureHandler implementation with task class name.
     * 
     * @param name
     *            the class name of Task
     * @return TaskFailiureHandler instance
     */
    public TaskFailureHandler getFailureHandler(String name) {
        String handleClassName = getFailureHandlerClassName(name);

        if (StringUtil.isEmpty(handleClassName)) {
            return new DefaultFailureHandler();
        }

        try {
            return (TaskFailureHandler) Class.forName(handleClassName).newInstance();
        } catch (InstantiationException e) {
            return new DefaultFailureHandler();
        } catch (IllegalAccessException e) {
            return new DefaultFailureHandler();
        } catch (ClassNotFoundException e) {
            return new DefaultFailureHandler();
        }
    }

    /**
     * Get the implementation class from bundle. Return empty string if missing.
     * 
     * @param name
     *            the task class full name
     * @return FailureHandler class name
     */
    private String getFailureHandlerClassName(String name) {
        try {
            return failureHandlerBundle.getString(name);
        } catch (MissingResourceException e) {
            return "";
        }
    }
}
