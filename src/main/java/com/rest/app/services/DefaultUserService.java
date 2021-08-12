package com.rest.app.services;


import com.rest.app.entities.*;
import com.rest.app.exceptions.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class DefaultUserService implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private TransferRepository transferRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User accountManageDeposit(String login, BigDecimal amount) throws UserDoesntExistException, InvalidAmountException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserDoesntExistException("Podany user nie istnieje");
        }
        if (amount.compareTo(new BigDecimal(0)) <= 0) {
            throw new InvalidAmountException("Podano niepoprawna kwote");
        }
        BigDecimal userAmount = user.getAmount();
        BigDecimal newAmount = userAmount.add(amount);
        user.setAmount(newAmount);
        Hibernate.initialize(user.getTransfers());
        Transfer transfer = new Transfer(amount, TransferType.DEPOSIT, user.getAccountNumber(), new Date(), user);
        transferRepository.save(transfer);
        user.getTransfers().add(transfer);
        return user;
    }


    @Override
    public User accountManageWithdraw(String login, BigDecimal amount) throws UserDoesntExistException, NotEnoughAmountException, InvalidAmountException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserDoesntExistException("Podany user nie istnieje");
        }
        if (amount.compareTo(new BigDecimal(0)) <= 0) {
            throw new InvalidAmountException("Podano niepoprawna kwote");
        }
        BigDecimal userAmount = user.getAmount();
        BigDecimal newAmount = userAmount.subtract(amount);
        if (newAmount.compareTo(new BigDecimal(0)) < 0) {
            throw new NotEnoughAmountException("Nie posiadasz tylu srodkow");
        }
        user.setAmount(newAmount);
        Hibernate.initialize(user.getTransfers());
        Transfer transfer = new Transfer(amount, TransferType.WITHDRAW, user.getAccountNumber(), new Date(), user);
        transferRepository.save(transfer);
        user.getTransfers().add(transfer);
        return user;
    }


    @Override
    public User accountTransaction(Long senderAccountNumber, Long receiverAccountNumber, BigDecimal amount, String description) throws UserDoesntExistException, NotEnoughAmountException, InvalidAmountException {
        User sender = userRepository.findByAccountNumber(senderAccountNumber);
        User receiver = userRepository.findByAccountNumber(receiverAccountNumber);
        if (receiver == null || sender == null) {
            throw new UserDoesntExistException("Podany user nie istnieje");
        }
        if (amount.compareTo(new BigDecimal(0)) <= 0) {
            throw new InvalidAmountException("Podano niepoprawna kwote");
        }
        if (sender.getAmount().compareTo(amount) < 0) {
            throw new NotEnoughAmountException("Nie posiadasz tylu srodkow");
        }
        sender.setAmount(sender.getAmount().subtract(amount));
        BigDecimal newAmount = receiver.getAmount().add(amount);
        receiver.setAmount(newAmount);
        Hibernate.initialize(sender.getTransactions());
        Hibernate.initialize(receiver.getTransactions());
        Transaction senderTransaction = new Transaction(receiver.getAccountNumber(), amount, TransactionType.OUT, description, new Date(), sender);
        Transaction receiverTransaction = new Transaction(sender.getAccountNumber(), amount, TransactionType.IN, description, new Date(), receiver);
        transactionRepository.save(senderTransaction);
        transactionRepository.save(receiverTransaction);
        sender.getTransactions().add(senderTransaction);
        receiver.getTransactions().add(receiverTransaction);
        return sender;
    }



    @Override
    public List<Transaction> getTransactionList(String login) throws UserDoesntExistException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserDoesntExistException("Podany user nie istnieje");
        }
        return user.getTransactions();
    }


    @Override
    public User settingsChangePassword(String login, String oldPassword, String password, String repeatedPassword) throws UserDoesntExistException, InvalidPasswordException, PasswordsDontMatchException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserDoesntExistException("Podany user nie istnieje");
        }
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new InvalidPasswordException("Podano niepoprawne haslo");
        }
        if (!password.equals(repeatedPassword)) {
            throw new PasswordsDontMatchException("Podane hasla nie sa identyczne");
        }
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return user;
    }


    @Override
    public User settingsChangeEmail(String login, String email) throws UserDoesntExistException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserDoesntExistException("Podany user nie istnieje");
        }
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }
}





















