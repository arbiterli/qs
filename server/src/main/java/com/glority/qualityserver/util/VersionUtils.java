package com.glority.qualityserver.util;

import com.glority.qualityserver.model.Build;

/**
 * Version utils.
 * 
 * @author liheping
 * 
 */
public final class VersionUtils {
    public static final String VERSION_DOT = ".";
    private static final int LEAST_DOT_COUNT = 2;

    private VersionUtils() {

    }

    /**
     * the deploy version is formed by product version, build id, and auto index.
     * 
     * the following method will deal with these logic.
     */

    /**
     * get the version auto increase index value if the version is legal, return the auto increase index. else return -1
     * 
     * @param version
     * @return
     */
    public static int getDeployVersionIndex(String version) {
        if (isStringALegalDeployVersion(version)) {
            int latestDotIndex = version.lastIndexOf(VERSION_DOT);
            String indexStr = version.substring(latestDotIndex + 1);
            int index = Integer.parseInt(indexStr);

            return index;
        }

        return -1;
    }

    /**
     * get the next version . if the version is legal, return the next version. else return null;
     * 
     * @param version
     * @return
     */
    public static String getNextDeployVersion(String version) {
        if (isStringALegalDeployVersion(version)) {
            int latestDotIndex = version.lastIndexOf(VERSION_DOT);

            String indexStr = version.substring(latestDotIndex + 1);
            int index = Integer.parseInt(indexStr);

            String nextVersion = version.substring(0, latestDotIndex + 1) + Integer.toString(index + 1);
            return nextVersion;
        }

        return null;
    }

    /**
     * if a str is a deploy version string it will have at least 2 dot. this method is check the dot number.
     * 
     * @param str
     * @return
     */
    public static boolean isStringALegalDeployVersion(String str) {
        if (str == null) {
            return false;
        }

        int startIndex = 0;
        for (int i = 0; i < LEAST_DOT_COUNT; i++) {
            int indexOfDot = str.indexOf(VERSION_DOT, startIndex);

            if (indexOfDot < 0) {
                return false;
            }

            startIndex = indexOfDot + 1;
        }

        return true;
    }

    /**
     * get the base deploy version for build, if build is null return null.
     * 
     * @param build
     * @return
     */
    public static String getBaseDeployVersion(Build build) {
        if (build != null) {
            String prodVersion = build.getVersion().getVersion();
            return prodVersion + VERSION_DOT + build.getJenkinsBuildId() + VERSION_DOT + "0";
        }
        return null;
    }

    /**
     * get the base deploy version for version. if version is illegal, return null.
     * 
     * @param version
     * @return
     */
    public static String getBaseDeployVersion(String version) {
        if (isStringALegalDeployVersion(version)) {
            int latestDotIndex = version.lastIndexOf(".");

            return version.substring(0, latestDotIndex + 1) + "0";
        }

        return null;
    }

}
