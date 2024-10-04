package com.msa.service.movements.infrastructure.repositories.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.movements.domain.ports.out.repositories.MovementRepository;
import com.msa.service.movements.infrastructure.entity.MovementEntity;
import com.msa.service.movements.infrastructure.repositories.JpaMovementRepository;
import com.msa.service.movements.model.Movement;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MovementRepositoryImpl implements MovementRepository {
    private final JpaMovementRepository jpaMovementRepository;
    private final ObjectMapper mapper;

    @Override
    public Movement saveMovement(Movement movement) {
        MovementEntity movementEntity = this.jpaMovementRepository.save(mapper.convertValue(movement, MovementEntity.class));

        return mapper.convertValue(movementEntity, Movement.class);
    }

    @Override
    public List<Movement> findAllMovementsByAccountId(Long accountId) {
        List<MovementEntity> movements = this.jpaMovementRepository.findAllByAccountId(accountId);

        return movements.stream().map(movementEntity -> mapper.convertValue(movementEntity, Movement.class)).toList();
    }
}
