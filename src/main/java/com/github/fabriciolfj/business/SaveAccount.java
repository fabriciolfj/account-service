package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Account;

public interface SaveAccount {

    Account persist(final Account account);
}
