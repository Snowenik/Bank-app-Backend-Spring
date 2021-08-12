package com.rest.app.entities;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);
    User findByEmail(String email);
    User findByAccountNumber(Long accountNumber);
}

