package com.glority.quality.injection.cpp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.antlr.runtime.CommonTokenStream;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;

import com.glority.quality.sca.antlr.LanguageParserFactory;
import com.glority.quality.sca.antlr.LanguageParserFactory.LanguageEnum;

/**
 * instrument task.
 * @author LYX
 */
public class CppInjectionTask extends Task {
    private List<FileSet> filesets = new ArrayList<FileSet>();
    private String outputDir;
    private String[] includedFiles;
    private Vector<String> functions = new Vector<String>(); // save all the
                                                             // function name of
                                                             // all the files
    private String headInPath;
    private String headOutPath;
    private String includeText;
    private static final int INSERTNUM = 230;

    public void addFileset(FileSet set) {
        filesets.add(set);
    }

    public void setOutputDir(String saveDir) {
        this.outputDir = saveDir;
    }

    public void setHeadInPath(String headInPath) {
        this.headInPath = headInPath;
    }

    public void setHeadOutPath(String headOutPath) {
        this.headOutPath = headOutPath;
    }

    public void setIncludeText(String includeText) {
        this.includeText = includeText;
    }

    private List<File> getFiles() throws IOException {
        List<File> fileList = new ArrayList<File>();
        for (FileSet fileSet : filesets) {
            DirectoryScanner directoryScanner = fileSet
                    .getDirectoryScanner(getProject());
            includedFiles = directoryScanner.getIncludedFiles();
            for (int i = 0; i < includedFiles.length; i++) {
                File file = new File(directoryScanner.getBasedir()
                        + System.getProperty("file.separator")
                        + includedFiles[i]);
                fileList.add(file);
            }
        }
        return fileList;
    }

    public void execute() {
        try {
            for (int i = 0; i < getFiles().size(); i++) {
                File file = getFiles().get(i);
                CommonTokenStream ts = LanguageParserFactory.getInstance()
                        .getTokenStream(file, LanguageEnum.CPP);
                CppInjection inject = new CppInjection(ts);
                inject.injection(file, outputDir + File.separator
                        + includedFiles[i], functions, includeText);
            }
            CppInjection.headerFileInjection(headInPath, headOutPath,
                    functions, INSERTNUM);

        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException();
        }
    }
}
