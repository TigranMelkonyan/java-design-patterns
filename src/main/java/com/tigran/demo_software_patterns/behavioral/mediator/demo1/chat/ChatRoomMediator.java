package com.tigran.demo_software_patterns.behavioral.mediator.demo1.chat;

import com.tigran.demo_software_patterns.behavioral.mediator.demo1.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:38 PM
 */
public class ChatRoomMediator implements ChatMediator {
    
    private final List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (!u.equals(user)) {
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
