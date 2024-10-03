package com.msa.service.movements.infrastructure.beans;

import com.msa.service.movements.domain.ports.out.services.AccountService;
import com.msa.service.movements.infrastructure.services.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class ServicesBeans {
    @Value("microservices.url")
    private String microservicesUrl;

    private final RestTemplate restTemplate;

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl(microservicesUrl, restTemplate);
    }
}
