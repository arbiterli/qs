package com.glority.qualityserver.util;

/**
 * Dao utils class.
 * 
 * @author liheping
 * 
 */
public final class DaoUtils {
    /**
     * default constructor.
     */
    private DaoUtils() {

    }

    /**
     * parse id string to long, if the string is null or not a number, return -1.
     * 
     * @param idString
     * @return
     */
    public static long parseStringToId(String idString) {
        if (idString == null) {
            return -1;
        }

        long id;
        try {
            id =  Long.valueOf(idString).longValue();
        } catch (Exception e) {
            return -1;
        }

        return id;
    }
}
