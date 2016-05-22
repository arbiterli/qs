package com.glority.quality.sca.model;

public class ErrorNode {
    private String id;
    private String file;
    private String startLine;
    private String endLine;
    private String errorMessage;
    private String errorType;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public String getStartLine() {
        return startLine;
    }
    public void setStartLine(String startLine) {
        this.startLine = startLine;
    }
    public String getEndLine() {
        return endLine;
    }
    public void setEndLine(String endLine) {
        this.endLine = endLine;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorType() {
        return errorType;
    }
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

}
