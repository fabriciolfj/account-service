package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Account;

public interface CreateLimitWithdraw {

    void execute(final Account account);
}
