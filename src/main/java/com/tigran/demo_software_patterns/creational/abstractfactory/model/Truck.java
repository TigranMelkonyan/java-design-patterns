package com.tigran.demo_software_patterns.creational.abstractfactory.model;

import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 5:53 PM
 */
@Getter
public class Truck implements Vehicle {

    private final String model;
    private final String fuelType;

    public Truck(String model, String fuelType) {
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public void drive() {
        System.out.println("Driving a " + model + " truck.");
    }

    @Override
    public void fuelType() {
        System.out.println("This truck uses " + fuelType + " fuel.");
    }
}

