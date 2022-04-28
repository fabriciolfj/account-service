package com.github.fabriciolfj.providers.message.converter;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.providers.message.dto.AccountLimitWithdrawMessage;

public class AccountLimitWithdrawConverter {

    private AccountLimitWithdrawConverter() { }

    public static AccountLimitWithdrawMessage toMessage(final Account account) {
        return AccountLimitWithdrawMessage
                .builder()
                .balance(account.findExtractFirst().getBalance())
                .account(account.getUuid())
                .build();
    }
}
