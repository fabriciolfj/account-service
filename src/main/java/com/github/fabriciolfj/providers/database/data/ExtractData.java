package com.github.fabriciolfj.providers.database.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "extract")
public class ExtractData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private BigDecimal credit;
    private BigDecimal debit;
    private BigDecimal balance;
    private String description;
    @Column(name = "moviment_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime movimentDate;
    @ManyToOne
    private AccountData account;
}
