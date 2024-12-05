package com.tigran.demo_software_patterns.creational.abstractfactory.factory;

import com.tigran.demo_software_patterns.creational.abstractfactory.model.Bike;
import com.tigran.demo_software_patterns.creational.abstractfactory.model.Vehicle;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 6:07 PM
 */
public class BikeFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle(String model, String fuelType) {
        return new Bike(model, fuelType);
    }
}

