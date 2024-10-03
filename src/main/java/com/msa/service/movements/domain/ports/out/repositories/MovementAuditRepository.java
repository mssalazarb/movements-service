package com.msa.service.movements.domain.ports.out.repositories;

import com.msa.service.movements.domain.model.MovementAudit;

public interface MovementAuditRepository {
    MovementAudit saveMovementAudit(MovementAudit movementAudit);
}
