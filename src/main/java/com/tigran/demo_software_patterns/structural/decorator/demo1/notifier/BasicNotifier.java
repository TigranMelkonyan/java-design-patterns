package com.tigran.demo_software_patterns.structural.decorator.demo1.notifier;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:36 PM
 */
public class BasicNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("Sending basic notification: " + message);
    }
}

