package com.tigran.demo_software_patterns.creational.abstractfactory.model;

import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 5:52 PM
 */
@Getter
public class Car implements Vehicle {

    private final String model;
    private final String fuelType;

    public Car(String model, String fuelType) {
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public void drive() {
        System.out.println("Driving a " + model + " car.");
    }

    @Override
    public void fuelType() {
        System.out.println("This car uses " + fuelType + " fuel.");
    }
}
