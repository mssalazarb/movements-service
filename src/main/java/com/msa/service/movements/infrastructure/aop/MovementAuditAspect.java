package com.msa.service.movements.infrastructure.aop;

import com.msa.service.movements.domain.model.MovementAudit;
import com.msa.service.movements.domain.ports.in.MovementAuditService;
import com.msa.service.movements.model.Movement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Log4j2
public class MovementAuditAspect {

    private final MovementAuditService movementAuditService;
    private ThreadLocal<MovementAudit> movementAuditLocal = new ThreadLocal<>();

    @Pointcut("execution(* com.msa.service.movements.domain.ports.in.MovementService.createMovement(..))")
    public void saveMovement() {
    }

    @Before("saveMovement() && args(movement)")
    public void logAntesDePersistir(Movement movement) {
        var audit = this.movementAuditService.createMovementAudit(movement);
        this.movementAuditLocal.set(audit);
    }

    @AfterReturning(pointcut = "execution(* com.msa.service.movements.domain.ports.in.MovementService.createMovement(..))")
    public void afterSaveMovement() {
        var audit = this.movementAuditLocal.get();
        this.movementAuditService.updateMovementAudit(audit);
        this.movementAuditLocal.remove();
    }

    @AfterThrowing(pointcut = "execution(* com.msa.service.movements.domain.ports.in.MovementService.createMovement(..))", throwing = "ex")
    public void afterThrowingError(Throwable ex) {
        var audit = this.movementAuditLocal.get();
        this.movementAuditService.updateMovementAudit(audit);
        this.movementAuditLocal.remove();
    }
}
