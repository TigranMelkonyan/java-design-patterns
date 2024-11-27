package com.tigran.demo_software_patterns.behavioral.mediator.demo1.user;

import com.tigran.demo_software_patterns.behavioral.mediator.demo1.chat.ChatMediator;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:39 PM
 */
public abstract class User {

    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}
