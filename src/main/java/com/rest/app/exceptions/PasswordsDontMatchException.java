package com.rest.app.exceptions;



public class PasswordsDontMatchException extends Exception {


    private String message;

    public PasswordsDontMatchException() {

    }

    public PasswordsDontMatchException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
