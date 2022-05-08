package com.github.fabriciolfj.utils;

import com.github.fabriciolfj.providers.message.dto.OverdraftMessage;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class OverdraftMessageDeserializer extends JsonbDeserializer<OverdraftMessage> {

    public OverdraftMessageDeserializer() {
        super(OverdraftMessage.class);
    }
}
