package com.rest.app.services;


import com.rest.app.entities.User;
import com.rest.app.entities.UserLoginDTO;
import com.rest.app.exceptions.IncorrectLoginOrPasswordException;

public interface LoginService {


    User login(UserLoginDTO userLoginDTO) throws IncorrectLoginOrPasswordException;



}
