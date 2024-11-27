package com.tigran.demo_software_patterns.behavioral.mediator.demo2.aircraft;

import com.tigran.demo_software_patterns.behavioral.mediator.demo2.mediator.ATCMediator;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:49 PM
 */
public class AircraftImpl extends Aircraft {

    public AircraftImpl(ATCMediator mediator, String identifier) {
        super(mediator, identifier);
    }

    @Override
    public void requestLanding() {
        System.out.println(identifier + " requesting landing.");
        mediator.requestLanding(this);
    }

    @Override
    public void notifyRunwayClear() {
        System.out.println(identifier + " has cleared the runway.");
        mediator.notifyRunwayAvailability();
    }
}

