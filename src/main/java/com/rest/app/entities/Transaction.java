package com.rest.app.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private Long accountNumber;

    private BigDecimal amount;

    private TransactionType transactionType;

    private String description;

    private Date date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Transaction() {

    }



    public Transaction(Long accountNumber, BigDecimal amount, TransactionType transactionType
            , String description, Date date, User user) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, amount, transactionType, description, date, user);
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(id, transaction.id) &&
                Objects.equals(accountNumber, transaction.accountNumber) &&
                Objects.equals(amount, transaction.amount) &&
                Objects.equals(transactionType, transaction.transactionType) &&
                Objects.equals(description, transaction.description) &&
                Objects.equals(date, transaction.date) &&
                Objects.equals(user, transaction.user);
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id= " + id +
                ", accountNumber= '" + accountNumber + '\'' +
                ", amount= '" + amount + '\'' +
                ", transactionType= '" + transactionType + '\'' +
                ", description= '" + description + '\'' +
                ", date= '" + date + '\'' +
                ", user= '" + user + '\'' +
                '}';

    }


}






















