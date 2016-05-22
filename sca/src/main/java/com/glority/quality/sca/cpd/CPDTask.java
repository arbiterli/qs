/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package com.glority.quality.sca.cpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.EnumeratedAttribute;
import org.dom4j.Element;

import com.glority.quality.sca.BaseSCATask;
import com.glority.quality.sca.FileUtil;
import com.glority.quality.sca.model.ErrorNode;

/**
 * CPDTask
 * <p/>
 * Runs the CPD utility via ant. The ant task looks like this:
 * <p/>
 * <project name="CPDProj" default="main" basedir="."> <taskdef name="cpd"
 * classname="net.sourceforge.pmd.cpd.CPDTask" /> <target name="main"> <cpd
 * encoding="UTF-16LE" language="java" ignoreIdentifiers="true"
 * ignoreLiterals="true" minimumTokenCount="100" outputFile="c:\cpdrun.txt"
 * method="byFolder" divisionNum="100"> <fileset dir="/path/to/my/src"> <include
 * name="*.java"/> </fileset> </cpd> </target> </project>
 * <p/>
 * Required: minimumTokenCount, outputFile, method, divisionNum(default value is
 * 500) and at least one file
 */
public class CPDTask extends BaseSCATask {

    private static final String TEXT_FORMAT = "text";
    private static final String XML_FORMAT = "xml";
    private static final String CSV_FORMAT = "csv";

    private String format = TEXT_FORMAT;
    private String language = "java";
    private int minimumTokenCount;
    private boolean ignoreLiterals;
    private boolean ignoreIdentifiers;
    private File outputFile;
    private String encoding = System.getProperty("file.encoding");

    @Override
    public void runSCA() throws BuildException {
        try {
            clearReportAndInit();
            run(pieces);
        } catch (IOException ioe) {
            log(ioe.toString(), Project.MSG_ERR);
            throw new BuildException("IOException during task execution", ioe);
        } catch (ReportException re) {
            re.printStackTrace();
            log(re.toString(), Project.MSG_ERR);
            throw new BuildException("ReportException during task execution", re);
        }
    }

    public Map<String, Integer> analyzeOriginalReport(String originalReportPath, Map<String, Integer> subErrorAmount,
            Map<String, Integer> subWarningAmount, Element errorEle) throws Exception {
        return null;
    }

    public void clearReportAndInit() {
        this.setReportFilePath(outputFile.getAbsolutePath());
        File reportFolder = outputFile.getParentFile();
        File[] reportFiles = reportFolder.listFiles();
        for (int i = 0; i < reportFiles.length; i++) {
            reportFiles[i].delete();
        }
    }

    @Override
    public void doWithReport() throws Exception {
        mergeReport(reportFilePath);
        FileUtil.getInstance().zipAndDeleteOriReport(reportFilePath);
    }

    public void mergeReport(String reportFilePath) throws IOException {
        File file = (new File(reportFilePath)).getParentFile();
        File[] files = file.listFiles();
        OutputStream os = new FileOutputStream(reportFilePath);
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                FileInputStream fin = new FileInputStream(files[i]);
                BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                String line = br.readLine();
                while (line != null) {
                    os.write((line + "\n").getBytes());
                    line = br.readLine();
                }
                br.close();
                fin.close();
                files[i].delete();
            }
        }
        os.close();
        String summaryReportPath = file.getAbsolutePath() + File.separator + "summary_CPD_report.txt";
        generateErrorReport(reportFilePath, summaryReportPath);
    }

    private void generateErrorReport(String reportFilePath, String completeReportPath) throws IOException {
        FileInputStream fin = new FileInputStream(new File(reportFilePath));
        OutputStream os = new FileOutputStream(new File(completeReportPath));
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
        String line = null;
        while ((line = br.readLine()) != null) {
            if (isTheLineNeededInReport(line)) {
                os.write((line + "\n").getBytes());
            }
        }
        br.close();
        fin.close();
        os.close();
    }

    private boolean isTheLineNeededInReport(String line) {
        if (line.startsWith("=======") || line.startsWith("Found a ") || line.startsWith("Starting at line")) {
            return true;
        }
        return false;
    }

    public void generateStandardReport(String reportFilePath) {
        return;
    }

    private void run(List<List<File>> listOfFileList) throws IOException, ReportException {
        run_single_fileList(listOfFileList);
        if (listOfFileList.size() > 1) {
            run_double_fileList(listOfFileList);
        }
    }

    private void run_double_fileList(List<List<File>> listOfFileList) throws IOException, ReportException {
        for (int i = 0; i < listOfFileList.size(); i++) {
            for (int j = i + 1; j < listOfFileList.size(); j++) {
                validateFields();
                CPDConfiguration config = new CPDConfiguration(minimumTokenCount, createLanguage(), encoding);
                CPD cpd = new CPD(config);
                List<File> fl1 = listOfFileList.get(i);
                List<File> fl2 = listOfFileList.get(j);
                for (File file : fl1) {
                    cpd.add(file);
                }
                for (File file : fl2) {
                    cpd.addBaseFile(file);
                }
                analyzeCode(cpd, true);
                this.setOutputFile(new File(outputFile.getParentFile().getAbsolutePath() + File.separator + i + "-" + j
                        + "cpd.txt"));
                report(cpd);
            }
        }
    }

    private void run_single_fileList(List<List<File>> listOfFileList) throws IOException, ReportException {
        for (int i = 0; i < listOfFileList.size(); i++) {
            List<File> fileList = listOfFileList.get(i);
            validateFields();
            CPDConfiguration config = new CPDConfiguration(minimumTokenCount, createLanguage(), encoding);
            CPD cpd = new CPD(config);
            for (File file : fileList) {
                cpd.add(file);
            }
            analyzeCode(cpd, false);
            this.setOutputFile(new File(outputFile.getParentFile().getAbsolutePath() + File.separator + i + "-" + i
                    + "cpd.txt"));
            report(cpd);
        }
    }

    private Language createLanguage() {
        Properties p = new Properties();
        if (ignoreLiterals) {
            p.setProperty(JavaTokenizer.IGNORE_LITERALS, "true");
        }
        if (ignoreIdentifiers) {
            p.setProperty(JavaTokenizer.IGNORE_IDENTIFIERS, "true");
        }
        return new LanguageFactory().createLanguage(language, p);
    }

    private void report(CPD cpd) throws ReportException, IOException {
        Renderer renderer = createRenderer();
        renderer.render(cpd.getMatches(), outputFile);
    }

    private long analyzeCode(CPD cpd, boolean isSlice) {
        long start = System.currentTimeMillis();
        cpd.go(isSlice);
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    private Renderer createRenderer() {
        if (format.equals(TEXT_FORMAT)) {
            return new SimpleRenderer();
        } else if (format.equals(CSV_FORMAT)) {
            return new CSVRenderer();
        }
        return new XMLRenderer();
    }

    private void validateFields() throws BuildException {
        if (minimumTokenCount == 0) {
            throw new BuildException("minimumTokenCount is required and must be greater than zero");
        } else if (filesets.isEmpty()) {
            throw new BuildException("Must include at least one FileSet");
        }
    }

    public void setMinimumTokenCount(int minimumTokenCount) {
        this.minimumTokenCount = minimumTokenCount;
    }

    public void setIgnoreLiterals(boolean value) {
        this.ignoreLiterals = value;
    }

    public void setIgnoreIdentifiers(boolean value) {
        this.ignoreIdentifiers = value;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public void setFormat(FormatAttribute formatAttribute) {
        format = formatAttribute.getValue();
    }

    public void setLanguage(LanguageAttribute languageAttribute) {
        language = languageAttribute.getValue();
    }

    public void setEncoding(String encodingValue) {
        encoding = encodingValue;
    }

    public static class FormatAttribute extends EnumeratedAttribute {
        private static final String[] FORMATS = new String[] { XML_FORMAT, TEXT_FORMAT, CSV_FORMAT };

        public String[] getValues() {
            return FORMATS;
        }
    }

    public static class LanguageAttribute extends EnumeratedAttribute {
        private static final String[] LANGUAGES = new String[] { "java", "jsp", "cpp", "c", "php", "ruby", "fortran",
                "cs", "ecmascript", "javascript", "css" };

        public String[] getValues() {
            return LANGUAGES;
        }
    }

    @Override
    public List<ErrorNode> analyzeOriginalReport(String originalReportPath) throws Exception {
        return null;
    }
}
