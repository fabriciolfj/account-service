package com.github.fabriciolfj.providers.database.converter;

import com.github.fabriciolfj.entity.Extract;
import com.github.fabriciolfj.providers.database.data.AccountData;
import com.github.fabriciolfj.providers.database.data.ExtractData;

import java.util.UUID;

public class ExtractDataConverter {

    private ExtractDataConverter() { }

    public static Extract toEntity(final ExtractData data) {
        return Extract.builder()
                .date(data.getMovimentDate())
                .description(data.getDescription())
                .balance(data.getBalance())
                .credit(data.getCredit())
                .debit(data.getDebit())
                .uuid(data.getUuid())
                .build();
    }

    public static ExtractData toData(final Extract extract, final AccountData accountData) {
        return ExtractData
                .builder()
                .uuid(UUID.randomUUID().toString())
                .account(accountData)
                .balance(extract.getBalance())
                .credit(extract.getCredit())
                .debit(extract.getDebit())
                .description(extract.getDescription())
                .uuid(extract.getUuid())
                .movimentDate(extract.getDate())
                .build();
    }
}
