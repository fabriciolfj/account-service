package com.github.fabriciolfj.providers.message;

import com.github.fabriciolfj.providers.message.dto.OverdraftMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
@RequiredArgsConstructor
public class OverdraftProvider {

    @Incoming("overdraft")
    public void consumer(final OverdraftMessage overdraftMessage) {
        log.info(overdraftMessage.toString());
    }
}
