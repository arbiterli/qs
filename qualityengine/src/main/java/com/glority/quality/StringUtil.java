package com.glority.quality;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the util class including some String related operations.
 * 
 * @author XQS
 * 
 */
public final class StringUtil {
    public static final String COMMA = ",";

    /**
     * Disabled public constructor for util class.
     */
    private StringUtil() {
    }

    /**
     * return true if the 2 strings equals. this function will avoid the user to
     * add boring checks for null objects.
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isTwoStringEqual(String s1, String s2) {
        {
            if (s1 == null) {
                return s2 == null;
            } else {
                return s1.equalsIgnoreCase(s2);
            }
        }
    }

    /**
     * Check whether the string is empty. either is null or has no data.
     * 
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static List<String> splitByComma(String srcStr) {
        List<String> result = new ArrayList<String>();

        if (srcStr == null) {
            return result;
        }

        String[] subStrs = srcStr.split(COMMA);

        for (String subStr : subStrs) {
            result.add(subStr);
        }

        if (srcStr.substring(srcStr.length() - 1).equals(COMMA)) {
            result.remove(subStrs.length - 1);
        }

        return result;
    }
}
