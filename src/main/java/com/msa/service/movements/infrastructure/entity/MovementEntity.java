package com.msa.service.movements.infrastructure.entity;

import com.msa.service.movements.model.Movement;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type_movement", nullable = false)
    private Movement.TypeMovementEnum typeMovement;

    private BigDecimal amount;
    private Long accountId;
}
