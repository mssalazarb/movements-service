package com.msa.service.movements.domain.ports.in;

import com.msa.service.movements.model.AccountMovement;
import com.msa.service.movements.model.Movement;

public interface MovementService {
    AccountMovement createMovement(Movement movement);
}
