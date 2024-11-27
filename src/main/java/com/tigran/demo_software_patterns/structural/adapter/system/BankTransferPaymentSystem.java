package com.tigran.demo_software_patterns.structural.adapter.system;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:59 PM
 */
public class BankTransferPaymentSystem {

    public boolean initiateBankTransfer(String accountNumber, double amount) {
        System.out.println("Initiating bank transfer of $" + amount + " to account: " + accountNumber);
        return true;
    }
}
