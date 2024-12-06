package com.tigran.demo_software_patterns.creational.singletone;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:21 PM
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("LazySingleton Instance Created");
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static LazySingleton getBeforeInit() {
        return instance;
    }
}
