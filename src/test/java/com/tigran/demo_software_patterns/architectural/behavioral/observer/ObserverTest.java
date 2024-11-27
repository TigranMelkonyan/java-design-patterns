package com.tigran.demo_software_patterns.architectural.behavioral.observer;

import com.tigran.demo_software_patterns.behavioral.observer.observer.WeatherObserverImpl;
import com.tigran.demo_software_patterns.behavioral.observer.station.WeatherStationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:59 PM
 */
public class ObserverTest {

    private WeatherStationImpl weatherStation;
    private WeatherObserverImpl mobileApp;
    private WeatherObserverImpl desktopDisplay;

    @BeforeEach
    void setUp() {
        weatherStation = new WeatherStationImpl();
        mobileApp = new WeatherObserverImpl("Mobile App");
        desktopDisplay = new WeatherObserverImpl("Desktop Display");

        weatherStation.registerObserver(mobileApp);
        weatherStation.registerObserver(desktopDisplay);
    }

    @Test
    void testObserverReceivesUpdates() {
        weatherStation.setWeatherData(25.5f, 60.0f, 1013.0f);

        // Validate that both observers have received the update
        assertEquals(25.5f, mobileApp.getLastTemperature());
        assertEquals(60.0f, mobileApp.getLastHumidity());
        assertEquals(1013.0f, mobileApp.getLastPressure());

        assertEquals(25.5f, desktopDisplay.getLastTemperature());
        assertEquals(60.0f, desktopDisplay.getLastHumidity());
        assertEquals(1013.0f, desktopDisplay.getLastPressure());
    }

    @Test
    void testRemoveObserver() {
        weatherStation.removeObserver(desktopDisplay);
        weatherStation.setWeatherData(30.0f, 70.0f, 1010.0f);

        // Desktop display should not receive the update
        assertEquals(30.0f, mobileApp.getLastTemperature());
        assertEquals(70.0f, mobileApp.getLastHumidity());
        assertEquals(1010.0f, mobileApp.getLastPressure());

        // Ensure Desktop Display is not updated
        assertNotEquals(30.0f, desktopDisplay.getLastTemperature());
        assertNotEquals(70.0f, desktopDisplay.getLastHumidity());
        assertNotEquals(1010.0f, desktopDisplay.getLastPressure());
    }

    @Test
    void testMultipleUpdates() {
        weatherStation.setWeatherData(20.0f, 50.0f, 1020.0f);
        weatherStation.setWeatherData(22.5f, 55.0f, 1018.0f);
        weatherStation.setWeatherData(24.0f, 65.0f, 1015.0f);

        // All observers should receive all updates
        assertEquals(24.0f, mobileApp.getLastTemperature());
        assertEquals(65.0f, mobileApp.getLastHumidity());
        assertEquals(1015.0f, mobileApp.getLastPressure());

        assertEquals(24.0f, desktopDisplay.getLastTemperature());
        assertEquals(65.0f, desktopDisplay.getLastHumidity());
        assertEquals(1015.0f, desktopDisplay.getLastPressure());
    }
}
