package com.tigran.demo_software_patterns.architectural.behavioral.chainofresponsibility;

import com.tigran.demo_software_patterns.behavioral.chainofresponsibility.BasicSupportHandler;
import com.tigran.demo_software_patterns.behavioral.chainofresponsibility.DirectorSupportHandler;
import com.tigran.demo_software_patterns.behavioral.chainofresponsibility.ManagerSupportHandler;
import com.tigran.demo_software_patterns.behavioral.chainofresponsibility.SupportHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:01 PM
 */
public class ChainOfResponsibilityTest {

    private SupportHandler handlerChain;

    @BeforeEach
    void setUp() {
        // Create the chain
        SupportHandler basicHandler = new BasicSupportHandler();
        SupportHandler managerHandler = new ManagerSupportHandler();
        SupportHandler directorHandler = new DirectorSupportHandler();

        // Set up the chain
        basicHandler.setNextHandler(managerHandler);
        managerHandler.setNextHandler(directorHandler);

        handlerChain = basicHandler;
    }

    @Test
    void testBasicSupportHandler() {
        assertDoesNotThrow(() -> handlerChain.handleRequest("Simple issue", 1));
    }

    @Test
    void testManagerSupportHandler() {
        assertDoesNotThrow(() -> handlerChain.handleRequest("Intermediate issue", 2));
    }

    @Test
    void testDirectorSupportHandler() {
        assertDoesNotThrow(() -> handlerChain.handleRequest("Complex issue", 3));
    }

    @Test
    void testNoHandlerAvailable() {
        assertDoesNotThrow(() -> handlerChain.handleRequest("Unresolvable issue", 10));
    }
}
