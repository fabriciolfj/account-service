package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Account;

public interface SaveAccount {

    void persist(final Account account);
}
