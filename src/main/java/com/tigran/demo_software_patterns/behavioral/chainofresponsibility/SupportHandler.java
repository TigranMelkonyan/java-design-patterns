package com.tigran.demo_software_patterns.behavioral.chainofresponsibility;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:00 PM
 */
public interface SupportHandler {

    void setNextHandler(SupportHandler nextHandler);

    void handleRequest(String issue, int severity);
}
