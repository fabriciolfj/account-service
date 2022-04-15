package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.business.command.CreditCommand;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.exceptions.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CreateCredit {

    private final SaveExtract saveExtract;

    public Extract execute(final CreditCommand command) {
        var extract = command.credit();

        try {
            saveExtract.persistExtract(extract);
            return extract;
        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }
    }
}
