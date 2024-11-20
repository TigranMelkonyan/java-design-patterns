package com.tigran.demo_software_patterns.architectural.hexagonal.domain.model.account;

import com.tigran.demo_software_patterns.architectural.eventdriven.domain.entity.audit.AuditableBaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by Tigran Melkonyan
 * Date: 11/19/24
 * Time: 5:04 PM
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AuditableBaseEntity {
    
    private String ownerName;
    private String email;
    private BigDecimal balance;

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount.compareTo(balance) > 0) {
            throw new IllegalStateException("Insufficient balance.");
        }
        balance = balance.subtract(amount);
    }
}
