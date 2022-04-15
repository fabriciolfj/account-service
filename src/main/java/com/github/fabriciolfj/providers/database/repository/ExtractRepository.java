package com.github.fabriciolfj.providers.database.repository;

import com.github.fabriciolfj.providers.database.data.ExtractData;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class ExtractRepository implements PanacheRepository<ExtractData> {

    public Optional<ExtractData> findLastExtract(final String account) {
        return find("Select e from Extract e where e.account = ?1 and e.moviment_date = " +
                "(select max(i.moviment_date) from Extract where i.account = ?1)", account)
                .firstResultOptional();
    }
}
