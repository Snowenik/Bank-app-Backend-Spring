package com.rest.app.services;


import com.rest.app.entities.UserDTO;
import com.rest.app.exceptions.EmailAlreadyExistsException;
import com.rest.app.exceptions.IncorrectEmailFormatException;

public interface RegistrationService {

    String createNewAccount(UserDTO userDTO) throws IncorrectEmailFormatException, EmailAlreadyExistsException;

}
