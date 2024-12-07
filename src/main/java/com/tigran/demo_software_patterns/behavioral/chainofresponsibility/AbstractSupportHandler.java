package com.tigran.demo_software_patterns.behavioral.chainofresponsibility;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:00 PM
 */
public abstract class AbstractSupportHandler implements SupportHandler {

    protected SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected void passToNext(String issue, int severity) {
        if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("No handler available for severity: " + severity);
        }
    }
}

