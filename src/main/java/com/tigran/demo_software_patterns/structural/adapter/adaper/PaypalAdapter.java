package com.tigran.demo_software_patterns.structural.adapter.adaper;

import com.tigran.demo_software_patterns.structural.adapter.system.LegacyPaypalSystem;
import com.tigran.demo_software_patterns.structural.adapter.gateway.PaymentGateway;
import com.tigran.demo_software_patterns.structural.adapter.model.PaymentDetails;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:59 PM
 */
public class PaypalAdapter implements PaymentGateway {

    private final LegacyPaypalSystem legacyPaypalSystem;

    public PaypalAdapter(LegacyPaypalSystem legacyPaypalSystem) {
        this.legacyPaypalSystem = legacyPaypalSystem;
    }

    @Override
    public boolean processPayment(PaymentDetails paymentDetails) {
        return legacyPaypalSystem.makePaypalPayment(paymentDetails.getEmail(), paymentDetails.getAmount());
    }
}
