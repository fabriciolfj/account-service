package com.github.fabriciolfj.business.command;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entity.TypeOperation;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;




@AllArgsConstructor
public class CreditCommand {

    private Account account;
    private BigDecimal value;

    private CreditCommand() {}

    public Extract credit() {
        return Extract.execute(value, TypeOperation.CREDIT, account.findExtractFirst().getBalance(), account);
    }

}
