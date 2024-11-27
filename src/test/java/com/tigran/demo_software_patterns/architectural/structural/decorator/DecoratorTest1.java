package com.tigran.demo_software_patterns.architectural.structural.decorator;

import com.tigran.demo_software_patterns.structural.decorator.demo1.notifier.BasicNotifier;
import com.tigran.demo_software_patterns.structural.decorator.demo1.decorator.EmailDecorator;
import com.tigran.demo_software_patterns.structural.decorator.demo1.notifier.Notifier;
import com.tigran.demo_software_patterns.structural.decorator.demo1.decorator.SMSDecorator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:41 PM
 */
public class DecoratorTest1 {

    @Test
    void testBasicNotifier() {
        Notifier notifier = new BasicNotifier();
        assertDoesNotThrow(() -> notifier.send("Hello, World!"));
    }

    @Test
    void testEmailDecorator() {
        Notifier notifier = new EmailDecorator(new BasicNotifier());
        assertDoesNotThrow(() -> notifier.send("Hello, World with Email!"));
    }

    @Test
    void testSMSDecorator() {
        Notifier notifier = new SMSDecorator(new BasicNotifier());
        assertDoesNotThrow(() -> notifier.send("Hello, World with SMS!"));
    }

    @Test
    void testEmailAndSMSDecorators() {
        Notifier notifier = new SMSDecorator(new EmailDecorator(new BasicNotifier()));
        assertDoesNotThrow(() -> notifier.send("Hello, World with Email and SMS!"));
    }
}
