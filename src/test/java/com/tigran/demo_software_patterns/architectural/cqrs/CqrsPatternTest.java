package com.tigran.demo_software_patterns.architectural.cqrs;

import com.tigran.demo_software_patterns.architectural.cqrs.command.dto.CreateProductCommand;
import com.tigran.demo_software_patterns.architectural.cqrs.command.service.ProductCommandService;
import com.tigran.demo_software_patterns.architectural.cqrs.query.dto.ProductView;
import com.tigran.demo_software_patterns.architectural.cqrs.query.service.ProductQueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Tigran Melkonyan
 * Date: 11/21/24
 * Time: 3:08 PM
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CqrsPatternTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductCommandService productCommandService;

    @MockBean
    private ProductQueryService productQueryService;

    @Test
    void testProductCreatedEventIsTriggeredAndConsumed() throws Exception {
        // Given: A product creation command
        CreateProductCommand command = new CreateProductCommand(
                "New Product",          // Product name
                "Mens Clothing",        // Product description
                "Clothing",             // Product category
                10,                     // Product quantity
                99.99                   // Product price
        );

        // Generate a random UUID for the product ID (simulating persistence)
        UUID productId = UUID.randomUUID();

        // Given: A JSON payload representing the product to be created
        String productJson = "{\"name\":\"New Product\"," +
                " \"description\":\"Mens Clothing\"," +
                " \"category\":\"Clothing\"," +
                " \"quantity\":10, \"price\":99.99}";

        // When: A POST request is made to the product creation endpoint with the product JSON
        mockMvc.perform(post("/api/commands/products")
                        .contentType("application/json")
                        .content(productJson))
                .andExpect(status().isOk());

        // Then: Verify that the command service was called to handle the product creation with the correct command
        // Ensure createProduct was called once with the command
        verify(productCommandService, times(1)).createProduct(command);

        // Given: The expected ProductView to be returned by the query side after consuming the event
        ProductView expectedProductView = new ProductView(productId, "New Product",
                "Mens Clothing", "Clothing", 10, 99.99);

        // When: The ProductQueryService is simulated to return the expected product view based on product ID
        when(productQueryService.getProductById(productId)).thenReturn(expectedProductView);

        // When: A GET request is made to the query endpoint to fetch the product by its ID
        mockMvc.perform(get("/api/queries/products/" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("New Product"))
                .andExpect(jsonPath("$.description").value("Mens Clothing"))
                .andExpect(jsonPath("$.category").value("Clothing"))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.price").value(99.99));// Then: Verify the product price

        // Then: Verify that the ProductQueryService was called once with the correct product ID
        // Ensure the query service was called once with the correct product ID
        verify(productQueryService, times(1)).getProductById(productId);
    }

}
