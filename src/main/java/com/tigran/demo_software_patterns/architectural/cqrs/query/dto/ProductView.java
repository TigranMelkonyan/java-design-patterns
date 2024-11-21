package com.tigran.demo_software_patterns.architectural.cqrs.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:44 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductView {

    private UUID id;
    private String name;
    private String description;
    private String category;
    private int quantity;
    private double price;
}
