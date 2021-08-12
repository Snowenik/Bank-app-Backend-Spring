package com.rest.app.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue
    private Long id;


    private BigDecimal amount;

    private TransferType transferType;

    private Long accountNumber;

    private Date date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    public Transfer() {


    }



    public Transfer(BigDecimal amount, TransferType transferType
            , Long accountNumber, Date date, User user) {
        this.amount = amount;
        this.transferType = transferType;
        this.accountNumber = accountNumber;
        this.date = date;
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
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
        return Objects.hash(id, amount, transferType, accountNumber, date, user);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transfer transfer = (Transfer) o;
        return Objects.equals(id, transfer.id) &&
                Objects.equals(amount, transfer.amount) &&
                Objects.equals(transferType, transfer.transferType) &&
                Objects.equals(accountNumber, transfer.accountNumber) &&
                Objects.equals(date, transfer.date) &&
                Objects.equals(user, transfer.user);
    }


    @Override
    public String toString() {
        return "Transfer{" +
                "id= " + id +
                ", amount= '" + amount + '\'' +
                ", transferType= '" + transferType + '\'' +
                ", accountNumber= '" + accountNumber + '\'' +
                ", date= '" + date + '\'' +
                ", user= '" + user + '\'' +
                '}';

    }


}


















