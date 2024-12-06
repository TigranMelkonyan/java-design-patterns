package com.tigran.demo_software_patterns.creational.singletone;

import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:21 PM
 */
public class EagerSingleton {

    @Getter
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("EagerSingleton Instance Created");
    }

}
