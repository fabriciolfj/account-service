package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindAccountAndLastExtract;
import com.github.fabriciolfj.business.command.CreditCommand;
import com.github.fabriciolfj.entity.Extract;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
@RequiredArgsConstructor
public class ProcessExtractCredit {

    private final FindAccountAndLastExtract findAccount;
    private final CreateCredit createCredit;

    public Extract execute(final BigDecimal value, final String uuid) {
        var account = findAccount.find(uuid);
        var command = new CreditCommand(account, value);

        return createCredit.execute(command);
    }
}
