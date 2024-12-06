package com.tigran.demo_software_patterns.architectural.creational.singletone;

import com.tigran.demo_software_patterns.creational.singletone.EagerSingleton;
import com.tigran.demo_software_patterns.creational.singletone.LazySingleton;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:22 PM
 */
@SpringBootTest
public class SingletonTest {

    @Test
    void testSingletonInitialization() {
        System.out.println("Testing Eager Initialization:");
        // Eager Initialization Test
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();

        // Assert that both references point to the same instance
        assertNotNull(eagerSingleton1, "EagerSingleton instance should not be null");
        assertNotNull(eagerSingleton2, "EagerSingleton instance should not be null");
        assertSame(eagerSingleton1, eagerSingleton2, "EagerSingleton should return the same instance");

        System.out.println("Testing Lazy Initialization:");

        //Assert instance is null before invoking getInstance()
        assertThrows(NullPointerException.class, () -> LazySingleton.getBeforeInit().equals(null));

        // Lazy Initialization Test
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        // Assert that both references point to the same instance
        assertNotNull(lazySingleton1, "LazySingleton instance should not be null");
        assertNotNull(lazySingleton1, "LazySingleton instance should not be null");
        assertNotNull(lazySingleton2, "LazySingleton instance should not be null");
        assertSame(lazySingleton1, lazySingleton2, "LazySingleton should return the same instance");
    }
}
