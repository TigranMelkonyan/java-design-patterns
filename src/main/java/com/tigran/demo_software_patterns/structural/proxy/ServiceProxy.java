package com.tigran.demo_software_patterns.structural.proxy;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:21 PM
 */
public class ServiceProxy implements ServiceIf {

    private final ServiceIf realService;
    private final boolean isAuthenticated;

    public ServiceProxy(ServiceIf realService, boolean isAuthenticated) {
        this.realService = realService;
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public void performOperation() {
        if (isAuthenticated) {
            System.out.println("ServiceProxy: User authenticated.");
            realService.performOperation();
        } else {
            System.out.println("ServiceProxy: Access denied. User not authenticated.");
        }
    }
}