package com.rest.app.handlers;


import com.rest.app.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler(IncorrectEmailFormatException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public IncorrectEmailFormatResponse handleEmailFormatException(IncorrectEmailFormatException e) {
        return new IncorrectEmailFormatResponse(e.getMessage());
    }


    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
        System.out.println("Wysylam wyjatek");
        return new ExceptionResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(IncorrectLoginOrPasswordException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleIncorrectLoginOrPasswordException(IncorrectLoginOrPasswordException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UserDoesntExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleUserDoesntExistException(UserDoesntExistException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(NotEnoughAmountException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ExceptionResponse handleNotEnoughAmountException(NotEnoughAmountException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(InvalidAmountException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ExceptionResponse handleInvalidAmountException(InvalidAmountException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ExceptionResponse handleInvalidPasswordException(InvalidPasswordException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(PasswordsDontMatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ExceptionResponse handlePasswordsDontMatchException(PasswordsDontMatchException e) {
        return new ExceptionResponse(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}



















