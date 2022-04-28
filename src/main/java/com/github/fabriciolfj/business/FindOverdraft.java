package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entity.Account;

public interface FindOverdraft {

    Account getOverdraft(final Account account);
}
