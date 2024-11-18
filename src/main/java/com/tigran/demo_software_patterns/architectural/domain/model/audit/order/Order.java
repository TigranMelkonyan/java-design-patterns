package com.tigran.demo_software_patterns.architectural.domain.model.audit.order;

import com.tigran.demo_software_patterns.architectural.event.common.Event;
import com.tigran.demo_software_patterns.architectural.event.order.OrderCancelledEvent;
import com.tigran.demo_software_patterns.architectural.event.order.OrderPlacedEvent;
import com.tigran.demo_software_patterns.architectural.event.order.OrderShippedEvent;
import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 11/18/24
 * Time: 4:40 PM
 */
@Getter
public class Order {

    private String orderId;
    private boolean isShipped;
    private boolean isCancelled;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void applyEvent(Event event) {
        if (event instanceof OrderPlacedEvent) {
            this.orderId = event.orderId();
        } else if (event instanceof OrderShippedEvent) {
            this.isShipped = true;
        } else if (event instanceof OrderCancelledEvent) {
            this.isCancelled = true;
        }
    }

    public String getOrderState() {
        if (isCancelled) return "Cancelled";
        if (isShipped) return "Shipped";
        return "Placed";
    }
}

