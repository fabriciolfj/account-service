package com.github.fabriciolfj.providers.database.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class AccountData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String customer;
    private BigDecimal overdraft;
    @Column(name = "create_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime createDate;
    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST)
    private List<ExtractData> extracts;

}
