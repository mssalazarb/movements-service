package com.msa.service.movements.infrastructure.configuration.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.movements.application.MovementServiceImpl;
import com.msa.service.movements.domain.ports.in.MovementService;
import com.msa.service.movements.domain.ports.out.MovementRepository;
import com.msa.service.movements.infrastructure.adapter.out.repository.JpaMovementRepository;
import com.msa.service.movements.infrastructure.adapter.out.repository.impl.MovementRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MovementBeans {

    private final JpaMovementRepository jpaMovementRepository;
    private final ObjectMapper mapper;

    @Bean
    public MovementRepository movementRepository() {
        return new MovementRepositoryImpl(jpaMovementRepository, mapper);
    }

    @Bean
    public MovementService movementService() {
        return new MovementServiceImpl(movementRepository());
    }
}
