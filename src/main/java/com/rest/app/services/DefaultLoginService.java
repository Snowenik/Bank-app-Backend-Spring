package com.rest.app.services;


import com.rest.app.entities.User;
import com.rest.app.entities.UserLoginDTO;
import com.rest.app.entities.UserRepository;
import com.rest.app.exceptions.IncorrectLoginOrPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultLoginService implements LoginService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public User login(UserLoginDTO userLoginDTO) throws IncorrectLoginOrPasswordException {
        if (!isLoginAndPasswordCorrect(userLoginDTO.getLogin(), userLoginDTO.getPassword())) {
            throw new IncorrectLoginOrPasswordException("Niepoprawny login lub haslo");
        }
        return userRepository.findByLogin(userLoginDTO.getLogin());
    }

    public boolean isLoginAndPasswordCorrect(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }




}














