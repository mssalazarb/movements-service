package com.msa.service.movements.infrastructure.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.movements.domain.ports.out.MovementRepository;
import com.msa.service.movements.infrastructure.entity.MovementEntity;
import com.msa.service.movements.infrastructure.repository.JpaMovementRepository;
import com.msa.service.movements.model.Movement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovementRepositoryImpl implements MovementRepository {
    private final JpaMovementRepository jpaMovementRepository;
    private final ObjectMapper mapper;

    @Override
    public Movement saveMovement(Movement movement) {
        MovementEntity movementEntity = this.jpaMovementRepository.save(mapper.convertValue(movement, MovementEntity.class));

        return mapper.convertValue(movementEntity, Movement.class);
    }
}
