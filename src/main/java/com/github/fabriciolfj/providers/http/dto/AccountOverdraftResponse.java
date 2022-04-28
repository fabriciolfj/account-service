package com.github.fabriciolfj.providers.http.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountOverdraftResponse {

    private String account;
    private BigDecimal overdraft;
}
