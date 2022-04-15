package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindAccountAndLastExtract;
import com.github.fabriciolfj.business.command.DebitCommand;
import com.github.fabriciolfj.entity.Extract;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
@RequiredArgsConstructor
public class ProcessExtractDebit {

    private final FindAccountAndLastExtract findAccount;
    private final CreateDebit createDebit;

    public Extract execute(final BigDecimal value, final String uuid) {
        var account = findAccount.find(uuid);
        var command = DebitCommand.builder()
                .account(account)
                .value(value)
                .build();

        return createDebit.execute(command);
    }
}
