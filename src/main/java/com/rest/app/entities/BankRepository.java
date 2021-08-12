package com.rest.app.entities;


import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Long> {

    Bank findByName(String name);

}
