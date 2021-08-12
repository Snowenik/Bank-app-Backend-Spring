package com.rest.app.controllers;


import com.rest.app.entities.UserDTO;
import com.rest.app.exceptions.EmailAlreadyExistsException;
import com.rest.app.exceptions.IncorrectEmailFormatException;
import com.rest.app.services.DefaultRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegistrationController {


    @Autowired
    private DefaultRegistrationService registrationService;


    @PostMapping(path = "/user/create")
    public @ResponseBody String createNewUser(@RequestBody UserDTO userDTO) throws IncorrectEmailFormatException, EmailAlreadyExistsException {
        return registrationService.createNewAccount(userDTO);
    }






}





















