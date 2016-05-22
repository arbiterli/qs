package com.glority.quality.metrics.js;

import com.glority.quality.Constants.Language;
import com.glority.quality.metrics.MICheckBaseTask;

/**
 * check Javascript MI report.
 * @author LYX
 */
public class JSMICheckTask extends MICheckBaseTask {

    @Override
    public String getLanguageName() {
        return Language.JS.toString();
    }

}