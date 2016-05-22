package com.glority.quality.sca.antlr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
/**
 * Windows will add a BOM string at the beginning of the file. 
 * TO mark the encoding of the file.
 * like EF BB BF for UFT8.  But antlr will not trim these strings automatically. 
 * And will cause a parsing failure.
 * So we extended ANTLRStringStream to trim the BOM header
 * 
 */
import org.antlr.runtime.ANTLRStringStream;

public class ANTLRFileStreamWithBOM extends ANTLRStringStream {
	protected String	fileName;

	public ANTLRFileStreamWithBOM(final String fileName) throws IOException {
		this(fileName, null);
	}

	public ANTLRFileStreamWithBOM(final String fileName, final String encoding) throws IOException {
		this.fileName = fileName;
		load(fileName, encoding);
	}

	public void load(final String fileName, final String encoding) throws IOException {
		if (fileName == null) {
			return;
		}
		File f = new File(fileName);
		long length = f.length();
		if (length > Integer.MAX_VALUE) {
			throw new BufferOverflowException();
		}
		int size = (int) length;

		InputStreamReader isr;
		FileInputStream fis = new FileInputStream(fileName);
		
		UnicodeBOMInputStream bomInputStream = new UnicodeBOMInputStream(fis);
		bomInputStream.skipBOM();

		if (encoding != null) {
			isr = new InputStreamReader(bomInputStream, encoding);
		} else {
			isr = new InputStreamReader(bomInputStream);
		}
		
		// bug in ANTLR: what if size is > Integer.MAX_VALUE
		// solution: read content within a loop and with a StringBuilder
		try {
			data = new char[size];
			super.n = isr.read(data);
		} finally {
			isr.close();
		}
	}

	@Override
	public String getSourceName() {
		return fileName;
	}
}
