package com.mps.data_producer.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TransactionModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String seller;
    private String buyer;
    private BigDecimal amount;
    private LocalDateTime creationDate;
}
