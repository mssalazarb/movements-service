package com.msa.service.movements.infrastructure.adapter.out.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "movements")
public class MovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeMovement;
    private BigDecimal amount;
    private Integer accountId;
}
