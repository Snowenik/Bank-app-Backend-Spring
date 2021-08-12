package com.rest.app.controllers;


import com.rest.app.entities.User;
import com.rest.app.entities.UserLoginDTO;
import com.rest.app.exceptions.IncorrectLoginOrPasswordException;
import com.rest.app.services.DefaultLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @Autowired
    private DefaultLoginService loginService;

    @PostMapping(path = "/user/login")
    public @ResponseBody User login(@RequestBody UserLoginDTO userLoginDTO) throws IncorrectLoginOrPasswordException {
        return loginService.login(userLoginDTO);
    }







}





















