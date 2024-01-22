package com.project.demo.userexception;

public class CourseException extends RuntimeException {

    public CourseException(String message) {
        super(message);
    }

    public CourseException(String message, Throwable cause) {
        super(message, cause);
    }
}