package com.tigran.demo_software_patterns.architectural.eventdriven.service;

import com.tigran.demo_software_patterns.architectural.eventdriven.domain.entity.EventEntity;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.common.Event;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderCancelledEvent;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderPlacedEvent;
import com.tigran.demo_software_patterns.architectural.eventdriven.event.order.OrderShippedEvent;
import com.tigran.demo_software_patterns.architectural.eventdriven.repository.EventStoreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tigran Melkonyan
 * Date: 11/18/24
 * Time: 4:36 PM
 */
@Service
public class DatabaseEventStore {

    private final EventStoreRepository eventRepository;

    public DatabaseEventStore(EventStoreRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void storeEvent(Event event) {
        String details = extractDetails(event);
        EventEntity entity = new EventEntity(event.orderId(), event.getEventType(), details);
        eventRepository.save(entity);
    }

    public List<Event> getEventsForOrder(String orderId) {
        List<EventEntity> entities = eventRepository.findByOrderId(orderId);
        List<Event> events = new ArrayList<>();
        for (EventEntity entity : entities) {
            Event event = reconstructEvent(entity);
            events.add(event);
        }
        return events;
    }

    private String extractDetails(Event event) {
        if (event instanceof OrderPlacedEvent) {
            return "Order placed";
        } else if (event instanceof OrderShippedEvent) {
            return "Order shipped";
        } else if (event instanceof OrderCancelledEvent) {
            return "Order cancelled";
        } else {
            throw new IllegalArgumentException("Unknown event type: " + event.getEventType());
        }
    }

    private Event reconstructEvent(EventEntity entity) {
        return switch (entity.getEventType()) {
            case "OrderPlacedEvent" -> new OrderPlacedEvent(entity.getOrderId());
            case "OrderShippedEvent" -> new OrderShippedEvent(entity.getOrderId());
            case "OrderCancelledEvent" -> new OrderCancelledEvent(entity.getOrderId());
            default -> throw new IllegalArgumentException("Unknown event type: " + entity.getEventType());
        };
    }
}