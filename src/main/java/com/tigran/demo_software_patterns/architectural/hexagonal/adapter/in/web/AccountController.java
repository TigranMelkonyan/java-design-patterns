package com.tigran.demo_software_patterns.architectural.hexagonal.adapter.in.web;

import com.tigran.demo_software_patterns.architectural.hexagonal.domain.port.in.AccountUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/19/24
 * Time: 5:11 PM
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountUseCase accountUseCase;

    public AccountController(AccountUseCase accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    @PostMapping("/{id}/deposit")
    public void deposit(@PathVariable UUID id, @RequestParam BigDecimal amount) {
        accountUseCase.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public void withdraw(@PathVariable UUID id, @RequestParam BigDecimal amount) {
        accountUseCase.withdraw(id, amount);
    }
}
