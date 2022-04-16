package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindAccountAndLastExtract;
import com.github.fabriciolfj.entity.Account;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class FindAccount {

    private final FindAccountAndLastExtract getAccount;

    public Account execute(final String uuid) {
        return getAccount.find(uuid);
    }
}
