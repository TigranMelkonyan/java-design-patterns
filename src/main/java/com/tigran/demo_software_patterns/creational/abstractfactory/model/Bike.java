package com.tigran.demo_software_patterns.creational.abstractfactory.model;

import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 5:53 PM
 */
@Getter
public class Bike implements Vehicle {

    private final String model;
    private final String fuelType;

    public Bike(String model, String fuelType) {
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public void drive() {
        System.out.println("Riding a " + model + " bike.");
    }

    @Override
    public void fuelType() {
        System.out.println("This bike uses " + fuelType + " fuel.");
    }
}

