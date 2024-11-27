package com.tigran.demo_software_patterns.behavioral.mediator.demo2.aircraft;

import com.tigran.demo_software_patterns.behavioral.mediator.demo2.mediator.ATCMediator;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:48 PM
 */
public abstract class Aircraft {

    protected final ATCMediator mediator;
    protected final String identifier;

    public Aircraft(ATCMediator mediator, String identifier) {
        this.mediator = mediator;
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public abstract void requestLanding();

    public abstract void notifyRunwayClear();

}
