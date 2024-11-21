package com.tigran.demo_software_patterns.architectural.cqrs.command.api;

import com.tigran.demo_software_patterns.architectural.cqrs.command.domain.entity.Product;
import com.tigran.demo_software_patterns.architectural.cqrs.command.dto.CreateProductCommand;
import com.tigran.demo_software_patterns.architectural.cqrs.command.service.ProductCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:43 PM
 */
@RestController
@RequestMapping("/api/commands/products")
public class ProductCommandController {

    private final ProductCommandService commandService;

    public ProductCommandController(ProductCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductCommand command) {
        return ResponseEntity.ok(commandService.createProduct(command));
    }
}
