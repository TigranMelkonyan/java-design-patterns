package com.tigran.demo_software_patterns.architectural.structural.proxy;

import com.tigran.demo_software_patterns.structural.proxy.RealService;
import com.tigran.demo_software_patterns.structural.proxy.ServiceIf;
import com.tigran.demo_software_patterns.structural.proxy.ServiceProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:22 PM
 */
public class ProxyTest {

    private ServiceIf realServiceMock;
    private ServiceIf proxyAuthenticated;
    private ServiceIf proxyUnauthenticated;

    @BeforeEach
    void setUp() {
        // Mock the RealService
        realServiceMock = mock(RealService.class);

        // Proxy with authenticated user
        proxyAuthenticated = new ServiceProxy(realServiceMock, true);

        // Proxy with unauthenticated user
        proxyUnauthenticated = new ServiceProxy(realServiceMock, false);
    }

    @Test
    void testProxyWithAuthenticatedUser() {
        // When the operation is performed
        proxyAuthenticated.performOperation();

        // Then the operation should be delegated to RealService
        verify(realServiceMock, times(1)).performOperation();
    }

    @Test
    void testProxyWithUnauthenticatedUser() {
        // When the operation is performed
        proxyUnauthenticated.performOperation();

        // Then the operation should not be delegated to RealService
        verify(realServiceMock, never()).performOperation();
    }
}
