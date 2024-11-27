package com.tigran.demo_software_patterns.architectural.behavioral.mediator;

import com.tigran.demo_software_patterns.behavioral.mediator.demo2.mediator.ATCMediator;
import com.tigran.demo_software_patterns.behavioral.mediator.demo2.mediator.ATCMediatorImpl;
import com.tigran.demo_software_patterns.behavioral.mediator.demo2.aircraft.Aircraft;
import com.tigran.demo_software_patterns.behavioral.mediator.demo2.aircraft.AircraftImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:38 PM
 */
public class MediatorTest2 {

    private ATCMediator atcMediator;

    @BeforeEach
    void setUp() {
        atcMediator = new ATCMediatorImpl();
    }

    @Test
    void testLandingRequests() {
        Aircraft aircraft1 = new AircraftImpl(atcMediator, "Flight A1");
        Aircraft aircraft2 = new AircraftImpl(atcMediator, "Flight B2");
        Aircraft aircraft3 = new AircraftImpl(atcMediator, "Flight C3");

        // Aircraft 1 land immediately
        aircraft1.requestLanding();
        assertFalse(atcMediator.isRunwayAvailable());

        // Aircraft 2 and 3 are added to the waiting queue
        aircraft2.requestLanding();
        aircraft3.requestLanding();
        assertFalse(atcMediator.isRunwayAvailable());

        // Aircraft 1 clears the runway
        aircraft1.notifyRunwayClear();
        assertFalse(atcMediator.isRunwayAvailable());

        // Aircraft 2 clears the runway
        aircraft2.notifyRunwayClear();
        assertFalse(atcMediator.isRunwayAvailable());

        // Aircraft 3 clears the runway
        aircraft3.notifyRunwayClear();
        assertTrue(atcMediator.isRunwayAvailable());
    }

    @Test
    void testRunwayAvailableForFirstAircraft() {
        Aircraft aircraft1 = new AircraftImpl(atcMediator, "Flight X1");
        aircraft1.requestLanding();
        assertFalse(atcMediator.isRunwayAvailable());
    }

    @Test
    void testEmptyQueueWhenRunwayCleared() {
        Aircraft aircraft1 = new AircraftImpl(atcMediator, "Flight Z1");
        aircraft1.requestLanding();
        aircraft1.notifyRunwayClear();
        assertTrue(atcMediator.isRunwayAvailable());
    }
}
