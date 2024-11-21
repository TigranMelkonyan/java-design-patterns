package com.tigran.demo_software_patterns.architectural.cqrs.shared.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:59 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {

    private UUID id;
    private String name;
    private String description;
    private String category;
    private int quantity;
    private double price;
}
