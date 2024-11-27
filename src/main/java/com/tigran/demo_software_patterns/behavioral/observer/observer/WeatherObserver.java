package com.tigran.demo_software_patterns.behavioral.observer.observer;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 7:00 PM
 */
public interface WeatherObserver {

    void update(float temperature, float humidity, float pressure);
}

