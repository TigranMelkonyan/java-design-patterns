package com.tigran.demo_software_patterns.structural.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:00 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {

    private double amount;
    private String email;
    private String cardNumber;
    private String accountNumber;

}
