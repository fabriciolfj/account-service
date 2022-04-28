package com.github.fabriciolfj.providers.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountOverdraftRequest {

    private String account;
    private BigDecimal balance;
}
