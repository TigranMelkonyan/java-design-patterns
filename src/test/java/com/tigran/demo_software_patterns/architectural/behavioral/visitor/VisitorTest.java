package com.tigran.demo_software_patterns.architectural.behavioral.visitor;

import com.tigran.demo_software_patterns.behavioral.visitor.model.Book;
import com.tigran.demo_software_patterns.behavioral.visitor.model.Fruit;
import com.tigran.demo_software_patterns.behavioral.visitor.service.NamePrinter;
import com.tigran.demo_software_patterns.behavioral.visitor.service.PriceCalculator;
import com.tigran.demo_software_patterns.behavioral.visitor.cart.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:10 PM
 */
public class VisitorTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Book("Design Patterns", 30.0));
        shoppingCart.addItem(new Fruit("Apple", 5.0));
    }

    @Test
    void testPriceCalculator() {
        PriceCalculator priceCalculator = new PriceCalculator();
        shoppingCart.accept(priceCalculator);

        double expectedPrice = 35.0;
        double actualPrice = priceCalculator.getTotalPrice();
        assertEquals(expectedPrice, actualPrice, "Total price should be 35.0");
    }

    @Test
    void testNamePrinter() {
        NamePrinter namePrinter = new NamePrinter();
        shoppingCart.accept(namePrinter);
    }
}
