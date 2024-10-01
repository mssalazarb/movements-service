package com.msa.service.movements.application;

import com.msa.service.movements.domain.model.Account;
import com.msa.service.movements.domain.ports.in.MovementService;
import com.msa.service.movements.domain.ports.out.MovementRepository;
import com.msa.service.movements.model.AccountMovement;
import com.msa.service.movements.model.Movement;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;

    @Override
    public AccountMovement createMovement(Movement movement) {
        //TODO validate account by accountID
        Account account = new Account();

        AccountMovement accountMovement = new AccountMovement();

        if (movement.getTypeMovement().name().equals("DEPOSIT")) {
            accountMovement.setTypeMovement(AccountMovement.TypeMovementEnum.DEPOSIT);
            account.setAmount(this.processDeposit(account.getAmount(), movement.getAmmount()));
        } else if (movement.getTypeMovement().name().equals("WITHDRAWAL")) {
            accountMovement.setTypeMovement(AccountMovement.TypeMovementEnum.WITHDRAWAL);
            account.setAmount(this.processWithdrawal(account.getAmount(), movement.getAmmount()));
        }
        //TODO save new account amount

        this.movementRepository.saveMovement(movement);
        accountMovement.setAmmount(movement.getAmmount());

        return accountMovement;
    }

    private BigDecimal processDeposit(BigDecimal totalAmount, Double amount) {
        return totalAmount.add(BigDecimal.valueOf(amount));
    }

    private BigDecimal processWithdrawal(BigDecimal totalAmount, Double amount) {
        return totalAmount.subtract(BigDecimal.valueOf(amount));
    }
}
