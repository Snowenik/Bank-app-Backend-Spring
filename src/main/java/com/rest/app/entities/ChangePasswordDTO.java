package com.rest.app.entities;



public class ChangePasswordDTO {


    private String login;

    private String oldPassword;

    private String password;

    private String repeatedPassword;


    public String getOldPassword() {
        return oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public String getLogin() {
        return login;
    }

}
