package com.tigran.demo_software_patterns.architectural.cqrs.command.repository;

import com.tigran.demo_software_patterns.architectural.cqrs.command.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:42 PM
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {
}

