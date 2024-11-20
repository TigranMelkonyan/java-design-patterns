package com.tigran.demo_software_patterns.architectural.eventdriven.service;

import com.tigran.demo_software_patterns.architectural.eventdriven.domain.model.Order;

/**
 * Created by Tigran Melkonyan
 * Date: 11/20/24
 * Time: 5:24 PM
 */
public interface OrderService {

    Order getOrder(String orderId);

    void placeOrder(String orderId);

    void shipOrder(String orderId);

    void cancelOrder(String orderId);
}
