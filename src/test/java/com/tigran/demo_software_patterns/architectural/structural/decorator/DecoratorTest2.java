package com.tigran.demo_software_patterns.architectural.structural.decorator;

import com.tigran.demo_software_patterns.structural.decorator.demo2.BasicDataProcessor;
import com.tigran.demo_software_patterns.structural.decorator.demo2.CompressionDecorator;
import com.tigran.demo_software_patterns.structural.decorator.demo2.DataProcessor;
import com.tigran.demo_software_patterns.structural.decorator.demo2.EncryptionDecorator;
import com.tigran.demo_software_patterns.structural.decorator.demo2.LoggingDecorator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:41 PM
 */
public class DecoratorTest2 {

    @Test
    void testBasicDataProcessor() {
        DataProcessor processor = new BasicDataProcessor();
        assertEquals("Processed: raw_data", processor.process("raw_data"));
    }

    @Test
    void testWithEncryption() {
        DataProcessor processor = new EncryptionDecorator(new BasicDataProcessor());
        assertEquals("Encrypted(Processed: raw_data)", processor.process("raw_data"));
    }

    @Test
    void testWithCompression() {
        DataProcessor processor = new CompressionDecorator(new BasicDataProcessor());
        assertEquals("Compressed(Processed: raw_data)", processor.process("raw_data"));
    }

    @Test
    void testWithEncryptionAndCompression() {
        DataProcessor processor = new CompressionDecorator(new EncryptionDecorator(new BasicDataProcessor()));
        assertEquals("Compressed(Encrypted(Processed: raw_data))", processor.process("raw_data"));
    }

    @Test
    void testWithLoggingAndCompression() {
        DataProcessor processor = new LoggingDecorator(new CompressionDecorator(new BasicDataProcessor()));
        String result = processor.process("raw_data");
        assertEquals("Compressed(Processed: raw_data)", result);
    }
}
