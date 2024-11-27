package com.tigran.demo_software_patterns.behavioral.mediator.demo1.chat;

import com.tigran.demo_software_patterns.behavioral.mediator.demo1.user.User;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:38 PM
 */
public interface ChatMediator {

    void sendMessage(String message, User user);

    void addUser(User user);
}
