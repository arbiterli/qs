package com.glority.quality.metrics.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.glority.quality.BaseTask;

/**
 * emma dumpsource.
 * 
 * @author LYX
 */
public class JavaEmmaDumpSourceTask extends BaseTask {
    private String emmaTempPath;
    private List<File> files = new ArrayList<File>();

    public static final Set<String> PACKAGE_STARTER = new HashSet<String>(Arrays.asList("com",
            "org"));

    public void setEmmaTempPath(String emmaTempPath) {
        this.emmaTempPath = emmaTempPath;
    }

    public void find(File file) {
        if (PACKAGE_STARTER.contains(file.getName())) {
            files.add(file);
        }
        File[] arrayFiles = file.listFiles();
        for (int i = 0; i < arrayFiles.length; i++) {
            if (arrayFiles[i].isDirectory()) {
                find(arrayFiles[i]);
            }
        }
    }

    public void moveFolder(File fromFolder, File toFolder) throws IOException {
        if (!fromFolder.isDirectory()) {
            return;
        }
        if (!toFolder.isDirectory()) {
            toFolder.mkdir();
        }
        File[] arrayFiles = fromFolder.listFiles();
        for (File file : arrayFiles) {
            if (file.isDirectory()) {
                moveFolder(file, new File(toFolder.getPath() + File.separator
                        + file.getName()));
            } else {
                file.renameTo(new File(toFolder.getPath() + File.separator
                        + file.getName()));
            }
        }
    }

    @Override
    public void process() throws IOException {
        // move right root dir to emmaTempPath
        File file = new File(emmaTempPath);
        find(file);
        for (int i = 0; i < files.size(); i++) {
            File rootFolder = new File(file.getPath() + File.separator
                    + files.get(i).getName());
            if (!rootFolder.isDirectory()) {
                rootFolder.mkdir();
            }
            moveFolder(files.get(i), rootFolder);
        }
    }
}
