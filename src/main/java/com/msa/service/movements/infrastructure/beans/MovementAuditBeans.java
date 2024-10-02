package com.msa.service.movements.infrastructure.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.movements.application.MovementAuditServiceImpl;
import com.msa.service.movements.domain.ports.in.MovementAuditService;
import com.msa.service.movements.domain.ports.out.MovementAuditRepository;
import com.msa.service.movements.infrastructure.repository.JpaMovementAuditRepository;
import com.msa.service.movements.infrastructure.repository.impl.MovementAuditRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MovementAuditBeans {

    private final JpaMovementAuditRepository jpaMovementAuditRepository;
    private final ObjectMapper mapper;

    @Bean
    public MovementAuditRepository movementAuditRepository() {
        return new MovementAuditRepositoryImpl(jpaMovementAuditRepository, mapper);
    }

    @Bean
    public MovementAuditService movementAuditService() {
        return new MovementAuditServiceImpl(movementAuditRepository());
    }
}
