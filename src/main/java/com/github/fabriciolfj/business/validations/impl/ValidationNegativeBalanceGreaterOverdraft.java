package com.github.fabriciolfj.business.validations.impl;

import com.github.fabriciolfj.business.validations.ValidationOverdraft;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.exceptions.DomainException;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class ValidationNegativeBalanceGreaterOverdraft implements ValidationOverdraft {

    @Override
    public void execute(final Account account, final Extract extract) {
        if (account.getOverdraft().compareTo(BigDecimal.ZERO) == 0) {
            return;
        }

        if (extract.isBalanceNegative() && extract.getBalancePositive().compareTo(account.getOverdraft()) < 0) {
            throw new DomainException("Overdraft all limit used: " + extract.getBalance());
        };
    }
}
