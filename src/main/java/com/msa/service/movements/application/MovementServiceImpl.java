package com.msa.service.movements.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.movements.domain.exceptions.ConflictException;
import com.msa.service.movements.domain.model.Account;
import com.msa.service.movements.domain.ports.in.MovementService;
import com.msa.service.movements.domain.ports.out.repositories.MovementRepository;
import com.msa.service.movements.domain.ports.out.services.AccountService;
import com.msa.service.movements.model.AccountMovement;
import com.msa.service.movements.model.Movement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;
    private final AccountService accountService;
    private final ObjectMapper mapper;

    @Override
    public AccountMovement createMovement(Movement movement) {
        Account account;

        try {
            account = this.accountService.findAccountByAccountId(movement.getAccountId());
        } catch (Exception e) {
            log.error("An error occurred while validating the account");

            throw new ConflictException("An error occurred while recording the movement");
        }

        if (movement.getTypeMovement().name().equals("DEPOSIT")) {
            account.setAmount(this.processDeposit(account.getAmount(), movement.getAmount()));
        } else if (movement.getTypeMovement().name().equals("WITHDRAWAL")) {
            account.setAmount(this.processWithdrawal(account.getAmount(), movement.getAmount()));
        }
        //TODO save new account amount

        movement = this.movementRepository.saveMovement(movement);

        return mapper.convertValue(movement, AccountMovement.class);
    }

    private BigDecimal processDeposit(BigDecimal totalAmount, Double amount) {
        return totalAmount.add(BigDecimal.valueOf(amount));
    }

    private BigDecimal processWithdrawal(BigDecimal totalAmount, Double amount) {
        if (totalAmount.compareTo(BigDecimal.valueOf(amount)) < 0) {
            log.error("The amount to be withdrawn exceeds the available value");

            throw new ConflictException("The amount to be withdrawn exceeds the available value");
        }

        return totalAmount.subtract(BigDecimal.valueOf(amount));
    }

    @Override
    public List<AccountMovement> findAllMovementsByAccountId(Long accountId) {
        return this.movementRepository.findAllMovementsByAccountId(accountId)
                .stream()
                .map(movement -> mapper.convertValue(movement, AccountMovement.class))
                .toList();
    }
}
