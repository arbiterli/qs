package com.glority.quality.sca.antlr.cs;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

// Generic type parameters are not supported by ANTLR's option TokenLabelType
@Deprecated
public class CommonReturnToken extends CommonToken {

	private static final long	serialVersionUID	= 1L;

	public CommonReturnToken(CharStream input, int type, int channel, int start, int stop) {
		super(input, type, channel, start, stop);
	}

	public CommonReturnToken(int type, String text) {
		super(type, text);
	}

	public CommonReturnToken(int type) {
		super(type);
	}

	public CommonReturnToken(Token oldToken) {
		super(oldToken);
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean	result;

}
