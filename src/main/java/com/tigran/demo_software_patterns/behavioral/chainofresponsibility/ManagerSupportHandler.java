package com.tigran.demo_software_patterns.behavioral.chainofresponsibility;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:02 PM
 */
public class ManagerSupportHandler extends AbstractSupportHandler {
 
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity == 2) {
            System.out.println("ManagerSupportHandler: Handling issue - " + issue);
        } else {
            System.out.println("ManagerSupportHandler: Passing to next handler.");
            passToNext(issue, severity);
        }
    }
}

