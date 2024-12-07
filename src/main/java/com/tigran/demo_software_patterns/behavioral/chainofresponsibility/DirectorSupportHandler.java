package com.tigran.demo_software_patterns.behavioral.chainofresponsibility;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:02 PM
 */
public class DirectorSupportHandler extends AbstractSupportHandler {

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity >= 3) {
            System.out.println("DirectorSupportHandler: Handling issue - " + issue);
        } else {
            passToNext(issue, severity);
        }
    }
}

