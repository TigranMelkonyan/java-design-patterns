package com.tigran.demo_software_patterns.creational.abstractfactory.factory;

import com.tigran.demo_software_patterns.creational.abstractfactory.model.Car;
import com.tigran.demo_software_patterns.creational.abstractfactory.model.Vehicle;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 5:54 PM
 */
public class CarFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle(String model, String fuelType) {
        return new Car(model, fuelType);
    }
}
