package com.msa.service.movements.infrastructure.controller;

import com.msa.service.movements.api.MovementsApi;
import com.msa.service.movements.domain.ports.in.MovementService;
import com.msa.service.movements.model.AccountMovement;
import com.msa.service.movements.model.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovementController implements MovementsApi {

    private final MovementService movementService;

    @Override
    public ResponseEntity<AccountMovement> createMovement(String xSwClientRequestId, String xSwClientUserAgent, Movement movement) {
        AccountMovement accountMovement = this.movementService.createMovement(movement);

        return ResponseEntity.status(201).body(accountMovement);
    }

    @Override
    public ResponseEntity<List<AccountMovement>> findAllMovementsByAccountId(String xSwClientRequestId, String xSwClientUserAgent, Long accountId) {
        List<AccountMovement> movements = this.movementService.findAllMovementsByAccountId(accountId);

        return ResponseEntity.status(!movements.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(movements);
    }
}
