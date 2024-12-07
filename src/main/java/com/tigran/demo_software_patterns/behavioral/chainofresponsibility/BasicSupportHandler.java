package com.tigran.demo_software_patterns.behavioral.chainofresponsibility;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:01 PM
 */
public class BasicSupportHandler extends AbstractSupportHandler {

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 1) {
            System.out.println("BasicSupportHandler: Handling issue - " + issue);
        } else {
            System.out.println("BasicSupportHandler: Passing to next handler.");
            passToNext(issue, severity);
        }
    }
}

