package com.glority.quality.sca;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.FileSet;

/**
 * filter to run sca slicely.
 * 
 * @author LYX
 * 
 */

public final class FileFilterToPiece {
    private int divisionNum;

    /**
     * method specify how to run the task, include "none","byFolder" and
     * "byDivision". byFolder
     * 
     * @author LYX
     * 
     */
    public enum MethodEnum {
        NONE("none"), BYFOLDER("byFolder"), BYDIVISION("byDivision");

        private String value;

        private MethodEnum(String value) {
            this.value = value;
        }

        public static MethodEnum getValueOf(String value) {
            MethodEnum[] methods = MethodEnum.values();
            for (MethodEnum method : methods) {
                if (method.value.equalsIgnoreCase(value)) {
                    return method;
                }
            }
            return NONE;
        }
    }

    public FileFilterToPiece() {

    }

    public void setDivisionNum(int divisionNum) {
        this.divisionNum = divisionNum;
    }

    public List<List<File>> getFilePieces(List<FileSet> fileSets, Project project, MethodEnum method) {
        if (method == MethodEnum.BYDIVISION) {
            return getListByDivision(fileSets, project, divisionNum);
        } else if (method == MethodEnum.BYFOLDER) {
            return getListByFolder(fileSets, project);
        } else {
            return getListByNone(fileSets, project);
        }
    }

    private boolean isSubFile(File file, File folder) {
        if (file.getAbsolutePath().contains(folder.getAbsolutePath())) {
            return true;
        }
        return false;
    }

    private List<File> getTotalFiles(List<FileSet> fileSets, Project project) {
        List<File> fileList = new ArrayList<File>();
        for (FileSet fileSet : fileSets) {
            DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(project);
            String[] includedFiles = directoryScanner.getIncludedFiles();
            for (int i = 0; i < includedFiles.length; i++) {
                File file = new File(directoryScanner.getBasedir() + System.getProperty("file.separator")
                        + includedFiles[i]);
                fileList.add(file);
            }
        }
        return fileList;
    }

    private List<List<File>> getListByNone(List<FileSet> fileSets, Project project) {
        List<List<File>> pieces = new ArrayList<List<File>>();
        List<File> fileList = getTotalFiles(fileSets, project);
        pieces.add(fileList);
        return pieces;
    }

    private List<List<File>> getListByDivision(List<FileSet> fileSets, Project project, int divisionNum) {
        List<List<File>> pieces = new ArrayList<List<File>>();
        List<File> fileList = getTotalFiles(fileSets, project);
        List<File> temp = new ArrayList<File>();
        int num = 0;
        for (File file : fileList) {
            temp.add(file);
            num++;
            if (num >= divisionNum) {
                pieces.add(temp);
                temp = new ArrayList<File>();
                num = 0;
            }
        }
        if (num > 0) {
            pieces.add(temp);
        }
        return pieces;
    }

    private List<List<File>> getListByFolder(List<FileSet> fileSets, Project project) {
        List<File> fileList = getTotalFiles(fileSets, project);
        List<List<File>> pieces = new ArrayList<List<File>>();
        List<File> folderList = getFolderList(fileSets);
        for (File folder : folderList) {
            List<File> temp = new ArrayList<File>();
            for (File file : fileList) {
                if (isSubFile(file, folder)) {
                    temp.add(file);
                }
            }
            pieces.add(temp);
        }
        return pieces;
    }

    private List<File> getFolderList(List<FileSet> fileSets) {
        List<File> folderList = new ArrayList<File>();
        for (FileSet fileSet : fileSets) {
            File baseDir = fileSet.getDir();
            File[] files = baseDir.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() && !files[i].getName().equals(".svn")) {
                    folderList.add(files[i]);
                }
            }
        }
        return folderList;
    }
}
