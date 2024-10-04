package com.msa.service.movements.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String numberAccount;
    private String currencyType;
    private BigDecimal amount;
    private Long customerId;
}
