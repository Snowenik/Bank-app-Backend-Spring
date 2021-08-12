package com.rest.app.exceptions;

public class EmailAlreadyExistsResponse {


    private String error;


    public EmailAlreadyExistsResponse() {

    }

    public EmailAlreadyExistsResponse(String error) {
        this.error = error;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
