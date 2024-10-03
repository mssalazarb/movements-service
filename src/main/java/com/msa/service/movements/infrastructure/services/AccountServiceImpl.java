package com.msa.service.movements.infrastructure.services;

import com.msa.service.movements.domain.model.Account;
import com.msa.service.movements.domain.ports.out.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final String microserviceUrl;
    private final RestTemplate restTemplate;

    @Override
    public Account findAccountByAccountId(Long accountId) {
        String url = String.format("%s/api/account-service/accounts/%s", microserviceUrl, accountId);

        return restTemplate.getForObject(url, Account.class);
    }
}
