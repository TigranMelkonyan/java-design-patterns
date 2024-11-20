package com.tigran.demo_software_patterns.architectural.hexagonal;

import com.tigran.demo_software_patterns.architectural.hexagonal.domain.model.account.Account;
import com.tigran.demo_software_patterns.architectural.hexagonal.domain.port.out.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by Tigran Melkonyan
 * Date: 11/19/24
 * Time: 5:29 PM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HexagonalTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    static Account entity;

    @BeforeEach
    void setup() {
        entity = accountRepository.save(
                new Account("John Doe",
                        "test@gmail.com",
                        new BigDecimal("100.0")));
    }

    @Test
    void testDeposit() {
        String url = "http://localhost:" + port + "/accounts/1/deposit?amount=50";
        restTemplate.postForEntity(url, null, Void.class);
        Optional<Account> account = accountRepository.findById(entity.getId());
        assertThat(account).isPresent();
        assertThat(BigDecimal.valueOf(100.0).compareTo(account.get().getBalance())).isZero();
    }

    @Test
    void testWithdraw() {
        String url = "http://localhost:" + port + "/accounts/1/withdraw?amount=50";
        restTemplate.postForEntity(url, null, Void.class);
        Optional<Account> account = accountRepository.findById(entity.getId());
        assertThat(account).isPresent();
        assertThat(BigDecimal.valueOf(100.0).compareTo(account.get().getBalance())).isZero();
    }
}