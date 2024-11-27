package com.tigran.demo_software_patterns.structural.adapter.adaper;

import com.tigran.demo_software_patterns.structural.adapter.system.BankTransferPaymentSystem;
import com.tigran.demo_software_patterns.structural.adapter.gateway.PaymentGateway;
import com.tigran.demo_software_patterns.structural.adapter.model.PaymentDetails;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:00 PM
 */
public class BankTransferAdapter implements PaymentGateway {

    private final BankTransferPaymentSystem bankTransferPaymentSystem;

    public BankTransferAdapter(BankTransferPaymentSystem bankTransferPaymentSystem) {
        this.bankTransferPaymentSystem = bankTransferPaymentSystem;
    }

    @Override
    public boolean processPayment(PaymentDetails paymentDetails) {
        return bankTransferPaymentSystem.initiateBankTransfer(paymentDetails.getAccountNumber(), paymentDetails.getAmount());
    }
}
