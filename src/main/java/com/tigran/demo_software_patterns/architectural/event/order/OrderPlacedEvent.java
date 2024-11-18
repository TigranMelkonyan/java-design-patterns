package com.tigran.demo_software_patterns.architectural.event.order;

import com.tigran.demo_software_patterns.architectural.event.common.Event;

/**
 * Created by Tigran Melkonyan
 * Date: 11/18/24
 * Time: 4:37 PM
 */
public record OrderPlacedEvent(String orderId) implements Event {

    @Override
    public String getEventType() {
        return "OrderPlacedEvent";
    }
}
