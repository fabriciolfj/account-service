package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.FindOverdraft;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.providers.http.client.LimitClient;
import com.github.fabriciolfj.providers.http.converter.AccountOverdraftConverter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
public class OverdraftProvider implements FindOverdraft {

    @RestClient
    @Inject
    private LimitClient limitClient;

    @Override
    public Account getOverdraft(final Account account) {
        final var response = limitClient.find(AccountOverdraftConverter.toRequest(account));
        log.info("Return overdraft: {}", response);

        return account.addOverdraft(response.getOverdraft());
    }
}
