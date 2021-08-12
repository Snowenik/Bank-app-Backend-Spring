package com.rest.app.exceptions;

public class InvalidAmountException extends Exception {


    private String message;

    public InvalidAmountException() {

    }

    public InvalidAmountException(String message) {
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
