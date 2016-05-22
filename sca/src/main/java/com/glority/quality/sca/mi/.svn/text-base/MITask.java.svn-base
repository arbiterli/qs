package com.glority.quality.sca.mi;

import java.util.List;

import org.apache.tools.ant.BuildException;

import com.glority.quality.sca.BaseSCATask;
import com.glority.quality.sca.antlr.LanguageParserFactory.LanguageEnum;
import com.glority.quality.sca.model.ErrorNode;

/**
 * MI task.
 * 
 * @author LYX
 * 
 */
public class MITask extends BaseSCATask {
    private String reportPath;
    private String language;

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private LanguageEnum getLanguageEnum() {
        if ("java".equals(language)) {
            return LanguageEnum.JAVA;
        } else if ("cpp".equals(language)) {
            return LanguageEnum.CPP;
        } else if ("cs".equals(language)) {
            return LanguageEnum.CS;
        } else if ("js".equals(language)) {
            return LanguageEnum.JS;
        }
        return null;
    }

    @Override
    public void runSCA() {
        MI mi = new MI();
        try {
            mi.runMI(pieces, getLanguageEnum(), reportPath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException();
        }
    }

    @Override
    public void doWithReport() {

    }

    @Override
    public List<ErrorNode> analyzeOriginalReport(String originalReportPath) throws Exception {
        return null;
    }
}
