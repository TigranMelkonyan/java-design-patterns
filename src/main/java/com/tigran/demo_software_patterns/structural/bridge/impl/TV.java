package com.tigran.demo_software_patterns.structural.bridge.impl;

import com.tigran.demo_software_patterns.structural.bridge.abs.Device;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:39 PM
 */
public class TV implements Device {
    
    @Override
    public void turnOn() {
        System.out.println("Turning on the TV.");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the TV.");
    }

    @Override
    public void volumeUp() {
        System.out.println("Turning up the TV volume.");
    }

    @Override
    public void volumeDown() {
        System.out.println("Turning down the TV volume.");
    }
}