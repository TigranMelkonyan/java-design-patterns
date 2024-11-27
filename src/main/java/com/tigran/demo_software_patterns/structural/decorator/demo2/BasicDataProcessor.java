package com.tigran.demo_software_patterns.structural.decorator.demo2;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:45 PM
 */
public class BasicDataProcessor implements DataProcessor {
    
    @Override
    public String process(String data) {
        return "Processed: " + data;
    }
}

