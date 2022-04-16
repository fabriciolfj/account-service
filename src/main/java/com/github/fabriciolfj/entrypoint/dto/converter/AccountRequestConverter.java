package com.github.fabriciolfj.entrypoint.dto.converter;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entrypoint.dto.request.AccountRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class AccountRequestConverter {

    private AccountRequestConverter() { }

    public static Account toEntity(final AccountRequest request) {
        final var account =  Account
                .builder()
                .uuid(UUID.randomUUID().toString())
                .overdraft(BigDecimal.ZERO)
                .customer(request.getCustomer())
                .createDate(LocalDateTime.now())
                .build();

        return account.init(request.getValue());
    }
}
