package com.tigran.demo_software_patterns.creational.prototype.service;

import com.tigran.demo_software_patterns.creational.prototype.Notification;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:05 PM
 */
@Component("EmailNotification")
@Scope("prototype")
public class EmailNotification implements Notification {

    private String message;

    @Override
    public Notification clone() {
        try {
            return (Notification) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed");
        }
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Email: " + message;
    }
}
