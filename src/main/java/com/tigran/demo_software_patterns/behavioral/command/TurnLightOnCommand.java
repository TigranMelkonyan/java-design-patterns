package com.tigran.demo_software_patterns.behavioral.command;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:17 PM
 */
public class TurnLightOnCommand implements Command {
   
    private final Light light;

    public TurnLightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

