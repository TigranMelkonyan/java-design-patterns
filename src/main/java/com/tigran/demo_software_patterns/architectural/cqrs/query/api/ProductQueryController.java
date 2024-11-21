package com.tigran.demo_software_patterns.architectural.cqrs.query.api;

import com.tigran.demo_software_patterns.architectural.cqrs.query.dto.ProductView;
import com.tigran.demo_software_patterns.architectural.cqrs.query.service.ProductQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:53 PM
 */
@RestController
@RequestMapping("/api/queries/products")
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    public ProductQueryController(ProductQueryService productQueryService) {
        this.productQueryService = productQueryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductView>> getAllProducts() {
        return ResponseEntity.ok(productQueryService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductView> getProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(productQueryService.getProductById(id));
    }
}
