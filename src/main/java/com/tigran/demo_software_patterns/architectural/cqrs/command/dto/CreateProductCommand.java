package com.tigran.demo_software_patterns.architectural.cqrs.command.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:38 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCommand {

    private String name;
    private String description;
    private String category;
    private int quantity;
    private double price;
}
