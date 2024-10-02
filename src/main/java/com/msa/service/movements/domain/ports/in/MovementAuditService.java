package com.msa.service.movements.domain.ports.in;

import com.msa.service.movements.domain.model.MovementAudit;
import com.msa.service.movements.model.Movement;

public interface MovementAuditService {
    MovementAudit createMovementAudit(Movement movement);

    MovementAudit updateMovementAudit(MovementAudit movementAudit);
}
