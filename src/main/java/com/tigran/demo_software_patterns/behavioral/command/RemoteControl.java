package com.tigran.demo_software_patterns.behavioral.command;

import lombok.Setter;

import java.util.Stack;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:18 PM
 */
public class RemoteControl {

    @Setter
    private Command command;
    private final Stack<Command> commandHistory = new Stack<>();

    public void pressButton() {
        command.execute();
        commandHistory.push(command);
    }

    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        }
    }
}
