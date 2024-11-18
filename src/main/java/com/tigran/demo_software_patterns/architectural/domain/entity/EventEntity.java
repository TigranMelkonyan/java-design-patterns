package com.tigran.demo_software_patterns.architectural.domain.entity;

import com.tigran.demo_software_patterns.architectural.domain.entity.audit.AuditableBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Created by Tigran Melkonyan
 * Date: 11/16/24
 * Time: 12:37 PM
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "event_store")
@Data
@NoArgsConstructor
public class EventEntity extends AuditableBaseEntity {

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "details")
    private String details;

    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    public EventEntity(String orderId, String eventType, String details) {
        this.orderId = orderId;
        this.eventType = eventType;
        this.details = details;
        this.timestamp = Instant.now();
    }

}
