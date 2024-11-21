package com.tigran.demo_software_patterns.architectural.cqrs.command.service;

import com.tigran.demo_software_patterns.architectural.cqrs.command.domain.entity.Product;
import com.tigran.demo_software_patterns.architectural.cqrs.command.dto.CreateProductCommand;
import com.tigran.demo_software_patterns.architectural.cqrs.command.repository.ProductRepository;
import com.tigran.demo_software_patterns.architectural.cqrs.shared.event.ProductCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 2:39 PM
 */
@Service
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final ApplicationEventPublisher eventPublisher;

    public ProductCommandService(ProductRepository productRepository, ApplicationEventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Product createProduct(CreateProductCommand command) {
        Product product = new Product(command.getName(),
                command.getDescription(), command.getCategory(),
                command.getQuantity(), command.getPrice());
        Product savedProduct = productRepository.save(product);
        ProductCreatedEvent event = new ProductCreatedEvent(
                savedProduct.getId(), savedProduct.getName(),
                savedProduct.getDescription(), savedProduct.getCategory(),
                savedProduct.getQuantity(), savedProduct.getPrice()
        );
        eventPublisher.publishEvent(event);
        return savedProduct;
    }
}
