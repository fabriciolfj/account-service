package com.github.fabriciolfj.entrypoint.dto.converter;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entrypoint.dto.response.AccountResponse;

public class AccountResponseConverter {

    private AccountResponseConverter() { }

    public static AccountResponse toResponse(final Account account) {
        return AccountResponse.builder()
                .balance(account.findExtractFirst().getBalance())
                .createDate(account.getCreateDate())
                .customer(account.getCustomer())
                .uuid(account.getUuid())
                .overdraft(account.getOverdraft())
                .build();
    }
}
