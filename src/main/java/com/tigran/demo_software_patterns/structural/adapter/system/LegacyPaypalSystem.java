package com.tigran.demo_software_patterns.structural.adapter.system;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:57 PM
 */
public class LegacyPaypalSystem {

    public boolean makePaypalPayment(String email, double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " for email: " + email);
        return true;
    }
}
