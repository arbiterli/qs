package com.glority.quality.sca.counter;

/**
 * Stroe the common comment patterns for the File line counter.
 * @author cz
 *
 */
public final class CommentPattern {

    /**
     * Default constructor.
     */
    private CommentPattern() {
    }

    public static final String COMMENT_PATTERN1 = "/* */";
    public static final String COMMENT_PATTERN2 = "<!-- -->";
    public static final String COMMENT_PATTERN3 = "<%-- --%>";

}
