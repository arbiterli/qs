package com.glority.quality.sca;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * some file operations,mainly zip and copy.
 * 
 * @author LYX
 * 
 */
public class FileUtil {
    private static final FileUtil INSTANCE = new FileUtil();
    public static final int DEFAULT_BUFFER_LENGTH = 1024;
    public static final int DEFAULT_FILE_SIZE = 10 * 1024 * 1024;

    public static FileUtil getInstance() {
        return INSTANCE;
    }

    public void zipAndDeleteOriReport(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.isFile()) {
            return;
        }
        if (file.length() < DEFAULT_FILE_SIZE) {
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buf = new byte[DEFAULT_BUFFER_LENGTH];
        FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + ".zip");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ZipOutputStream zos = new ZipOutputStream(bos);
        ZipEntry ze = new ZipEntry(file.getName());
        zos.putNextEntry(ze);
        int len;
        while ((len = bis.read(buf)) != -1) {
            zos.write(buf, 0, len);
            zos.flush();
        }
        bis.close();
        zos.close();
        file.delete();
    }

    public void zipFolder(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.isDirectory()) {
            return;
        }
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(filePath + ".zip"));
        zipFile(zos, file, "");
        zos.close();
    }

    private void zipFile(ZipOutputStream zos, File file, String path) throws IOException {
        if (file.isFile()) {
            int len = 0;
            ZipEntry ze = new ZipEntry(path + file.getName());
            zos.putNextEntry(ze);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buf = new byte[DEFAULT_BUFFER_LENGTH];
            while ((len = bis.read(buf)) != -1) {
                zos.write(buf);
                zos.flush();
            }
            bis.close();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            path += (path.length() == 0) ? "" : File.separator;
            for (int i = 0; i < files.length; i++) {
                zipFile(zos, files[i], path + files[i].getName());
            }
        }
    }

    public boolean copyFile(File srcFile, String desPath, String rootPath) throws IOException {
        if (!srcFile.exists()) {
            return false;
        }
        String parentPath = srcFile.getParent();
        String filePath = desPath + parentPath.substring(rootPath.lastIndexOf(File.separator));
        File desFolder = new File(filePath);
        if (!desFolder.exists()) {
            if (!filePath.endsWith(File.separator)) {
                filePath += File.separator;
            }
            desFolder = new File(filePath);
            desFolder.mkdirs();
        }
        FileChannel fcin = new FileInputStream(srcFile).getChannel();
        FileChannel fcout = new FileOutputStream(new File(desFolder, srcFile.getName())).getChannel();
        fcin.transferTo(0, fcin.size(), fcout);
        fcin.close();
        fcout.close();
        return true;
    }

    public void deleteTempFile(File desFile) {
        if (desFile.isFile()) {
            desFile.delete();
        } else if (desFile.isDirectory()) {
            File[] files = desFile.listFiles();
            for (File file : files) {
                deleteTempFile(file);
            }
            desFile.delete();
        }
    }
}
