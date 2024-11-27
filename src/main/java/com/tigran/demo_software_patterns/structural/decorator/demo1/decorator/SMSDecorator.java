package com.tigran.demo_software_patterns.structural.decorator.demo1.decorator;

import com.tigran.demo_software_patterns.structural.decorator.demo1.notifier.Notifier;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:40 PM
 */
public class SMSDecorator extends NotifierDecorator {

    public SMSDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMSNotification(message);
    }

    private void sendSMSNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
