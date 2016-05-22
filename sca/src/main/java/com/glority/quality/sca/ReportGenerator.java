package com.glority.quality.sca;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.glority.quality.sca.model.ErrorNode;
/**
 * generate standard report.
 * @author ZHAO JP
 *
 */
public class ReportGenerator {
    private static final ReportGenerator INSTANCE = new ReportGenerator();
    public static final String NODE_SUMMARY = "summary";
    public static final String ATTRIBUTE_TOTAL_ERRORS = "totalErrors";
    public static final String ATTRIBUTE_TOTAL_WARNING = "totalWarnings";
    public static final String NODE_ERROR_TYPE = "errorType";
    public static final String ATTRIBUTE_SEVERITY_LEVEL = "severityLevel";
    public static final String ATTRIBUTE_TOTAL_AMOUNT = "totalAmount";
    public static final String NODE_ERRORS = "errors";
    public static final String NODE_ERROR = "error";
    public static final String ATTRIBUTE_ID = "Id";
    public static final String ATTRIBUTE_FILE = "file";
    public static final String ATTRIBUTE_START_LINE = "startLine";
    public static final String ATTRIBUTE_END_LINE = "endLine";
    public static final String ATTRIBUTE_ERROR_MESSAGE = "errorMessage";
    public static final String SEVERITY_LEVEL_ERROR = "error";
    public static final String SEVERITY_LEVEL_WARNING = "warning";

    public static ReportGenerator getInstance() {
        return INSTANCE;
    }

    public void generateStandardReport(String originalReportPath, List<ErrorNode> errorNodes) throws Exception {
        int errorAmount = 0;
        int warningAmount = 0;
        Map<String, Integer> subErrorAmount = new HashMap<String, Integer>();
        Map<String, Integer> subWarningAmount = new HashMap<String, Integer>();

        Document staDocument = DocumentHelper.createDocument();
        Element staRoot = staDocument.addElement(originalReportPath.substring(originalReportPath.lastIndexOf("/") + 1,
                originalReportPath.lastIndexOf(".")));
        Element summaryEle = staRoot.addElement(NODE_SUMMARY);
        Element errorEle = staRoot.addElement(NODE_ERRORS);

        for (ErrorNode errorNode : errorNodes) {
            String errorId = errorNode.getId();
            if (SEVERITY_LEVEL_WARNING.equalsIgnoreCase(errorNode.getErrorType())) {
                caculateErrorAmount(subWarningAmount, errorId);
                warningAmount++;
            } else if (SEVERITY_LEVEL_ERROR.equalsIgnoreCase(errorNode.getErrorType())) {
                errorAmount++;
                caculateErrorAmount(subErrorAmount, errorId);
                Element temp = errorEle.addElement(ReportGenerator.NODE_ERROR);
                temp.addAttribute(ATTRIBUTE_ID, errorId);
                temp.addAttribute(ATTRIBUTE_FILE, errorNode.getFile());
                temp.addAttribute(ATTRIBUTE_START_LINE, errorNode.getStartLine());
                temp.addAttribute(ATTRIBUTE_END_LINE, errorNode.getEndLine());
                temp.addAttribute(ATTRIBUTE_ERROR_MESSAGE, errorNode.getErrorMessage());
            }
        }
        summaryEle.addAttribute(ATTRIBUTE_TOTAL_ERRORS, String.valueOf(errorAmount));
        summaryEle.addAttribute(ATTRIBUTE_TOTAL_WARNING, String.valueOf(warningAmount));
        addErrorSumNode(subErrorAmount, summaryEle, SEVERITY_LEVEL_ERROR);
        addErrorSumNode(subWarningAmount, summaryEle, SEVERITY_LEVEL_WARNING);

        int suffixDotIndex = originalReportPath.lastIndexOf(".");
        String standardReportPath = originalReportPath.substring(0, suffixDotIndex) + "-standard" + ".xml";
        FileWriter writer = new FileWriter(standardReportPath);
        staDocument.write(writer);
        writer.close();
    }

    public void caculateErrorAmount(Map<String, Integer> subErrorAmount, String errorId) {
        if (subErrorAmount.containsKey(errorId)) {
            subErrorAmount.put(errorId, subErrorAmount.get(errorId) + 1);
        } else {
            subErrorAmount.put(errorId, 1);
        }
    }

    private void addErrorSumNode(Map<String, Integer> errorAmounts, Element summary, String severityLevel) {
        Iterator<String> errorTypes = errorAmounts.keySet().iterator();
        while (errorTypes.hasNext()) {
            String errorType = errorTypes.next();
            Element errorSum = summary.addElement(NODE_ERROR_TYPE);
            errorSum.addAttribute(ATTRIBUTE_ID, errorType);
            errorSum.addAttribute(ATTRIBUTE_SEVERITY_LEVEL, severityLevel);
            errorSum.addAttribute(ATTRIBUTE_TOTAL_AMOUNT, errorAmounts.get(errorType).toString());

        }
    }

    public List<String> getExcludeErrors(String errorTypePrefix, String scaErrorSetting) throws IOException {
        FileInputStream errorSettingStream = new FileInputStream(scaErrorSetting);
        Properties errorSettingPro = new Properties();
        errorSettingPro.load(errorSettingStream);
        Iterator<Object> errorKeys = errorSettingPro.keySet().iterator();
        List<String> unimportantErrors = new ArrayList<String>();
        while (errorKeys.hasNext()) {
            String errorKey = errorKeys.next().toString();
            if (errorKey.startsWith(errorTypePrefix) && "warning".equals(errorSettingPro.getProperty(errorKey))) {
                unimportantErrors.add(errorKey.substring(errorTypePrefix.length() + 1));
            }
        }
        return unimportantErrors;
    }
}
