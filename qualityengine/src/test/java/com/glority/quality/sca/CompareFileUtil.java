package com.glority.quality.sca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CompareFileUtil {
	
	/**
	 * The method is to compare the expected report on svn with generated file.
	 * @param expectedFile
	 * @param generatedFile
	 * @return A boolean value that represents if generated File == expected File.
	 * @throws IOException
	 */
	public static boolean compareReports(File expectedFile, File generatedFile) throws IOException{
		boolean isEqual = true;
		BufferedReader brExpected = new BufferedReader(new FileReader(expectedFile));
		BufferedReader brGenerated = new BufferedReader(new FileReader(generatedFile));
		String expectedLine = null;
		String generatedLine = null;
		while((expectedLine = brExpected.readLine()) != null & (generatedLine = brGenerated.readLine()) != null){
			if(!expectedLine.equals(generatedLine)){
				isEqual = false;
			}
		}
		if(expectedLine != null || generatedLine != null){
			isEqual = false;
		}
		brExpected.close();
		brGenerated.close();
		return isEqual;
	}
}
