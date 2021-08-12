package com.rest.app.exceptions;

public class NotEnoughAmountException extends Exception {



    private String message;

    public NotEnoughAmountException() {

    }

    public NotEnoughAmountException(String message) {
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
