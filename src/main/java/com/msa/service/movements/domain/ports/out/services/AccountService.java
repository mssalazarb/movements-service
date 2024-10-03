package com.msa.service.movements.domain.ports.out.services;

import com.msa.service.movements.domain.model.Account;

public interface AccountService {
    Account findAccountByAccountId(Long accountId);
}
