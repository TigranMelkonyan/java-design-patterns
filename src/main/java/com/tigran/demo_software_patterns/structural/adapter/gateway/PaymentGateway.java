package com.tigran.demo_software_patterns.structural.adapter.gateway;

import com.tigran.demo_software_patterns.structural.adapter.model.PaymentDetails;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:56 PM
 */
public interface PaymentGateway {
    
    boolean processPayment(PaymentDetails paymentDetails);
}
