package com.tigran.demo_software_patterns.structural.decorator.demo1.decorator;

import com.tigran.demo_software_patterns.structural.decorator.demo1.notifier.Notifier;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:39 PM
 */
public class EmailDecorator extends NotifierDecorator {
    
    public EmailDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendEmailNotification(message);
    }

    private void sendEmailNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
}
