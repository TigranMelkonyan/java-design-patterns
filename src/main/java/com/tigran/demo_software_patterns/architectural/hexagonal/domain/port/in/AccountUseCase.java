package com.tigran.demo_software_patterns.architectural.hexagonal.domain.port.in;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/19/24
 * Time: 5:06 PM
 */
public interface AccountUseCase {

    void deposit(UUID accountId, BigDecimal amount);

    void withdraw(UUID accountId, BigDecimal amount);
}
