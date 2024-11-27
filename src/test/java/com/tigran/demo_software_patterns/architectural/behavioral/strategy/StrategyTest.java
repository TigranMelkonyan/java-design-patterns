package com.tigran.demo_software_patterns.architectural.behavioral.strategy;

import com.tigran.demo_software_patterns.behavioral.strategy.BlackFridayDiscountStrategy;
import com.tigran.demo_software_patterns.behavioral.strategy.RegularDiscountStrategy;
import com.tigran.demo_software_patterns.behavioral.strategy.SeasonalDiscountStrategy;
import com.tigran.demo_software_patterns.behavioral.strategy.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:07 PM
 */
public class StrategyTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        // Initially using RegularDiscountStrategy
        shoppingCart = new ShoppingCart(new RegularDiscountStrategy());
    }

    @Test
    void testRegularDiscount() {
        double price = 100.0;
        double expectedPrice = 90.0;
        double actualPrice = shoppingCart.calculateTotalPrice(price);
        assertEquals(expectedPrice, actualPrice, "Price after regular discount should be 90.0");
    }

    @Test
    void testSeasonalDiscount() {
        // Change strategy to SeasonalDiscountStrategy
        shoppingCart.setDiscountStrategy(new SeasonalDiscountStrategy());

        double price = 100.0;
        double expectedPrice = 80.0;
        double actualPrice = shoppingCart.calculateTotalPrice(price);
        assertEquals(expectedPrice, actualPrice, "Price after seasonal discount should be 80.0");
    }

    @Test
    void testBlackFridayDiscount() {
        // Change strategy to BlackFridayDiscountStrategy
        shoppingCart.setDiscountStrategy(new BlackFridayDiscountStrategy());

        double price = 100.0;
        double expectedPrice = 50.0;
        double actualPrice = shoppingCart.calculateTotalPrice(price);
        assertEquals(expectedPrice, actualPrice, "Price after Black Friday discount should be 50.0");
    }
}
