package com.glority.quality.sca.antlr.cs;

import java.util.Arrays;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;

public class CSharp4PreProcessorImpl extends CSharp4PreProcessor {

	public CSharp4PreProcessorImpl(CharStream input, final String... macroDefinitions) {
		super(input);
		definedMacros.addAll(Arrays.asList(macroDefinitions));
		ifStack.push(Boolean.TRUE); // start with accepting tokens
	}

	@Override
	public void mTokens() throws RecognitionException {
		// if we are in a block that should not be parsed due to current macro defs
		if (!ifStack.peek()) {
			mSkiPped_section_part();
		} else {
			super.mTokens();
		}
	}

}
