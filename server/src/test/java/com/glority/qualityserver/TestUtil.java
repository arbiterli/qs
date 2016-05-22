package com.glority.qualityserver;

import java.lang.reflect.Field;

import com.glority.qualityserver.model.User;

/**
 * A Util class for help testing.
 * 
 * @author Chenhong
 * 
 */
public final class TestUtil {

    /**
     * Private ctor.
     */
    private TestUtil() {
        // empty.
    }

    /**
     * Inject the injectObject to baseObject with given field name.
     * 
     * <p>
     * Be sure the baseObject, inJectObject and field name should not be null.
     * </p>
     * 
     * @throws Exception
     *             to junit
     */
    public static void injectObject(Object baseObject, Object injectObject, String fieldName) throws Exception {
        Field field = baseObject.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(baseObject, injectObject);
    }

    /**
     * Util method to get the private field with object and field name.
     * 
     * @param baseObject
     *            the object where the field to retrieve
     * @param fieldName
     *            the field name
     * @return field value.
     * @throws Exception
     *             to junit
     */
    public static Object getFieldValue(Object baseObject, String fieldName) throws Exception {
        Field field = baseObject.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(baseObject);
    }

    /**
     * Create User with username, and password. The login is the same with username.
     */
    public static User createUser(String username, String password) {
        User user = new User();
        user.setName(username);
        user.setLogin(username);
        user.setPassword(password);
        return user;
    }
}
