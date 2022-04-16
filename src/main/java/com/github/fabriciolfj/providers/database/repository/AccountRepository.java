package com.github.fabriciolfj.providers.database.repository;

import com.github.fabriciolfj.providers.database.data.AccountData;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class AccountRepository implements PanacheRepository<AccountData> {

    public Optional<AccountData> findByCode(final String code) {
        return find("uuid", code)
                .firstResultOptional();
    }

    public Optional<AccountData> findAccountByLastExtract(final String code) {
        return find("Select c From AccountData c INNER JOIN FETCH c.extracts t where c.uuid = ?1 " +
                " and t.movimentDate = (select max(e.movimentDate) From ExtractData e INNER JOIN e.account z where z.uuid = ?1)", code)
                .firstResultOptional();
    }
}
