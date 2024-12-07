package com.tigran.demo_software_patterns.behavioral.command;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:17 PM
 */
public interface Command {

    void execute();

    void undo();
}

