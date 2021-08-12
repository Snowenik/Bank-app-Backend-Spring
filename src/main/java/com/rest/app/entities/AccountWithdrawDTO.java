package com.rest.app.entities;

import java.math.BigDecimal;

public class AccountWithdrawDTO {


    private String login;

    private BigDecimal amount;


    public String getLogin() {
        return login;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
