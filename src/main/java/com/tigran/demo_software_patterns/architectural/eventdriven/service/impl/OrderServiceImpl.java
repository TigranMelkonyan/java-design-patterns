package com.tigran.demo_software_patterns.architectural.eventdriven.service.impl;

import com.tigran.demo_software_patterns.architectural.eventdriven.domain.model.Order;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.common.Event;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderCancelledEvent;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderPlacedEvent;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderShippedEvent;
import com.tigran.demo_software_patterns.architectural.eventdriven.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tigran Melkonyan
 * Date: 11/18/24
 * Time: 4:41 PM
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final DatabaseEventStoreImpl eventStore;

    public OrderServiceImpl(DatabaseEventStoreImpl eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrder(String orderId) {
        List<Event> events = eventStore.getEventsForOrder(orderId);
        Order order = new Order(orderId);
        for (Event event : events) {
            order.applyEvent(event);
        }
        return order;
    }

    @Override
    @Transactional
    public void placeOrder(String orderId) {
        OrderPlacedEvent event = new OrderPlacedEvent(orderId);
        eventStore.storeEvent(event);
    }

    @Override
    @Transactional
    public void shipOrder(String orderId) {
        OrderShippedEvent event = new OrderShippedEvent(orderId);
        eventStore.storeEvent(event);
    }

    @Override
    @Transactional
    public void cancelOrder(String orderId) {
        OrderCancelledEvent event = new OrderCancelledEvent(orderId);
        eventStore.storeEvent(event);
    }
}

