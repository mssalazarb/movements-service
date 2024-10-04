package com.msa.service.movements.infrastructure.entity;

import com.msa.service.movements.domain.enums.MovementAuditType;
import com.msa.service.movements.model.Movement;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movements_audit")
public class MovementAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_movement", nullable = false)
    private Movement.TypeMovementEnum typeMovement;

    private BigDecimal amount;
    private Long accountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MovementAuditType status;

    private String detail;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
