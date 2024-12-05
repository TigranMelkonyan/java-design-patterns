package com.tigran.demo_software_patterns.creational.abstractfactory.factory;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 6:08 PM
 */
public class VehicleFactoryProducer {

    public static VehicleFactory getFactory(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new CarFactory();
        } else if (vehicleType.equalsIgnoreCase("TRUCK")) {
            return new TruckFactory();
        } else if (vehicleType.equalsIgnoreCase("BIKE")) {
            return new BikeFactory();
        }
        return null;
    }
}

