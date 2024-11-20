package com.tigran.demo_software_patterns.architectural.eventdriven.event.order;

import com.tigran.demo_software_patterns.architectural.eventdriven.event.common.Event;

/**
 * Created by Tigran Melkonyan
 * Date: 11/18/24
 * Time: 4:39 PM
 */
public record OrderCancelledEvent(String orderId) implements Event {

    @Override
    public String getEventType() {
        return "OrderCancelledEvent";
    }
}
