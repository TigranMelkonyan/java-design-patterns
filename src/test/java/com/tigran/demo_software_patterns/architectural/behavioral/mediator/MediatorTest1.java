package com.tigran.demo_software_patterns.architectural.behavioral.mediator;

import com.tigran.demo_software_patterns.behavioral.mediator.demo1.chat.ChatMediator;
import com.tigran.demo_software_patterns.behavioral.mediator.demo1.chat.ChatRoomMediator;
import com.tigran.demo_software_patterns.behavioral.mediator.demo1.user.User;
import com.tigran.demo_software_patterns.behavioral.mediator.demo1.user.UserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:38 PM
 */
public class MediatorTest1 {

    private ChatMediator chatMediator;

    @BeforeEach
    void setUp() {
        chatMediator = new ChatRoomMediator();
    }

    @Test
    void testMediatorCommunication() {
        // Create users
        User user1 = new UserImpl(chatMediator, "Alice");
        User user2 = new UserImpl(chatMediator, "Bob");
        User user3 = new UserImpl(chatMediator, "John");

        // Register users to the mediator
        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);

        // Simulate communication
        user1.send("Hello, everyone!");
        user2.send("Hi, Alice!");
        user3.send("Good to see you, Alice!");

        assertDoesNotThrow(() -> user1.send("Isn't the Mediator pattern great?"));
    }

    @Test
    void testNoInteractionWhenNoOtherUsers() {
        User user1 = new UserImpl(chatMediator, "Alice");
        chatMediator.addUser(user1);

        assertDoesNotThrow(() -> user1.send("Am I alone here?"));
    }
}
