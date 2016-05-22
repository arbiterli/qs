package com.glority.quality.sca.counter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;

/**
 * Test for class: FilesLineCount.
 * @author Administrator
 *
 */
public class FileLineCountrTest extends AbstractBaseTaskTest {

    private FileLineCounter counter;
    private String FILE_NAME = "testtasks\\testsrc\\jsp\\test.jsp";
    private File testFile;

    /**
     * Set up test env.
     */
    @BeforeClass
    public void setUp() {
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile1() throws IOException {
        getCounterByFileContent("<!-- comment--> code <!-- comment-->", true);
        assertEquals(2, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile2() throws IOException {
        getCounterByFileContent("<!--comment-->code<!--", true);
        assertEquals(2, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile3() throws IOException {
        getCounterByFileContent("<%--comment-->code", true);
        assertEquals(1, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile4() throws IOException {
        getCounterByFileContent("-->code<!--", false);
        assertEquals(2, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile5() throws IOException {
        getCounterByFileContent("-->code<!--comment-->", false);
        assertEquals(2, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile6() throws IOException {
        getCounterByFileContent("-->code", false);
        assertEquals(1, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile7() throws IOException {
        getCounterByFileContent("comment-->code", false);
        assertEquals(1, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile8() throws IOException {
        getCounterByFileContent("comment-->code<!--comment", false);
        assertEquals(2, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile9() throws IOException {
        getCounterByFileContent("comment-->code<!--comment-->", false);
        assertEquals(2, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile10() throws IOException {
        getCounterByFileContent("comment-->code<!--", false);
        assertEquals(2, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile11() throws IOException {
        getCounterByFileContent("code", true);
        assertEquals(0, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile12() throws IOException {
        getCounterByFileContent("code", false);
        assertEquals(1, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(0, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile13() throws IOException {
        getCounterByFileContent("code<!--comment-->code", true);
        assertEquals(1, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(2, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile14() throws IOException {
        getCounterByFileContent("code<!--comment-->", true);
        assertEquals(1, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile15() throws IOException {
        getCounterByFileContent("code<!--", true);
        assertEquals(1, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile16() throws IOException {
        getCounterByFileContent("code<!--comment", true);
        assertEquals(1, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(1, counter.getCodeLineCount());
    }

    /**
     * Test for method processFile.
     * @throws IOException 
     */
    @Test
    public void testpProcessInputFile17() throws IOException {
        getCounterByFileContent("<!--comment--><%--comment--%>", true);
        assertEquals(2, counter.getCommentLineCount());
        assertEquals(1, counter.getTotleLineCount());
        assertEquals(0, counter.getCodeLineCount());
    }

    /**
     * Get counter for test.
     * @param file Input file
     * @return Processed counter
     */
    private FileLineCounter getCounter(File file, Boolean isTheCommentOver) {
        FileLineCounter counter = new FileLineCounter();
        List<String> patterns = new ArrayList<String>();
        patterns.add(CommentPattern.COMMENT_PATTERN2);
        patterns.add(CommentPattern.COMMENT_PATTERN3);
        counter.setPatterns(patterns);
        counter.setFile(file);
        counter.setIsTheCommentOver(isTheCommentOver);
        counter.processFile();
        return counter;
    }

    /**
     * Get the counter.
     * @param content Test content
     * @throws IOException
     */
    private void getCounterByFileContent (String content, 
            boolean isTheCommentOver) throws IOException {
        testFile = new File(FILE_NAME);
        FileWriter fw = new FileWriter(testFile);
        fw.write(content);
        fw.close();
        counter = getCounter(testFile, isTheCommentOver); 
        testFile.delete();
    }
}
