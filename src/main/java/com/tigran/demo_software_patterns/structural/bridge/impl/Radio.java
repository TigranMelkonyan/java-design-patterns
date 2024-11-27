package com.tigran.demo_software_patterns.structural.bridge.impl;

import com.tigran.demo_software_patterns.structural.bridge.abs.Device;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 4:39 PM
 */
public class Radio implements Device {
   
    @Override
    public void turnOn() {
        System.out.println("Turning on the Radio.");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the Radio.");
    }

    @Override
    public void volumeUp() {
        System.out.println("Turning up the Radio volume.");
    }

    @Override
    public void volumeDown() {
        System.out.println("Turning down the Radio volume.");
    }
}