package com.github.fabriciolfj.providers.database.repository;

import com.github.fabriciolfj.providers.database.data.AccountData;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class AccountRepository implements PanacheRepository<AccountData> {

    public Optional<AccountData> findByCode(final String code) {
        return find("uuid", code)
                .firstResultOptional();
    }
}
