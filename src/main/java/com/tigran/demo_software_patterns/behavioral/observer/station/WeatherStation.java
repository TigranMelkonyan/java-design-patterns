package com.tigran.demo_software_patterns.behavioral.observer.station;

import com.tigran.demo_software_patterns.behavioral.observer.observer.WeatherObserver;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 7:00 PM
 */
public interface WeatherStation {

    void registerObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();
}

