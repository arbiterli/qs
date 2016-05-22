package com.glority.qualityserver.exception;

/**
 * no annotation exception.
 * 
 * @author liheping
 * 
 */
public class NoAnnotationException extends RuntimeException {

    private static final long serialVersionUID = 5113097152773157495L;

    public NoAnnotationException() {

    }

    public NoAnnotationException(String message) {
        super(message);
    }

}
