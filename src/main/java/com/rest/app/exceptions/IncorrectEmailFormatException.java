package com.rest.app.exceptions;



public class IncorrectEmailFormatException extends Exception {


    private String message;


    public IncorrectEmailFormatException() {

    }

    public IncorrectEmailFormatException(String message) {
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

