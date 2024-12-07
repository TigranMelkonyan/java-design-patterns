package com.tigran.demo_software_patterns.behavioral.command;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:19 PM
 */
public class TurnLightOffCommand implements Command {

    private final Light light;

    public TurnLightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}