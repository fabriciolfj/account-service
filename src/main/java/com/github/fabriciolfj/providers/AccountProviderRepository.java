package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.FindAccountAndLastExtract;
import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.exceptions.DomainException;
import com.github.fabriciolfj.providers.database.converter.AccountDataConverter;
import com.github.fabriciolfj.providers.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@RequiredArgsConstructor
public class AccountProviderRepository implements SaveAccount, FindAccountAndLastExtract {

    private final AccountRepository accountRepository;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void persist(final Account account) {
        final var data = AccountDataConverter.toData(account);
        accountRepository.persist(data);
    }

    @Override
    public Account find(final String account) {
        return accountRepository.findAccountByLastExtract(account)
                .map(AccountDataConverter::toEntity)
                .orElseThrow(() -> new DomainException("Fail find account : " + account));
    }
}
