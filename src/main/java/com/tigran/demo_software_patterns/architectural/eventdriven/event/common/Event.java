package com.tigran.demo_software_patterns.architectural.eventdriven.event.common;

/**
 * Created by Tigran Melkonyan
 * Date: 11/18/24
 * Time: 4:37 PM
 */
public interface Event {
    String orderId();
    String getEventType();
}

