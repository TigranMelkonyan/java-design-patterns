package com.tigran.demo_software_patterns.structural.proxy;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:21 PM
 */
public class RealService implements ServiceIf {

    @Override
    public void performOperation() {
        System.out.println("RealService: Performing operation...");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
