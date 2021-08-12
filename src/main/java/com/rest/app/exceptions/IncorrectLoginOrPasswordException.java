package com.rest.app.exceptions;



public class IncorrectLoginOrPasswordException extends Exception {


    private String message;

    public IncorrectLoginOrPasswordException() {

    }


    public IncorrectLoginOrPasswordException(String message) {
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
