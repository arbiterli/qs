package com.glority.common.connectors.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;

import com.glority.common.connectors.ConnectorException;

/**
 * FTPConnector.
 * 
 * @author li.heping
 * 
 */
public class FTPConnector {
    /**
     * the seperator value can not be change to File.separator.
     */
    public static final String FTP_FILE_SEPERATOR = "/";

    public static final int DEFAULT_PORT = 21;

    private FTPClient ftpClient;
    private FTPLoggerWrapper log;

    private String server;
    private int port;
    private String username;
    private String password;

    public FTPConnector(String server) {
        this(server, DEFAULT_PORT);
    }

    public FTPConnector(String server, String username, String password) {
        this(server, DEFAULT_PORT, username, password);
    }

    public FTPConnector(String server, int port) {
        this(server, port, "", "");
    }

    public FTPConnector(String server, int port, String username, String password) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.password = password;
        this.ftpClient = new FTPClient();
        this.log = new FTPLoggerWrapper();
    }

    /**
     * set the log. the log to get the program working.
     * 
     * @param log
     */
    public void setLog(FTPLogger log) {
        this.log.setLogger(log);
    }

    /**
     * upload the local path contents to remote path.
     * 
     * @param localPath
     *            file or directory.
     * @param remotePath
     *            file or directory
     * @throws ConnectorException
     */
    public void upload(String localPath, String remotePath) throws ConnectorException {
        try {
            this.initFtpEnv(FTPOperation.UPLOAD);

            File localFile = new File(localPath);

            if (!localFile.exists()) {
                this.log.error(localPath + " not found.");
                throw new FileNotFoundException(localPath + " not found.");
            }

            if (localFile.isDirectory()) {
                uploadFolder(localFile, remotePath);
            } else {
                uploadFile(localFile, remotePath);
            }

            this.log.finalCall();
        } catch (Exception e) {
            this.log.error("upload from " + localPath + " to " + remotePath + " failed");
            throw new ConnectorException(e.getMessage(), e);
        } finally {
            clearEnv();
        }
    }

    /**
     * download remote path contents to local path.
     * 
     * @param remotePath
     *            file or directory.
     * @param localPath
     *            file or directory.
     * @throws ConnectorException
     */
    public void download(String remotePath, String localPath) throws ConnectorException {
        try {
            this.initFtpEnv(FTPOperation.DOWNLOAD);

            createLocalFolder(localPath);

            if (!isRemoteFolder(remotePath)) {
                downloadFile(remotePath, localPath);
            } else {
                downloadFolder(remotePath, localPath);
            }

            log.finalCall();
        } catch (IOException e) {
            log.error("download from " + remotePath + " to " + localPath + " failed");
            throw new ConnectorException(e.getMessage(), e);
        } finally {
            clearEnv();
        }
    }

    /**
     * retrieveFileStream from remote. only for file, otherwise a
     * ConnectorException will got. be care that, when use this method, you
     * should manually init and clear env.
     * 
     * @param remoteFile
     *            only for a file name
     * @return
     * @throws ConnectorException
     */
    public InputStream retrieveFileStream(String remoteFile) throws ConnectorException {
        try {
            return this.ftpClient.retrieveFileStream(remoteFile);
        } catch (Exception e) {
            throw new ConnectorException(e.getMessage(), e);
        }
    }

    /**
     * ge the specified folder file or directory names.
     * 
     * @param remotePath
     * @return
     * @throws ConnectorException
     */
    public List<String> getSpecifiedFolderContentNames(String remotePath) throws ConnectorException {
        try {
            this.initFtpEnv(null);
            List<String> nameList = new ArrayList<String>();

            if (!ftpClient.changeWorkingDirectory(remotePath)) {
                throw new ConnectorException("Cann't find remote path " + remotePath);
            }

            FTPFile[] files = ftpClient.listDirectories();

            if (files != null) {
                for (FTPFile file : files) {
                    nameList.add(file.getName());
                }
            }

            return nameList;
        } catch (Exception e) {
            log.error("failed to get " + remotePath + " content names ");
            throw new ConnectorException(e.getMessage(), e);
        } finally {
            this.clearEnv();
        }
    }

    /**
     * init the ftp env.
     * 
     * @throws ConnectorException
     */
    public void initFtpEnv() throws ConnectorException {
        try {
            this.initFtpEnv(null);
        } catch (IOException e) {
            throw new ConnectorException(e.getMessage(), e);
        }
    }
    /**
     * to connect ftp.
     * 
     * @throws IOException
     * @throws SocketException
     */
    private void initFtpEnv(FTPOperation operation) throws IOException {

        FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
        config.setServerTimeZoneId(TimeZone.getDefault().getID());

        this.ftpClient.connect(server, port);
        this.ftpClient.login(username, password);
        this.ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        this.ftpClient.enterLocalPassiveMode();

        this.log.initLogger(operation);
    }

    /**
     * to close ftp connection.
     * 
     * @throws ConnectorException
     */
    public void clearEnv() throws ConnectorException {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            log.error("close ftp connection faild.");
            throw new ConnectorException("close ftp connection faild.");
        }
    }

    /**
     * to upload a folder.
     * 
     * @param localFolder
     *            the local folder.
     * @param remoteFolderPath
     *            the remote dist folder.
     * @throws ConnectorException
     */
    private void uploadFolder(File localFolder, String remoteFolderPath) throws ConnectorException {
        try {
            remoteFolderPath = remoteFolderPath.endsWith(FTP_FILE_SEPERATOR) ? remoteFolderPath
                    : (remoteFolderPath + FTP_FILE_SEPERATOR);
            String newRemoteFolderPath = remoteFolderPath + localFolder.getName();

            ftpClient.makeDirectory(newRemoteFolderPath);
            File[] fileList = localFolder.listFiles();
            for (File localFile : fileList) {
                if (localFile.isDirectory()) {
                    uploadFolder(localFile, newRemoteFolderPath);
                } else {
                    uploadFile(localFile, newRemoteFolderPath);
                }
            }
        } catch (Exception e) {
            log.error("Upload" + localFolder + " to " + remoteFolderPath + " failed");
            throw new ConnectorException(e.getMessage(), e);
        }
    }

    /**
     * to upload file.
     * 
     * @param localFile
     *            local file.
     * @param remoteFolderPath
     *            the remote folder path, it may be a file, so it will not end
     *            with '/'.
     * @return if successfully.
     * @throws ConnectorException
     */
    private void uploadFile(File localFile, String remoteFolderPath) throws ConnectorException {
        InputStream localFileInput = null;
        try {
            ftpClient.changeWorkingDirectory(FTP_FILE_SEPERATOR);

            if (!ftpClient.changeWorkingDirectory(remoteFolderPath)) {
                log.error("Cann't change to working directory " + remoteFolderPath);
                log.error(remoteFolderPath + "may be a file, try change to working directory to his parent directory");

                String parentFolderPath = remoteFolderPath.substring(0,
                        remoteFolderPath.lastIndexOf(FTP_FILE_SEPERATOR) + 1);
                if (!ftpClient.changeWorkingDirectory(parentFolderPath)) {
                    log.error("Cann't change to working directory " + parentFolderPath);
                    throw new ConnectorException("can not change working directory to " + remoteFolderPath + " or "
                            + parentFolderPath);
                }
            }

            localFileInput = new FileInputStream(localFile);

            if (!ftpClient.storeFile(localFile.getName(), localFileInput)) {
                log.error("Upload failed at upload file " + localFile.getName());
                throw new ConnectorException("Upload failed at upload file " + localFile.getName());
            }

            log.mark(localFile.getName());
        } catch (Exception e) {
            log.error("Upload file + " + localFile + " failed.");
            throw new ConnectorException(e.getMessage(), e);
        } finally {
            if (localFileInput != null) {
                try {
                    localFileInput.close();
                } catch (IOException e) {
                    log.error("failed to close upload file " + localFile);
                }
            }
        }
    }

    /**
     * to download file to native path.
     * 
     * @param ftpFile
     *            the ftp file.
     * @param localFolderPath
     *            local path.
     * @param remoteFolderPath
     *            remote path.
     * @throws ConnectorException
     */
    private void downloadFolder(String remoteFolderPath, String localFolderPath) throws ConnectorException {
        try {
            String newLocalFolderPath = localFolderPath + File.separator + getPathLastSegment(remoteFolderPath);

            createLocalFolder(newLocalFolderPath);
            if (!ftpClient.changeWorkingDirectory(remoteFolderPath)) {
                log.error("Cann't change to remote path " + remoteFolderPath);
                throw new ConnectorException("Cann't change to remote path " + remoteFolderPath);
            }

            FTPFile[] fileList = ftpClient.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                FTPFile remoteFile = fileList[i];
                String newRemoteFolderPath = new String(remoteFolderPath + FTP_FILE_SEPERATOR + remoteFile.getName());
                if (remoteFile.isFile()) {
                    downloadFile(newRemoteFolderPath, newLocalFolderPath);
                }

                if (remoteFile.isDirectory()) {
                    downloadFolder(newRemoteFolderPath, newLocalFolderPath);
                }
            }

        } catch (Exception e) {
            log.error("Download file from " + remoteFolderPath + " to  " + localFolderPath + " failed!");
            throw new ConnectorException(e.getMessage(), e);
        }

    }

    private void downloadFile(String remoteFilePath, String localFolderPath) throws ConnectorException {
        OutputStream outputStream = null;
        try {
            String remoteParentFolderPath = remoteFilePath.substring(0,
                    remoteFilePath.lastIndexOf(FTP_FILE_SEPERATOR) + 1);
            String remoteFileName = remoteFilePath.substring(remoteParentFolderPath.length());

            if (!ftpClient.changeWorkingDirectory(remoteParentFolderPath)) {
                log.error("Cann't change to directory " + remoteParentFolderPath);
                throw new ConnectorException("Cann't change to directory " + remoteParentFolderPath);
            }

            outputStream = new FileOutputStream(localFolderPath + File.separator + remoteFileName);
            ftpClient.retrieveFile(remoteFileName, outputStream);
            outputStream.flush();
            outputStream.close();

            log.mark(remoteFileName);

        } catch (Exception e) {
            log.error("Download from " + remoteFilePath + " to " + localFolderPath + " failed!");
            throw new ConnectorException(e.getMessage(), e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("failed to close " + localFolderPath);
                }
            }
        }
    }

    /**
     * to check if remote path is a folder.
     * 
     * @return if remote path is a folder.
     * @throws IOException
     */
    private boolean isRemoteFolder(String path) throws IOException {
        if (!ftpClient.changeWorkingDirectory(path)) {
            return false;
        }
        return true;
    }

    /**
     * to get the last segment of a path.
     * 
     * @param path
     *            the path
     * @return the last segment.
     */
    private String getPathLastSegment(String path) {
        String lastSegment;
        if (path.endsWith(FTP_FILE_SEPERATOR)) {
            lastSegment = path.substring(path.lastIndexOf(FTP_FILE_SEPERATOR, path.length() - 2) + 1);
        } else {
            lastSegment = path.substring(path.lastIndexOf(FTP_FILE_SEPERATOR) + 1);
        }
        return lastSegment;
    }

    /**
     * to create local folder.
     */
    private void createLocalFolder(String path) {
        File localFolder = new File(path);
        if (!localFolder.exists()) {
            localFolder.mkdir();
        }
    }

    /**
     * this log wrapper to deal with the log not set logic.
     * 
     * @author li.heping
     * 
     */
    private class FTPLoggerWrapper implements FTPLogger {
        FTPLogger logger;

        public void setLogger(FTPLogger logger) {
            this.logger = logger;
        }

        @Override
        public void initLogger(FTPOperation operation) {
            if (this.logger != null) {
                this.logger.initLogger(operation);
            }
        }

        @Override
        public void mark(String fileName) {
            if (this.logger != null) {
                this.logger.mark(fileName);
            }
        }

        @Override
        public void finalCall() {
            if (this.logger != null) {
                this.logger.finalCall();
            }
        }

        @Override
        public void error(String error) {
            if (this.logger != null) {
                this.logger.error(error);
            }
        }

        @Override
        public void warn(String warn) {
            if (this.logger != null) {
                this.logger.warn(warn);
            }
        }

    }
}
