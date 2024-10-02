package com.msa.service.movements.infrastructure.repository;

import com.msa.service.movements.infrastructure.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovementRepository extends JpaRepository<MovementEntity, Long > {
}
