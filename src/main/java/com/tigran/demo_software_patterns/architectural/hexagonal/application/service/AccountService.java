package com.tigran.demo_software_patterns.architectural.hexagonal.application.service;

import com.tigran.demo_software_patterns.architectural.hexagonal.domain.model.account.Account;
import com.tigran.demo_software_patterns.architectural.hexagonal.domain.port.in.AccountUseCase;
import com.tigran.demo_software_patterns.architectural.hexagonal.domain.port.out.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/19/24
 * Time: 5:07 PM
 */
@Service
public class AccountService implements AccountUseCase {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void deposit(UUID accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found."));
        account.deposit(amount);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(UUID accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found."));
        account.withdraw(amount);
        accountRepository.save(account);
    }
}
