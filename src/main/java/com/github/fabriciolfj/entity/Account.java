package com.github.fabriciolfj.entity;

import com.github.fabriciolfj.exceptions.DomainException;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
public class Account {

    @EqualsAndHashCode.Include
    private String uuid;
    private String customer;
    private LocalDateTime createDate;
    private BigDecimal overdraft;
    private List<Extract> extracts;

    public Account init(final BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new DomainException("Value invalid to create account: " + value);
        }

        if (Objects.isNull(extracts)) {
            this.extracts = new ArrayList<>();
        }

        this.extracts.add(Extract.execute(value, TypeOperation.CREDIT, BigDecimal.ZERO, this));
        return this;
    }

    public Extract findExtractFirst() {
        if (Objects.nonNull(extracts) && !extracts.isEmpty()) {
            var extract = extracts.stream()
                    .max(Comparator.comparing(Extract::getDate));

            if (!extract.isPresent()) {
                throw new DomainException("Extract not found to account: " + uuid);
            }

            return extract.get();
        }

        throw new DomainException("Extracts is null to account: " + uuid);
    }

    public Account addOverdraft(final BigDecimal value) {
        overdraft = value;
        return this;
    }
}
