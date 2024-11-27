package com.tigran.demo_software_patterns.behavioral.strategy;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:06 PM
 */
public class BlackFridayDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double price) {
        return price * 0.50;
    }
}