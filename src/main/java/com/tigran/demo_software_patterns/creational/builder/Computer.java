package com.tigran.demo_software_patterns.creational.builder;

import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 6:15 PM
 */
@Getter
public class Computer {

    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String GPU;
    private final boolean isBluetoothEnabled;
    private final boolean hasWiFi;

    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.hasWiFi = builder.hasWiFi;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage +
                ", GPU=" + GPU + ", Bluetooth=" + isBluetoothEnabled + ", WiFi=" + hasWiFi + "]";
    }

    public static class ComputerBuilder {
        private final String CPU;
        private final String RAM;
        private String storage;
        private String GPU;
        private boolean isBluetoothEnabled;
        private boolean hasWiFi;

        public ComputerBuilder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public ComputerBuilder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder GPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public ComputerBuilder bluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public ComputerBuilder WiFiEnabled(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

