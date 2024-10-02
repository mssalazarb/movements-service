package com.msa.service.movements.infrastructure.controller;

import com.msa.service.movements.api.MovementsApi;
import com.msa.service.movements.domain.ports.in.MovementService;
import com.msa.service.movements.model.AccountMovement;
import com.msa.service.movements.model.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovementController implements MovementsApi {

    private final MovementService movementService;

    @Override
    public ResponseEntity<AccountMovement> createMovement(String xSwClientRequestId, String xSwClientUserAgent, Movement movement) {
        AccountMovement accountMovement = this.movementService.createMovement(movement);

        return ResponseEntity.status(200).body(accountMovement);
    }
}
