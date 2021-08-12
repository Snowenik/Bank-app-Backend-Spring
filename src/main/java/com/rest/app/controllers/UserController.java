package com.rest.app.controllers;


import com.rest.app.entities.*;
import com.rest.app.exceptions.*;
import com.rest.app.models.AuthenticationRequest;
import com.rest.app.models.AuthenticationResponse;
import com.rest.app.services.DefaultUserService;
import com.rest.app.services.MyUserDetailsService;
import com.rest.app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DefaultUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @Autowired
    private PasswordEncoder passwordEncoder;





    @GetMapping(path="/users/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path="/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(), authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Nieprawidlowy login lub haslo");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getLogin());


        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }


    @PostMapping(path = "/user/account/deposit")
    public @ResponseBody User accountManageDeposit(@RequestBody AccountDepositDTO accountDepositDTO) throws UserDoesntExistException, InvalidAmountException {
        return userService.accountManageDeposit(accountDepositDTO.getLogin(), accountDepositDTO.getAmount());
    }


    @PostMapping(path = "/user/account/withdraw")
    public @ResponseBody User accountManageWithdraw(@RequestBody AccountWithdrawDTO accountWithdrawDTO) throws UserDoesntExistException, NotEnoughAmountException, InvalidAmountException {
        return userService.accountManageWithdraw(accountWithdrawDTO.getLogin(), accountWithdrawDTO.getAmount());
    }

    @PostMapping(path = "/user/account/transaction")
    public @ResponseBody User accountTransaction(@RequestBody AccountTransactionDTO accountTransactionDTO) throws UserDoesntExistException, NotEnoughAmountException, InvalidAmountException {
        return userService.accountTransaction(accountTransactionDTO.getSenderAccountNumber(), accountTransactionDTO.getReceiverAccountNumber(), accountTransactionDTO.getAmount(), accountTransactionDTO.getDescription());
    }


    @PostMapping(path = "/user/account/transaction/list")
    public @ResponseBody List<Transaction> getTransactionList(@RequestBody AccountTransactionListDTO accountTransactionListDTO) throws UserDoesntExistException {
        return userService.getTransactionList(accountTransactionListDTO.getLogin());
    }


    @PostMapping(path = "/user/settings/change/password")
    public @ResponseBody User settingsChangePassword(@RequestBody ChangePasswordDTO changePasswordDTO) throws UserDoesntExistException, InvalidPasswordException, PasswordsDontMatchException {
        return userService.settingsChangePassword(changePasswordDTO.getLogin(), changePasswordDTO.getOldPassword(), changePasswordDTO.getPassword(), changePasswordDTO.getRepeatedPassword());
    }


    @PostMapping(path = "/user/settings/change/email")
    public @ResponseBody User settingsChangeEmail(@RequestBody ChangeEmailDTO changeEmailDTO) throws UserDoesntExistException {
        return userService.settingsChangeEmail(changeEmailDTO.getLogin(), changeEmailDTO.getEmail());
    }
}















