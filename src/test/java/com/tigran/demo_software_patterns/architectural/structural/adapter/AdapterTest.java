package com.tigran.demo_software_patterns.architectural.structural.adapter;

import com.tigran.demo_software_patterns.structural.adapter.adaper.BankTransferAdapter;
import com.tigran.demo_software_patterns.structural.adapter.adaper.PaypalAdapter;
import com.tigran.demo_software_patterns.structural.adapter.adaper.StripeAdapter;
import com.tigran.demo_software_patterns.structural.adapter.gateway.PaymentGateway;
import com.tigran.demo_software_patterns.structural.adapter.gateway.StripePaymentGateway;
import com.tigran.demo_software_patterns.structural.adapter.model.PaymentDetails;
import com.tigran.demo_software_patterns.structural.adapter.service.ECommerceService;
import com.tigran.demo_software_patterns.structural.adapter.system.BankTransferPaymentSystem;
import com.tigran.demo_software_patterns.structural.adapter.system.LegacyPaypalSystem;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:06 PM
 */
public class AdapterTest {

    @Test
    void testPaymentProcessingWithPaypalAdapter() {
        // Mock the legacy PayPal system
        LegacyPaypalSystem legacyPaypalSystem = mock(LegacyPaypalSystem.class);
        when(legacyPaypalSystem.makePaypalPayment(anyString(), anyDouble())).thenReturn(true);

        PaymentGateway paypalAdapter = new PaypalAdapter(legacyPaypalSystem);
        ECommerceService ecommerceService = new ECommerceService(paypalAdapter);

        // Test payment processing
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAmount(100.0);
        paymentDetails.setEmail("customer@example.com");
        ecommerceService.processOrder(paymentDetails);

        // Verify that the legacy PayPal system's method was called
        verify(legacyPaypalSystem).makePaypalPayment("customer@example.com", 100.0);
    }

    @Test
    void testPaymentProcessingWithStripeAdapter() {
        // Mock the Stripe payment gateway
        StripePaymentGateway stripePaymentGateway = mock(StripePaymentGateway.class);
        when(stripePaymentGateway.chargeCard(anyString(), anyDouble())).thenReturn(true);

        PaymentGateway stripeAdapter = new StripeAdapter(stripePaymentGateway);
        ECommerceService ecommerceService = new ECommerceService(stripeAdapter);

        // Test payment processing
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAmount(200);
        paymentDetails.setCardNumber("4111111111111111");
        ecommerceService.processOrder(paymentDetails);

        // Verify that the Stripe system's method was called
        verify(stripePaymentGateway).chargeCard("4111111111111111", 200.0);

    }

    @Test
    void testPaymentProcessingWithBankTransferAdapter() {
        // Mock the BankTransfer payment system
        BankTransferPaymentSystem bankTransferPaymentSystem = mock(BankTransferPaymentSystem.class);
        when(bankTransferPaymentSystem.initiateBankTransfer(anyString(), anyDouble())).thenReturn(true);

        PaymentGateway bankTransferAdapter = new BankTransferAdapter(bankTransferPaymentSystem);
        ECommerceService ecommerceService = new ECommerceService(bankTransferAdapter);

        // Test payment processing
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAmount(300.0);
        paymentDetails.setAccountNumber("123456789");
        ecommerceService.processOrder(paymentDetails);

        // Verify that the Bank Transfer system's method was called
        verify(bankTransferPaymentSystem).initiateBankTransfer("123456789", 300.0);
    }
}
