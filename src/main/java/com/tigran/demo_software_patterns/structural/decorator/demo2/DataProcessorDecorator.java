package com.tigran.demo_software_patterns.structural.decorator.demo2;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:45 PM
 */
public abstract class DataProcessorDecorator implements DataProcessor {

    protected DataProcessor wrappedProcessor;

    public DataProcessorDecorator(DataProcessor processor) {
        this.wrappedProcessor = processor;
    }

    @Override
    public String process(String data) {
        return wrappedProcessor.process(data);
    }
}

