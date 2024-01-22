package com.project.demo.userexception;

public class TeacherException extends RuntimeException {

    public TeacherException(String message) {
        super(message);
    }

    public TeacherException(String message, Throwable cause) {
        super(message, cause);
    }
}