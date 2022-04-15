package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.providers.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@RequiredArgsConstructor
public class AccountProviderRepository implements SaveAccount {

    private final AccountRepository accountRepository;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Account persist(Account account) {
        return null;
    }
}
