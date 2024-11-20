package com.tigran.demo_software_patterns.architectural.hexagonal.adapter.out.persistence;

import com.tigran.demo_software_patterns.architectural.hexagonal.domain.model.account.Account;
import com.tigran.demo_software_patterns.architectural.hexagonal.domain.port.out.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/19/24
 * Time: 5:13 PM
 */
@Component
public class AccountRepositoryImpl implements AccountRepository {

    private final JpaAccountRepository jpaAccountRepository;

    public AccountRepositoryImpl(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public Optional<Account> findById(UUID accountId) {
        return jpaAccountRepository.findById(accountId);
    }

    @Override
    public Account save(Account account) {
        return jpaAccountRepository.save(account);
    }
}
