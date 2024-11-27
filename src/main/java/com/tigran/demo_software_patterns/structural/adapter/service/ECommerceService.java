package com.tigran.demo_software_patterns.structural.adapter.service;

import com.tigran.demo_software_patterns.structural.adapter.gateway.PaymentGateway;
import com.tigran.demo_software_patterns.structural.adapter.model.PaymentDetails;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:04 PM
 */
public class ECommerceService {

    private final PaymentGateway paymentGateway;

    public ECommerceService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processOrder(PaymentDetails paymentDetails) {
        if (paymentGateway.processPayment(paymentDetails)) {
            System.out.println("Payment successful for amount: $" + paymentDetails.getAmount());
        } else {
            System.out.println("Payment failed for amount: $" + paymentDetails.getAmount());
        }
    }
}
