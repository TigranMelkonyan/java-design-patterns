package com.tigran.demo_software_patterns.architectural.hexagonal.adapter.out.persistence;

import com.tigran.demo_software_patterns.architectural.hexagonal.domain.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/19/24
 * Time: 5:09 PM
 */
@Repository
public interface JpaAccountRepository extends JpaRepository<Account, UUID> {
}
