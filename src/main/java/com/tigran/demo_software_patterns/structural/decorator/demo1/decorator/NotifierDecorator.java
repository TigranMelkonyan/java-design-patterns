package com.tigran.demo_software_patterns.structural.decorator.demo1.decorator;

import com.tigran.demo_software_patterns.structural.decorator.demo1.notifier.Notifier;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:37 PM
 */
public abstract class NotifierDecorator implements Notifier {

    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

