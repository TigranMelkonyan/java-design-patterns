package com.tigran.demo_software_patterns.architectural.repository;

import com.tigran.demo_software_patterns.architectural.domain.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/18/24
 * Time: 4:44 PM
 */
public interface EventStoreRepository extends JpaRepository<EventEntity, UUID> {
    List<EventEntity> findByOrderId(String orderId);
}
