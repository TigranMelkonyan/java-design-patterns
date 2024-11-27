package com.tigran.demo_software_patterns.behavioral.observer.observer;

import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 7:01 PM
 */
@Getter
public class WeatherObserverImpl implements WeatherObserver {

    private final String deviceName;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherObserverImpl(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println(deviceName + " - Current Weather: Temperature = " + temperature
                + "°C, Humidity = " + humidity + "%, Pressure = " + pressure + " hPa");
    }

    public float getLastTemperature() {
        return temperature;
    }

    public float getLastHumidity() {
        return humidity;
    }

    public float getLastPressure() {
        return pressure;
    }
}
