package com.github.fabriciolfj.providers.message;

import com.github.fabriciolfj.business.usecase.UpdateOverdraftAccount;
import com.github.fabriciolfj.providers.message.dto.OverdraftMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class OverdraftProvider {

    private final UpdateOverdraftAccount updateOverdraftAccount;

    @Incoming("overdraft")
    @Transactional(Transactional.TxType.REQUIRED)
    public void consumer(final OverdraftMessage overdraftMessage) {
        log.info(overdraftMessage.toString());

        updateOverdraftAccount.execute(overdraftMessage.getAccount(), overdraftMessage.getValue());
    }
}
