package com.tigran.demo_software_patterns.architectural.eventdriven.service;

import com.tigran.demo_software_patterns.architectural.eventdriven.domain.model.audit.order.Order;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.common.Event;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderCancelledEvent;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderPlacedEvent;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderShippedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tigran Melkonyan
 * Date: 11/18/24
 * Time: 4:41 PM
 */
@Service
public class OrderService {

    private final DatabaseEventStore eventStore;

    public OrderService(DatabaseEventStore eventStore) {
        this.eventStore = eventStore;
    }

    public Order getOrder(String orderId) {
        List<Event> events = eventStore.getEventsForOrder(orderId);
        Order order = new Order(orderId);
        for (Event event : events) {
            order.applyEvent(event);
        }
        return order;
    }

    public void placeOrder(String orderId) {
        OrderPlacedEvent event = new OrderPlacedEvent(orderId);
        eventStore.storeEvent(event);
    }

    public void shipOrder(String orderId) {
        OrderShippedEvent event = new OrderShippedEvent(orderId);
        eventStore.storeEvent(event);
    }

    public void cancelOrder(String orderId) {
        OrderCancelledEvent event = new OrderCancelledEvent(orderId);
        eventStore.storeEvent(event);
    }
}

