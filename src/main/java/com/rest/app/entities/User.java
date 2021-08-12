package com.rest.app.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;



@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String login;

    private String password;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;


    @Column(unique = true)
    private Long accountNumber;

    private BigDecimal amount;


    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaction> transactions;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;


    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transfer> transfers;




    public User() {}

    public User(String login, String password, String firstName, String surname, String email
            , Long accountNumber, BigDecimal amount, Bank bank, List<Transaction> transactions, List<Transfer> transfers) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = surname;
        this.email = email;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactions = transactions;
        this.transfers = transfers;
        this.bank = bank;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, lastName, email, accountNumber, amount, transactions, bank, transfers);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(accountNumber, user.accountNumber) &&
                Objects.equals(amount, user.amount) &&
                Objects.equals(transactions, user.transactions) &&
                Objects.equals(bank, user.bank) &&
                Objects.equals(transfers, user.transfers);
    }

    @Override
    public String toString() {
        return "User{" +
                "id= " + id +
                ", firstName= '" + firstName + '\'' +
                ", lastName= '" + lastName + '\'' +
                ", login= '" + login + '\'' +
                ", password= '" + password + '\'' +
                ", email= '" + email + '\'' +
                ", accountNumber= '" + accountNumber + '\'' +
                ", amount= '" + amount + '\'' +
                ", transactions= '" + transactions + '\'' +
                ", bank= '" + bank + '\'' +
                ", transfers= '" + transfers + '\'' +
                '}';

    }
}


















