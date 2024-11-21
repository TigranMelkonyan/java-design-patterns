package com.tigran.demo_software_patterns.architectural.cqrs.query.service;

import com.tigran.demo_software_patterns.architectural.cqrs.command.domain.entity.Product;
import com.tigran.demo_software_patterns.architectural.cqrs.command.repository.ProductRepository;
import com.tigran.demo_software_patterns.architectural.cqrs.query.dto.ProductView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:51 PM
 */
@Service
public class ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductView> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ProductView(product.getId(), product.getName(),
                        product.getDescription(), product.getCategory(),
                        product.getQuantity(), product.getPrice()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductView getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Product not found"));
        return new ProductView(product.getId(), product.getName(),
                product.getDescription(), product.getName(),
                product.getQuantity(), product.getPrice());
    }
}
