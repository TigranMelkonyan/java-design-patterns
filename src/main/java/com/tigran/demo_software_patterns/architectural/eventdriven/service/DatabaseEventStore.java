package com.tigran.demo_software_patterns.architectural.eventdriven.service;

import com.tigran.demo_software_patterns.architectural.eventdriven.event.common.Event;

import java.util.List;

/**
 * Created by Tigran Melkonyan
 * Date: 11/20/24
 * Time: 5:25 PM
 */
public interface DatabaseEventStore {

    void storeEvent(Event event);

    List<Event> getEventsForOrder(String orderId);
}
