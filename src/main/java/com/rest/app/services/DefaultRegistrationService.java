package com.rest.app.services;

import com.rest.app.entities.*;
import com.rest.app.exceptions.EmailAlreadyExistsException;
import com.rest.app.exceptions.IncorrectEmailFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class DefaultRegistrationService implements RegistrationService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BankRepository bankRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String createNewAccount(UserDTO userDTO) throws IncorrectEmailFormatException, EmailAlreadyExistsException {
        if (checkIfUserExists(userDTO.getEmail(), userDTO.getLogin())) {
            System.out.println("Rzucam wyjatek");
            throw new EmailAlreadyExistsException("Podany email lub login jest juz zajety");
        }
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String login = userDTO.getLogin();
        String password = passwordEncoder.encode(userDTO.getPassword());
        String email = userDTO.getEmail();
        Long accountNumber = generateAccountNumber();
        BigDecimal amount = new BigDecimal(0);
        List<Transaction> transactions = new ArrayList<>();
        List<Transfer> transfers = new ArrayList<>();
        Bank bank = bankRepository.findByName("Prometheus");


        User user = new User(login, password, firstName, lastName, email, accountNumber,
                amount, bank, transactions, transfers);

        userRepository.save(user);
        return "Hello";
    }








    private Long generateAccountNumber() {
        Random random = new Random();
        Long start = 50000000000L;
        Long end = 500000000000L;
        Long accountNumber = start + ((long)(random.nextDouble() * (end - start)));
        while (userRepository.findByAccountNumber(accountNumber) != null) {
            accountNumber = start + ((long)(random.nextDouble() * (end - start)));
        }
        return accountNumber;
    }


    public boolean checkIfUserExists(String email, String login) {
        return (userRepository.findByEmail(email) != null) || (userRepository.findByLogin(login) != null);
    }





}






















