package com.tigran.demo_software_patterns.architectural.creational.abstractfactory;

import com.tigran.demo_software_patterns.creational.abstractfactory.factory.VehicleFactory;
import com.tigran.demo_software_patterns.creational.abstractfactory.factory.VehicleFactoryProducer;
import com.tigran.demo_software_patterns.creational.abstractfactory.model.Bike;
import com.tigran.demo_software_patterns.creational.abstractfactory.model.Car;
import com.tigran.demo_software_patterns.creational.abstractfactory.model.Truck;
import com.tigran.demo_software_patterns.creational.abstractfactory.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 6:09 PM
 */
@SpringBootTest
public class AbstractFactoryTest {

    private VehicleFactory carFactory;
    private VehicleFactory truckFactory;
    private VehicleFactory bikeFactory;

    @BeforeEach
    void setUp() {
        carFactory = VehicleFactoryProducer.getFactory("CAR");
        truckFactory = VehicleFactoryProducer.getFactory("TRUCK");
        bikeFactory = VehicleFactoryProducer.getFactory("BIKE");
    }

    @Test
    void testCarCreationWithElectricFuel() {
        // Create an Electric Car
        Vehicle car = carFactory.createVehicle("Tesla Model 3", "Electric");

        // Verify the car's type and fuel
        assertNotNull(car);
        assertInstanceOf(Car.class, car);
        assertEquals("Tesla Model 3", ((Car) car).getModel());
        assertEquals("Electric", ((Car) car).getFuelType());

        // Simulate car behavior
        assertDoesNotThrow(car::drive);
        assertDoesNotThrow(car::fuelType);
    }

    @Test
    void testTruckCreationWithGasFuel() {
        // Create a Gas Truck
        Vehicle truck = truckFactory.createVehicle("Ford F-150", "Gas");

        // Verify the truck's type and fuel
        assertNotNull(truck);
        assertInstanceOf(Truck.class, truck);
        assertEquals("Ford F-150", ((Truck) truck).getModel());
        assertEquals("Gas", ((Truck) truck).getFuelType());

        // Simulate truck behavior
        assertDoesNotThrow(truck::drive);
        assertDoesNotThrow(truck::fuelType);
    }

    @Test
    void testBikeCreationWithHybridFuel() {
        // Create a Hybrid Bike
        Vehicle bike = bikeFactory.createVehicle("Yamaha MT-07", "Hybrid");

        // Verify the bike's type and fuel
        assertNotNull(bike);
        assertInstanceOf(Bike.class, bike);
        assertEquals("Yamaha MT-07", ((Bike) bike).getModel());
        assertEquals("Hybrid", ((Bike) bike).getFuelType());

        // Simulate bike behavior
        assertDoesNotThrow(bike::drive);
        assertDoesNotThrow(bike::fuelType);
    }

    @Test
    void testInvalidVehicleType() {
        // Trying to get a factory for an invalid vehicle type
        VehicleFactory invalidFactory = VehicleFactoryProducer.getFactory("PLANE");

        // Expecting null as no such factory should exist
        assertNull(invalidFactory);
    }

}
