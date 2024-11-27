package com.tigran.demo_software_patterns.structural.bridge.abs;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:40 PM
 */
public abstract class RemoteControl {

    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void volumeUp();

    public abstract void volumeDown();
}
