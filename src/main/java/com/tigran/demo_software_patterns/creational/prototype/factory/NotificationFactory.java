package com.tigran.demo_software_patterns.creational.prototype.factory;

import com.tigran.demo_software_patterns.creational.prototype.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:07 PM
 */
@Component
public class NotificationFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public NotificationFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Notification getPrototype(String type) {
        try {
            return applicationContext.getBean(type, Notification.class).clone();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid notification type: " + type);
        }
    }
}
