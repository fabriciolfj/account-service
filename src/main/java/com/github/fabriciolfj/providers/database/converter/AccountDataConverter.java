package com.github.fabriciolfj.providers.database.converter;

import com.github.fabriciolfj.entity.Account;
import com.github.fabriciolfj.providers.database.data.AccountData;
import com.github.fabriciolfj.providers.database.data.ExtractData;

import java.util.stream.Collectors;

public class AccountDataConverter {

    private AccountDataConverter() { }

    public static Account toEntity(final AccountData data) {
        return Account.builder()
                .createDate(data.getCreateDate())
                .customer(data.getCustomer())
                .overdraft(data.getOverdraft())
                .uuid(data.getUuid())
                .extracts(data
                        .getExtracts()
                        .stream()
                        .map(ExtractDataConverter::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static AccountData toData(final Account account) {
        final var data =  AccountData.builder()
                .createDate(account.getCreateDate())
                .customer(account.getCustomer())
                .overdraft(account.getOverdraft())
                .uuid(account.getUuid())
                .build();

        data.setExtracts(account.getExtracts().stream().map(c -> ExtractDataConverter.toData(c, data)).collect(Collectors.toList()));
        return data;
    }
}
