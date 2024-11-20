package com.tigran.demo_software_patterns.architectural.hexagonal.domain.port.out;

import com.tigran.demo_software_patterns.architectural.hexagonal.domain.model.account.Account;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/19/24
 * Time: 5:06 PM
 */
public interface AccountRepository {

    Optional<Account> findById(UUID accountId);

    Account save(Account account);
}
