package com.msa.service.movements.infrastructure.adapter.out.repository;

import com.msa.service.movements.infrastructure.adapter.out.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovementRepository extends JpaRepository<MovementEntity, Long > {
}
