package com.tigran.demo_software_patterns.behavioral.mediator.demo1.user;

import com.tigran.demo_software_patterns.behavioral.mediator.demo1.chat.ChatMediator;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:39 PM
 */
public class UserImpl extends User {

    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + ": Sending message -> " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + ": Received message -> " + message);
    }
}
