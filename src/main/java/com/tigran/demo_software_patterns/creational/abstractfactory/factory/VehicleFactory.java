package com.tigran.demo_software_patterns.creational.abstractfactory.factory;

import com.tigran.demo_software_patterns.creational.abstractfactory.model.Vehicle;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 5:53 PM
 */
public interface VehicleFactory {

    Vehicle createVehicle(String model, String fuelType);
}
