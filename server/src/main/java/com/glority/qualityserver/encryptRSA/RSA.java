package com.glority.qualityserver.encryptRSA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.log4j.Logger;

import com.glority.qualityserver.ServerSettings;

/**
 * RSA Class.
 * 
 * @author chenzuying
 * 
 */

public final class RSA {
    private static final Logger LOGGER = Logger.getLogger(RSA.class);
    private static final String ALGORITHM = "RSA";
    private static final String CHARSET = "UTF-8";
    private static final String PUBLICKEYFILENAME = "publicKeyFileName";
    private static final String PRIVATEKEYFILENAME = "privateKeyFileName";
    private static final int LEFTSHIFT = 4;
    private static final int MASK = 0xFF;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    private static final RSA INSTANCE = new RSA();
    /**
     * the private constructor.
     */
    private RSA() {
        generateSecretKey();
    }
    /**
     * get RSA Instance.
     * @return INSTANCE
     */
    public static RSA getInstance() {
        return INSTANCE;
    }
    /**
     * encrypt string.
     * @param srcString
     *            the source string
     * @return the encrypted string
     */
    public String encrypt(String srcString) {
        try {
            byte[] srcBytes = srcString.getBytes(CHARSET);
            byte[] resultBytes = encrypt(srcBytes);
            return bytesToHexString(resultBytes);
        } catch (UnsupportedEncodingException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return null;
    }
    /**
     * decrypt string.
     * @param srcString
     *             the encrypted string
     * @return the decrypted string
     */
    public String decrypt(String srcString) {
        try {
            byte[] srcBytes = hexStringToBytes(srcString);
            byte[] resultBytes = decrypt(srcBytes);
            return new String(resultBytes, CHARSET);
        } catch (UnsupportedEncodingException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return null;
    }
    /**
     * Convert byte[] to string.
     * @param src byte[] data
     * @return hex string
     */
    private String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & MASK;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    /**
     * Convert hex string to byte[].
     * @param hexString the hex string
     * @return byte[]
     */
    private byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << LEFTSHIFT | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    /**
     * Convert char to byte.
     * @param c char
     * @return byte
     */
     private byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
    /**
     * generateSecretKey.
     */
    private void generateSecretKey() {
        try {
            ServerSettings serverSettings = ServerSettings.getInstance();
            String publicKeyFileName = serverSettings.getSetting(PUBLICKEYFILENAME);
            String privateKeyFileName = serverSettings.getSetting(PRIVATEKEYFILENAME);
            publicKey = readPublicKeyFromFile(publicKeyFileName);
            privateKey = readPrivateKeyFromFile(privateKeyFileName);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
    /**
     * encrypt bytes.
     * @param srcBytes
     *            the array of source bytes
     * @return byte[]
     */
    private byte[] encrypt(byte[] srcBytes) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] resultBytes = cipher.doFinal(srcBytes);
            return resultBytes;
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (NoSuchPaddingException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (InvalidKeyException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (BadPaddingException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (IllegalBlockSizeException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return null;
    }
    /**
     * decrypt bytes.
     * @param srcBytes
     *            the array of source bytes
     * @return byte[]
     */
    private byte[] decrypt(byte[] srcBytes) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] resultBytes = cipher.doFinal(srcBytes);
            return resultBytes;
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (NoSuchPaddingException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (InvalidKeyException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (BadPaddingException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (IllegalBlockSizeException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return null;
    }
    /**
     * read Public Key From File.
     * @param keyFileName
     *            the key file name
     * @return PublicKey
     * @throws IOException
     *            throws IOException
     */
    private PublicKey readPublicKeyFromFile(String keyFileName) throws IOException {
        ObjectInputStream oin = null;
        try {
            oin = new ObjectInputStream(new FileInputStream(keyFileName));
            BigInteger m = (BigInteger) oin.readObject();
            BigInteger e = (BigInteger) oin.readObject();
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
            KeyFactory fact = KeyFactory.getInstance(ALGORITHM);
            PublicKey pubKey = fact.generatePublic(keySpec);
            return pubKey;
        } catch (ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (InvalidKeySpecException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (FileNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } finally {
            oin.close();
        }
        return null;
    }
    /**
     * read Private Key From File.
     * @param keyFileName
     *            the key file name
     * @return PrivateKey
     * @throws IOException
     *            throws IOException
     */
    private PrivateKey readPrivateKeyFromFile(String keyFileName) throws IOException {
        ObjectInputStream oin = null;
        try {
            oin = new ObjectInputStream(new FileInputStream(keyFileName));
            BigInteger m = (BigInteger) oin.readObject();
            BigInteger e = (BigInteger) oin.readObject();
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
            KeyFactory fact = KeyFactory.getInstance(ALGORITHM);
            PrivateKey priKey = fact.generatePrivate(keySpec);
            return priKey;
        } catch (ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (InvalidKeySpecException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } catch (FileNotFoundException ex) {
            LOGGER.error(ex.getMessage(), ex);
        } finally {
            oin.close();
        }
        return null;
    }

}