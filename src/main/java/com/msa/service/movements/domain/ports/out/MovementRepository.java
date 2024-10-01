package com.msa.service.movements.domain.ports.out;

import com.msa.service.movements.model.Movement;

public interface MovementRepository {
    Movement saveMovement(Movement movement);
}
