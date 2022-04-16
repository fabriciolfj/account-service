package com.github.fabriciolfj.business.command;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entity.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class DebitCommand {

    private Account account;
    private BigDecimal value;

    private DebitCommand() {}

    public Extract debit() {
        return Extract.execute(value, TypeOperation.CREDIT, account.findExtractFirst().getBalance(), account);
    }
}
