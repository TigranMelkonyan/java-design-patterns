package com.tigran.demo_software_patterns.structural.bridge.impl;

import com.tigran.demo_software_patterns.structural.bridge.abs.Device;
import com.tigran.demo_software_patterns.structural.bridge.abs.RemoteControl;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:41 PM
 */
public class AdvancedRemote extends RemoteControl {

    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void volumeUp() {
        device.volumeUp();
    }

    @Override
    public void volumeDown() {
        device.volumeDown();
    }

    public void mute() {
        System.out.println("Muting the device.");
    }
}
