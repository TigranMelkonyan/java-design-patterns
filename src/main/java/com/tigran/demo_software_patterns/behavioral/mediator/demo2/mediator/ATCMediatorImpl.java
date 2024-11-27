package com.tigran.demo_software_patterns.behavioral.mediator.demo2.mediator;

import com.tigran.demo_software_patterns.behavioral.mediator.demo2.aircraft.Aircraft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:48 PM
 */
public class ATCMediatorImpl implements ATCMediator {

    private boolean runwayAvailable = true;
    private final List<Aircraft> waitingQueue = new ArrayList<>();

    @Override
    public void requestLanding(Aircraft aircraft) {
        if (runwayAvailable) {
            System.out.println(aircraft.getIdentifier() + " is landing.");
            runwayAvailable = false;
        } else {
            System.out.println(aircraft.getIdentifier() + " is waiting to land.");
            waitingQueue.add(aircraft);
        }
    }

    @Override
    public void notifyRunwayAvailability() {
        runwayAvailable = true;
        if (!waitingQueue.isEmpty()) {
            Aircraft nextAircraft = waitingQueue.removeFirst();
            System.out.println("Runway available. Allowing " + nextAircraft.getIdentifier() + " to land.");
            requestLanding(nextAircraft);
        }
    }

    @Override
    public boolean isRunwayAvailable() {
        return runwayAvailable;
    }
}
