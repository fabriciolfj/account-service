package com.github.fabriciolfj.business.validations;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.entity.Extract;

public interface ValidationOverdraft {

    void execute(final Account account, final Extract extract);
}
