package com.msa.service.movements.infrastructure.repositories;

import com.msa.service.movements.infrastructure.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaMovementRepository extends JpaRepository<MovementEntity, Long > {
    List<MovementEntity> findAllByAccountId(Long accountId);
}
