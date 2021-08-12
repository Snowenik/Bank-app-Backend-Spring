package com.rest.app.entities;

import java.math.BigDecimal;

public class AccountTransactionDTO {


    private Long senderAccountNumber;

    private Long receiverAccountNumber;

    private BigDecimal amount;

    private String description;


    public Long getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public Long getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
