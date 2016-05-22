package com.glority.quality.sca.mi.parser;

import java.io.File;

import org.antlr.runtime.TokenStream;

import com.glority.quality.sca.antlr.LanguageParserFactory;
import com.glority.quality.sca.antlr.LanguageParserFactory.LanguageEnum;
/**
 * MI.
 * @author XQS
 *
 */
public final class MIParserFactory {
    private static MIParserFactory instance = new MIParserFactory();

    private MIParserFactory() { // Disable the public constructor

    }

    public static MIParserFactory getInstance() {
        return instance;
    }

    public IMISourceCodeParser getMIParser(File file, LanguageEnum lang) {
        TokenStream ts = LanguageParserFactory.getInstance().getTokenStream(
                file, lang);
        try {
            IMISourceCodeParser miParser = null;
            switch (lang) {
            case CPP:
                miParser = new CppMIParser(ts);
                break;
            case JAVA:
                miParser = new JavaMIParser(ts);
                break;
            case CS:
                miParser = new CSMIParser(ts);
                break;
            case JS:
                miParser = new ES3MIParser(ts);
                break;
            default:
                // Do Nothing
            }

            return miParser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            // TODO: Handle this exception better
        }
    }
}