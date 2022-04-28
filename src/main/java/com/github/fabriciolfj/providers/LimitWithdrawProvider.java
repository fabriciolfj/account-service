package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.CreateLimitWithdraw;
import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.providers.message.converter.AccountLimitWithdrawConverter;
import com.github.fabriciolfj.providers.message.dto.AccountLimitWithdrawMessage;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
public class LimitWithdrawProvider implements CreateLimitWithdraw {

    @Channel("limit-withdraw")
    @Inject
    private Emitter<AccountLimitWithdrawMessage> emitter;

    @Override
    public void execute(final Account account) {
        final var msg = AccountLimitWithdrawConverter.toMessage(account);

        emitter.send(msg);
        log.info("Send sucess msg to limit withdraw: {}", msg);
    }
}
