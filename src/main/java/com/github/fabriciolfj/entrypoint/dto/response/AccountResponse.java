package com.github.fabriciolfj.entrypoint.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

    private String uuid;
    private String customer;
    private LocalDateTime createDate;
    private BigDecimal overdraft;
    private BigDecimal balance;
}
