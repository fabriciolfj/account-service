package com.github.fabriciolfj.providers.http.converter;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.providers.http.dto.AccountOverdraftRequest;

public class AccountOverdraftConverter {

    private AccountOverdraftConverter() { }

    public static AccountOverdraftRequest toRequest(final Account account) {
        return AccountOverdraftRequest
                .builder()
                .account(account.getUuid())
                .balance(account.findExtractFirst().getBalance())
                .build();
    }
}
