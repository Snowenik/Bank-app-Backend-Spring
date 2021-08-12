package com.rest.app.exceptions;


public class UserDoesntExistException extends Exception {


    private String message;

    public UserDoesntExistException() {

    }


    public UserDoesntExistException(String message) {
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
