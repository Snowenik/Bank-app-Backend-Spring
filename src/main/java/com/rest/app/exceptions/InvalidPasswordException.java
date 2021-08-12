package com.rest.app.exceptions;



public class InvalidPasswordException extends Exception {


    private String message;

    public InvalidPasswordException() {

    }

    public InvalidPasswordException(String message) {
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
