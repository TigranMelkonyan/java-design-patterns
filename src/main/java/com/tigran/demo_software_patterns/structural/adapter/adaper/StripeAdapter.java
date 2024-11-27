package com.tigran.demo_software_patterns.structural.adapter.adaper;

import com.tigran.demo_software_patterns.structural.adapter.gateway.PaymentGateway;
import com.tigran.demo_software_patterns.structural.adapter.gateway.StripePaymentGateway;
import com.tigran.demo_software_patterns.structural.adapter.model.PaymentDetails;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:59 PM
 */
public class StripeAdapter implements PaymentGateway {

    private final StripePaymentGateway stripePaymentGateway;

    public StripeAdapter(StripePaymentGateway stripePaymentGateway) {
        this.stripePaymentGateway = stripePaymentGateway;
    }

    @Override
    public boolean processPayment(PaymentDetails paymentDetails) {
        return stripePaymentGateway.chargeCard(paymentDetails.getCardNumber(), paymentDetails.getAmount());
    }
}
