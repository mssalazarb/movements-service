package com.msa.service.movements.domain.ports.out.repositories;

import com.msa.service.movements.model.Movement;

import java.util.List;

public interface MovementRepository {
    Movement saveMovement(Movement movement);

    List<Movement> findAllMovementsByAccountId(Long accountId);
}
