package com.github.fabriciolfj.business.validations;

import com.github.fabriciolfj.entity.Account;

import java.math.BigDecimal;

public interface UpdateAccount {

    void updateOverdraft(final String account, final BigDecimal overdraft);
}
