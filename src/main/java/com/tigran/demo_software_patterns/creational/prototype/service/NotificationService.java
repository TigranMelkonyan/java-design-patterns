package com.tigran.demo_software_patterns.creational.prototype.service;

import com.tigran.demo_software_patterns.creational.prototype.Notification;
import com.tigran.demo_software_patterns.creational.prototype.factory.NotificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:07 PM
 */
@Service
public class NotificationService {

    private final NotificationFactory notificationFactory;

    @Autowired
    public NotificationService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public String createNotification(String type, String message) {
        Notification notification = notificationFactory.getPrototype(type);
        notification.setMessage(message);
        return notification.getMessage();
    }
}