package com.tigran.demo_software_patterns.behavioral.mediator.demo2.mediator;

import com.tigran.demo_software_patterns.behavioral.mediator.demo2.aircraft.Aircraft;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:48 PM
 */
public interface ATCMediator {

    void requestLanding(Aircraft aircraft);

    void notifyRunwayAvailability();

    boolean isRunwayAvailable();
}

