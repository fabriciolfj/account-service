package com.github.fabriciolfj.providers.message.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class OverdraftMessage {

    private String account;
    private BigDecimal value;
}
