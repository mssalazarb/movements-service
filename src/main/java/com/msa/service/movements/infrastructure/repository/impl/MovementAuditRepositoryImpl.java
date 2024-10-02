package com.msa.service.movements.infrastructure.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.movements.domain.model.MovementAudit;
import com.msa.service.movements.domain.ports.out.MovementAuditRepository;
import com.msa.service.movements.infrastructure.entity.MovementAuditEntity;
import com.msa.service.movements.infrastructure.repository.JpaMovementAuditRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovementAuditRepositoryImpl implements MovementAuditRepository {

    private final JpaMovementAuditRepository jpaMovementAuditRepository;
    private final ObjectMapper mapper;

    @Override
    public MovementAudit saveMovementAudit(MovementAudit movementAudit) {
        MovementAuditEntity entity = mapper.convertValue(movementAudit, MovementAuditEntity.class);
        MovementAuditEntity savedMovementAudit = this.jpaMovementAuditRepository
                .save(entity);

        return mapper.convertValue(savedMovementAudit, MovementAudit.class);
    }
}
