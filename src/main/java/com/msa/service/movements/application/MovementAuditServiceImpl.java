package com.msa.service.movements.application;

import com.msa.service.movements.domain.enums.MovementAuditType;
import com.msa.service.movements.domain.model.MovementAudit;
import com.msa.service.movements.domain.ports.in.MovementAuditService;
import com.msa.service.movements.domain.ports.out.repositories.MovementAuditRepository;
import com.msa.service.movements.model.Movement;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class MovementAuditServiceImpl implements MovementAuditService {

    private final MovementAuditRepository movementAuditRepository;

    @Override
    public MovementAudit createMovementAudit(Movement movement) {
        MovementAudit movementAudit = new MovementAudit();
        movementAudit.setTypeMovement(movement.getTypeMovement());
        movementAudit.setAmount(BigDecimal.valueOf(movement.getAmount()));
        movementAudit.setAccountId(movement.getAccountId());
        movementAudit.setStatus(MovementAuditType.CREATED);
        movementAudit.setCreatedAt(LocalDateTime.now());

        return this.movementAuditRepository.saveMovementAudit(movementAudit);
    }

    @Override
    public MovementAudit updateMovementAudit(MovementAudit movementAudit) {
        if (movementAudit.getId() == null) {
            movementAudit.setStatus(MovementAuditType.REJECTED);
        } else {
            movementAudit.setStatus(MovementAuditType.PROCESSED);
        }
        movementAudit.setUpdatedAt(LocalDateTime.now());

        return this.movementAuditRepository.saveMovementAudit(movementAudit);
    }
}
