package com.tigran.demo_software_patterns.structural.adapter.gateway;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:57 PM
 */
public class StripePaymentGateway {

    public boolean chargeCard(String cardNumber, double amount) {
        System.out.println("Charging $" + amount + " to card: " + cardNumber);
        return true;
    }
}
