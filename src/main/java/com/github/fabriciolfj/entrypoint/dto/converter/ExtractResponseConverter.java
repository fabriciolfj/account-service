package com.github.fabriciolfj.entrypoint.dto.converter;

import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.entrypoint.dto.response.ExtractResponse;

public class ExtractResponseConverter {

    private ExtractResponseConverter() {

    }

    public static final ExtractResponse toResponse(final Extract extract) {
        return ExtractResponse
                .builder()
                .balance(extract.getBalance())
                .credit(extract.getCredit())
                .date(extract.getDate())
                .debit(extract.getDebit())
                .description(extract.getDescription())
                .build();
    }
}
