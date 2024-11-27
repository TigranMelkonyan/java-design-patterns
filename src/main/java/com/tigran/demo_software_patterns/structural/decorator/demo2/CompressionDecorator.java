package com.tigran.demo_software_patterns.structural.decorator.demo2;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:46 PM
 */
public class CompressionDecorator extends DataProcessorDecorator {

    public CompressionDecorator(DataProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String data) {
        String processedData = super.process(data);
        return compress(processedData);
    }

    private String compress(String data) {
        return "Compressed(" + data + ")";
    }
}
