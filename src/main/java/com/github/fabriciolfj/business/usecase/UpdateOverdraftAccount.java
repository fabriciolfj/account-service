package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.validations.UpdateAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class UpdateOverdraftAccount {

    private final FindAccount findAccount;
    private final UpdateAccount updateAccount;

    public void execute(final String account, final BigDecimal value) {
        log.info("Updating account {}, to overdraft {}", account, value);
        updateAccount.updateOverdraft(account, value);
    }
}
