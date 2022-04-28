package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.CreateLimitWithdraw;
import com.github.fabriciolfj.business.FindOverdraft;
import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.exceptions.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CreateAccount {

    private final SaveAccount saveAccount;
    private final FindOverdraft findOverdraft;
    private final CreateLimitWithdraw createLimitWithdraw;

    public Account execute(final Account account) {
        try {
            var result = findOverdraft.getOverdraft(account);
            saveAccount.persist(result);
            createLimitWithdraw.execute(account);

            log.info("Account save: {}", account.getUuid());
            return account;
        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }
    }
}
