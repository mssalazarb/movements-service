package com.msa.service.movements.infrastructure.repository;

import com.msa.service.movements.infrastructure.entity.MovementAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovementAuditRepository extends JpaRepository<MovementAuditEntity, Long> {
}
