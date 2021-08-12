package com.rest.app.exceptions;

public class IncorrectEmailFormatResponse {


    private String error;


    public IncorrectEmailFormatResponse() {

    }

    public IncorrectEmailFormatResponse(String error) {
        this.error = error;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
