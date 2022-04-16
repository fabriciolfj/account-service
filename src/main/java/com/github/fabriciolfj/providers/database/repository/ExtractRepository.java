package com.github.fabriciolfj.providers.database.repository;

import com.github.fabriciolfj.providers.database.data.ExtractData;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class ExtractRepository implements PanacheRepository<ExtractData> {

    public Optional<ExtractData> findLastExtract(final String account) {
        return find("Select e from Extract e  INNER JOIN e.account a where a.uuid = ?1 and e.movimentDate = " +
                "(select max(i.movimentDate) from Extract INNER JOIN i.account z where z.uuid = ?1)", account)
                .firstResultOptional();
    }
}
