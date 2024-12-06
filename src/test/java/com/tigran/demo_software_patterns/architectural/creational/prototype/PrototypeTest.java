package com.tigran.demo_software_patterns.architectural.creational.prototype;

import com.tigran.demo_software_patterns.creational.prototype.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:08 PM
 */
@SpringBootTest
public class PrototypeTest {

    @Autowired
    private NotificationService notificationService;

    @Test
    void shouldCreateEmailNotification() {
        String result = notificationService.createNotification("EmailNotification", "Welcome to our service!");
        assertThat(result).isEqualTo("Email: Welcome to our service!");
    }

    @Test
    void shouldCreateSmsNotification() {
        String result = notificationService.createNotification("SmsNotification", "Your OTP is 123456");
        assertThat(result).isEqualTo("SMS: Your OTP is 123456");
    }

    @Test
    void shouldThrowExceptionForInvalidNotificationType() {
        assertThatThrownBy(() -> notificationService.createNotification("InvalidNotification", "Test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid notification type: InvalidNotification");
    }
}
