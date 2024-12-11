package com.mps.report_generator.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "transactions")
public class TransactionModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private UUID id;

    @Column(name = "seller", nullable = false)
    private String seller;

    @Column(name = "buyer", nullable = false)
    private String buyer;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
}
