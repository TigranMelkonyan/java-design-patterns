package com.tigran.demo_software_patterns.architectural.cqrs.command.domain.entity;

import com.tigran.demo_software_patterns.common.model.audit.AuditableBaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:41 PM
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AuditableBaseEntity {

    private String name;
    private String description;
    private String category;
    private int quantity;
    private double price;
}
