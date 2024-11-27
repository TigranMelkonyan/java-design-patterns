package com.tigran.demo_software_patterns.behavioral.strategy;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:07 PM
 */
public class ShoppingCart {

    private DiscountStrategy discountStrategy;

    public ShoppingCart(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotalPrice(double price) {
        return discountStrategy.applyDiscount(price);
    }
}
