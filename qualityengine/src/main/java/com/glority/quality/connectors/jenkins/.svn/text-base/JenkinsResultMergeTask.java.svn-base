package com.glority.quality.connectors.jenkins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.ant.BuildException;

import com.glority.quality.BaseTask;
import com.glority.quality.connectors.ftp.FTPTPUploadTask;
import com.glority.quality.connectors.ftp.FTPTestsDownloadTask;
import com.glority.quality.connectors.reportserver.UploadQualityReportTask;
import com.glority.quality.reportxml.QualityReportMergeTask;
/**
 * to do jenkins result merge.
 * @author zm.
 *
 */
public class JenkinsResultMergeTask extends BaseTask {

    private String cacheFolderPath;

    private String businessUnit;

    private String productName;

    private String ftpServer;

    private String ftpUser;

    private String ftpPassword;

    private String ftpPathDefFile;

    private String jenkinsBuild;

    private String covToolBinFolder;

    private String qualityXmlUploadURL;

    private static final String DEFAULT_CACHE_FOLDER = File.separator
            + "JenkinsResultMergeCache";
    private static final String TEMP_DIR_KEY = "java.io.tmpdir";

    private static final String FTP_DOWNLOAD_TYPE = "tests";

    private static final String COV_FILE = "test.cov";

    private static final String REPORT_FILE = "quality.xml";

    private static final String FINAL_COV_FOLDER = File.separator
            + "cpp-coverage";

    private static final String HTML_REPORT = "html_report";

    private static final String XML_REPORT = "xml_report";

    private static final String OUTPUT_FOLDER = "output";

    private static final String FTP_UPLOAD_TYPE = "qualityreports";

    private static Log log;

    public JenkinsResultMergeTask() {
        log = LogFactory.getLog(this.getClass().getName());
    }

    public void setCacheFolderPath(String cacheFolderPath) {
        this.cacheFolderPath = cacheFolderPath;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setFtpServer(String ftpServer) {
        this.ftpServer = ftpServer;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public void setFtpPathDefFile(String ftpPathDefFile) {
        this.ftpPathDefFile = ftpPathDefFile;
    }

    public void setJenkinsBuild(String jenkinsBuild) {
        this.jenkinsBuild = jenkinsBuild;
    }

    public void setCovToolBinFolder(String covToolBinFolder) {
        this.covToolBinFolder = covToolBinFolder;
    }

    public void setQualityXmlUploadURL(String qualityXmlUploadURL) {
        this.qualityXmlUploadURL = qualityXmlUploadURL;
    }

    @Override
    public void process() throws Exception {
        prepareEnv();
        downloadTestsData();
        mergeAndOutputCovData();
        mergeQualityReport();
        updateMergedData();
        clearEnv();
    }

    /**
     * to prepare environment.
     */
    private void prepareEnv() {
        if (cacheFolderPath == null) {
            cacheFolderPath = System.getProperty(TEMP_DIR_KEY)
                    + DEFAULT_CACHE_FOLDER;
        }
        File cacheFolder = new File(cacheFolderPath);
        if (cacheFolder.exists()) {
            deleteFile(cacheFolder);
        }
        cacheFolder.mkdir();
        File outputFolder = new File(cacheFolderPath + File.separator
                + OUTPUT_FOLDER);
        outputFolder.mkdir();
    }

    /**
     * to download tests data.
     */
    private void downloadTestsData() {
        FTPTestsDownloadTask dataDownloader = new FTPTestsDownloadTask();
        dataDownloader.setProductName(productName);
        dataDownloader.setBusinessUnit(businessUnit);
        dataDownloader.setLocalPath(cacheFolderPath);
        dataDownloader.setFolderType(FTP_DOWNLOAD_TYPE);
        dataDownloader.setJenkinsBuild(jenkinsBuild);
        dataDownloader.setServer(ftpServer);
        dataDownloader.setUsername(ftpUser);
        dataDownloader.setPassword(ftpPassword);
        dataDownloader.setPathDefFile(ftpPathDefFile);
        dataDownloader.process();
        log.info("Download tests data finished.");
    }

    /**
     * to merge and output cov data.
     */
    private void mergeAndOutputCovData() {
        List<String> covFileList = getTypeFileList(COV_FILE);
        if (covFileList.size() < 2) {
            throw new BuildException(" Less than 2 cov files.");
        }
        CovFileTool covFileOperator = new BullsEyeTool(covToolBinFolder);
        String finalCovFile = cacheFolderPath + File.separator + OUTPUT_FOLDER
                + File.separator + COV_FILE;
        String finalCovHtmlFolder = cacheFolderPath + File.separator
                + OUTPUT_FOLDER + File.separator + FINAL_COV_FOLDER
                + File.separator + HTML_REPORT;
        String finalCovXmlFile = cacheFolderPath + File.separator
                + OUTPUT_FOLDER + File.separator + FINAL_COV_FOLDER
                + File.separator + XML_REPORT;
        covFileOperator.mergedFiles(covFileList, finalCovFile);
        covFileOperator.convertToHtml(finalCovFile, finalCovHtmlFolder);
        covFileOperator.convertToXml(finalCovFile, finalCovXmlFile);
        log.info("Merge and output coverage data finished.");
    }

    /**
     * to merge quality.xml.
     */
    private void mergeQualityReport() {
        try {
            List<String> qualityReports = getTypeFileList(REPORT_FILE);
            if (qualityReports.size() < 2) {
                throw new BuildException(" Less than 2 reports.");
            }
            String finalReportPath = cacheFolderPath + File.separator
                    + OUTPUT_FOLDER + File.separator + REPORT_FILE;
            QualityReportMergeTask mergeTask = new QualityReportMergeTask();
            mergeTask.setSrcRptOneName(qualityReports.get(0));
            mergeTask.setSrcRptTwoName(qualityReports.get(1));
            mergeTask.setTargetRptName(finalReportPath);
            mergeTask.process();
            for (int i = 2; i < qualityReports.size(); i++) {
                mergeTask.setSrcRptOneName(finalReportPath);
                mergeTask.setSrcRptTwoName(qualityReports.get(i));
                mergeTask.setTargetRptName(finalReportPath);
                mergeTask.process();
            }
            log.info("Merge quality report finished.");
        } catch (Exception e) {
            throw new BuildException(e);
        }
    }

    /**
     * to ftp update the final merged data.
     */
    private void updateMergedData() {
        String localOutputFolder = cacheFolderPath + File.separator
                + OUTPUT_FOLDER + File.separator + FINAL_COV_FOLDER;
        String finalReportPath = cacheFolderPath + File.separator
                + OUTPUT_FOLDER + File.separator + REPORT_FILE;
        FTPTPUploadTask dataUploader = new FTPTPUploadTask();
        dataUploader.setQualityXmlPath(cacheFolderPath + File.separator
                    + OUTPUT_FOLDER + File.separator + REPORT_FILE);
        dataUploader.setProductName(productName);
        dataUploader.setBusinessUnit(businessUnit);
        dataUploader.setLocalPath(localOutputFolder);
        dataUploader.setFolderType(FTP_UPLOAD_TYPE);
        dataUploader.setJenkinsBuild(jenkinsBuild);
        dataUploader.setServer(ftpServer);
        dataUploader.setUsername(ftpUser);
        dataUploader.setPassword(ftpPassword);
        dataUploader.setPathDefFile(ftpPathDefFile);
        dataUploader.execute();
        log.info("Upload coverage files finished.");
        UploadQualityReportTask uploadReportTask = new UploadQualityReportTask();
        uploadReportTask.setQualityXmlPath(finalReportPath);
        uploadReportTask.setQualityXmlUploadURL(qualityXmlUploadURL);
        uploadReportTask.execute();
        log.info("Update merged report finished.");
    }

    /**
     * to clear cache data.
     */
    private void clearEnv() {
        deleteFile(new File(cacheFolderPath));
        log.info("Clear environment finished.");
    }

    /**
     * to get latest suite folder.
     * @return the latest suite folder.
     */
    private File getLatestSuiteFolder() {
        File cacheFolder = new File(cacheFolderPath);
        if (!cacheFolder.exists()) {
            throw new BuildException("Cann't find data cache folder.");
        }
        File[] testsFolders = cacheFolder.listFiles();
        File testsFolder = null;
        for (File folder : testsFolders) {
            if (FTP_DOWNLOAD_TYPE.equals(folder.getName())) {
                testsFolder = folder;
            }
        }

        if (null == testsFolder) {
            throw new BuildException("No jenkins test run data.");
        }

        File[] suiteFolders = testsFolder.listFiles();
        int maxSuiteNum = 0;
        File suiteFolder = null;
        for (File folder : suiteFolders) {
            if (folder.isDirectory()) {
                int currentSuiteNum = Integer.parseInt(folder.getName());
                if (currentSuiteNum > maxSuiteNum) {
                    suiteFolder = folder;
                    maxSuiteNum = currentSuiteNum;
                }
            }
        }
        return suiteFolder;
    }

    /**
     * to delete file or folder.
     * 
     * @param file
     *            the file need to delete.
     */
    private void deleteFile(File file) {
        if (!file.exists()) {
            log.warn(file.getAbsoluteFile()
                    + " doesn't exist, cann't be remove when clear environment.");
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                this.deleteFile(files[i]);
            }
        }
    }

    /**
     * to get the absolute path of a cov file.
     * 
     * @param testFolder the test folder.
     * @param type file type.
     * @return the absolute path of a cov file.
     */
    private String getTypeFilePath(File testFolder, String type) {
        File[] files = testFolder.listFiles();
        for (File file : files) {
            if (type.equals(file.getName())) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }

    /**
     * to get a list of absolute file path with the same file name.
     * 
     * @param type
     *            the file name.
     * @return a list of file path
     */
    private List<String> getTypeFileList(String type) {
        File latestSuiteFolder = getLatestSuiteFolder();
        if (null == latestSuiteFolder) {
            throw new BuildException(" There is no suite folder.");
        }
        List<String> typeFileList = new ArrayList<String>();
        File[] testFolders = latestSuiteFolder.listFiles();
        for (File testFolder : testFolders) {
            if (testFolder.isDirectory()) {
                String covFilePath = getTypeFilePath(testFolder, type);
                if (null != covFilePath) {
                    typeFileList.add(covFilePath);
                }
            }
        }
        return typeFileList;
    }

}
