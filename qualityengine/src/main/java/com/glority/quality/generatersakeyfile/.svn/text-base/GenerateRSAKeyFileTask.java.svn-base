package com.glority.quality.generatersakeyfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import org.apache.tools.ant.BuildException;

import com.glority.quality.BaseTask;

/**
 * Generate Secret Key File Task.
 * @author chen.zuying
 *
 */
public final class GenerateRSAKeyFileTask extends BaseTask {

    private static final String ALGORITHM = "RSA";
    private static final String PUBLICKEYFILENAME = "public.key";
    private static final String PRIVATEKEYFILENAME = "private.key";
    private static final int KEYPAIRLENGTH = 2048;
    private String keyPath;

    private void generateRSAKeyFile() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
            kpg.initialize(KEYPAIRLENGTH);
            KeyPair kp = kpg.genKeyPair();
            PublicKey publicKey = kp.getPublic();
            PrivateKey privateKey = kp.getPrivate();
            KeyFactory fact = KeyFactory.getInstance(ALGORITHM);
            RSAPublicKeySpec pub = fact.getKeySpec(publicKey,
              RSAPublicKeySpec.class);
            RSAPrivateKeySpec priv = fact.getKeySpec(privateKey,
              RSAPrivateKeySpec.class);
            String publicKeyFilePath = keyPath + PUBLICKEYFILENAME;
            String privateKeyFilePath = keyPath + PRIVATEKEYFILENAME;
            saveToFile(publicKeyFilePath, pub.getModulus(),
              pub.getPublicExponent());
            saveToFile(privateKeyFilePath, priv.getModulus(),
              priv.getPrivateExponent());
        } catch (NoSuchAlgorithmException ex) {
            throw new BuildException(ex.getMessage(), ex);
        } catch (InvalidParameterException ex) {
            throw new BuildException(ex.getMessage(), ex);
        } catch (InvalidKeySpecException ex) {
            throw new BuildException(ex.getMessage(), ex);
        } catch (IOException ex) {
            throw new BuildException(ex.getMessage(), ex);
        }
    }

    private void saveToFile(String fileName, BigInteger mod, BigInteger exp) throws IOException {
        ObjectOutputStream oout = new ObjectOutputStream((new FileOutputStream(fileName)));
        oout.writeObject(mod);
        oout.writeObject(exp);
        oout.close();
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    @Override
    public void process() {
        generateRSAKeyFile();
    }

}
