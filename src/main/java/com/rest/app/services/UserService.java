package com.rest.app.services;


import com.rest.app.entities.Transaction;
import com.rest.app.entities.User;
import com.rest.app.exceptions.*;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    User accountManageDeposit(String login, BigDecimal amount) throws UserDoesntExistException, InvalidAmountException;
    User accountManageWithdraw(String login, BigDecimal amount) throws UserDoesntExistException, NotEnoughAmountException, InvalidAmountException;
    User accountTransaction(Long senderAccountNumber, Long receiverAccountNumber, BigDecimal amount, String description) throws UserDoesntExistException, NotEnoughAmountException, InvalidAmountException;
    List<Transaction> getTransactionList(String login) throws UserDoesntExistException;
    User settingsChangePassword(String login, String oldPassword, String password, String repeatedPassword) throws UserDoesntExistException, InvalidPasswordException, PasswordsDontMatchException;
    User settingsChangeEmail(String login, String email) throws UserDoesntExistException;

}
