package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.business.command.DebitCommand;
import com.github.fabriciolfj.business.validations.ValidationOverdraft;
import com.github.fabriciolfj.business.validations.impl.ValidationNegativeBalanceGreaterOverdraft;
import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.exceptions.DomainException;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CreateDebit {

    private final ValidationOverdraft validationOverdraft;
    private final SaveExtract saveExtract;

    public Extract execute(final DebitCommand command) {
        var extract = command.debit();
        validationOverdraft.execute(command.getAccount(), extract);

        try {
            saveExtract.persistExtract(extract);
            return extract;
        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }
    }
}
