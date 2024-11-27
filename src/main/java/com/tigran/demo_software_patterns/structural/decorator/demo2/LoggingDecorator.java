package com.tigran.demo_software_patterns.structural.decorator.demo2;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:47 PM
 */
public class LoggingDecorator extends DataProcessorDecorator {

    public LoggingDecorator(DataProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String data) {
        String processedData = super.process(data);
        log(processedData);
        return processedData;
    }

    private void log(String data) {
        System.out.println("Log: " + data);
    }
}
