package com.tigran.demo_software_patterns.architectural.creational.builder;

import com.tigran.demo_software_patterns.creational.builder.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Tigran Melkonyan
 * Date: 12/5/24
 * Time: 6:16 PM
 */
@SpringBootTest
public class BuilderTest {

    private Computer.ComputerBuilder builder;

    @BeforeEach
    void setUp() {
        // Set up the builder for each test case
        builder = new Computer.ComputerBuilder("Intel i7", "16GB");
    }

    @Test
    void testGamingPCCreation() {
        // Create a Gaming PC using the builder
        Computer gamingPC = builder
                .storage("512GB SSD")
                .GPU("NVIDIA RTX 3070")
                .bluetoothEnabled(true)
                .WiFiEnabled(true)
                .build();

        // Assert that the object is not null
        assertNotNull(gamingPC);

        // Assert that the values set by the builder are correctly assigned
        assertTrue(gamingPC.toString().contains("CPU=Intel i7"));
        assertTrue(gamingPC.toString().contains("RAM=16GB"));
        assertTrue(gamingPC.toString().contains("storage=512GB SSD"));
        assertTrue(gamingPC.toString().contains("GPU=NVIDIA RTX 3070"));
        assertTrue(gamingPC.toString().contains("Bluetooth=true"));
        assertTrue(gamingPC.toString().contains("WiFi=true"));
    }

    @Test
    void testWorkstationPCWithoutGPU() {
        // Create a Workstation PC without GPU
        Computer workstationPC = builder
                .storage("1TB HDD")
                .WiFiEnabled(true)
                .build();

        // Assert that the object is not null
        assertNotNull(workstationPC);

        // Check the details
        assertTrue(workstationPC.toString().contains("CPU=Intel i7"));
        assertTrue(workstationPC.toString().contains("RAM=16GB"));
        assertTrue(workstationPC.toString().contains("storage=1TB HDD"));
        assertTrue(Objects.isNull(workstationPC.getGPU()));
        assertTrue(workstationPC.toString().contains("WiFi=true"));
        assertFalse(Objects.isNull(workstationPC.isBluetoothEnabled()));
    }

    @Test
    void testMinimalPCWithoutOptionalFeatures() {
        // Create a minimal PC with only mandatory fields
        Computer minimalPC = builder.build();

        // Assert that the object is not null
        assertNotNull(minimalPC);

        // Verify that the object has only the mandatory fields
        assertTrue(minimalPC.toString().contains("CPU=Intel i7"));
        assertTrue(minimalPC.toString().contains("RAM=16GB"));
        assertTrue(Objects.isNull(minimalPC.getStorage()));
        assertTrue(Objects.isNull(minimalPC.getGPU()));
        assertFalse(Objects.isNull(minimalPC.isBluetoothEnabled()));
        assertFalse(Objects.isNull(minimalPC.isHasWiFi()));
    }

    @Test
    void testInvalidConfiguration() {
        // Test edge case: Create a PC with invalid or missing configurations
        Computer invalidPC = new Computer.ComputerBuilder("Intel i5", "8GB").build();

        // Validate that the object is still created, but might have defaults for missing configurations
        assertNotNull(invalidPC);
        assertTrue(invalidPC.toString().contains("CPU=Intel i5"));
        assertTrue(invalidPC.toString().contains("RAM=8GB"));
    }
}
