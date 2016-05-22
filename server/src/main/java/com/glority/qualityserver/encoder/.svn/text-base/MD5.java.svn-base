package com.glority.qualityserver.encoder;

import java.security.MessageDigest;

/**
 * MD5 Class.
 * 
 * @author liheping
 * 
 */
public final class MD5 {
    private MD5() {
    }

    public static String getMD5ofStr(String origString) {
        String origMD5 = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] result = md5.digest(origString.getBytes());
            origMD5 = byteArray2HexStr(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return origMD5;
    }

    private static String byteArray2HexStr(byte[] bs) {
        StringBuffer sb = new StringBuffer();
        for (byte b : bs) {
            sb.append(byte2HexStr(b));
        }
        return sb.toString();
    }

    private static String byte2HexStr(byte b) {
        final int andValue = 0x7F;
        final int addValue = 128;
        final int baseValue = 16;
        String hexStr = null;
        int n = b;
        if (n < 0) {
            n = b & andValue + addValue;
        }
        hexStr = Integer.toHexString(n / baseValue) + Integer.toHexString(n % baseValue);
        return hexStr.toUpperCase();
    }

    public static String getMD5ofStr(String origString, int times) {
        String md5 = getMD5ofStr(origString);
        for (int i = 0; i < times - 1; i++) {
            md5 = getMD5ofStr(md5);
        }
        return getMD5ofStr(md5);
    }

    public static boolean verifyPassword(String inputStr, String md5Code) {
        return getMD5ofStr(inputStr).equals(md5Code);
    }

    public static boolean verifyPassword(String inputStr, String md5Code, int times) {
        return getMD5ofStr(inputStr, times).equals(md5Code);
    }

}
