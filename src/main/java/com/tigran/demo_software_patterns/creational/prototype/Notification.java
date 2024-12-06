package com.tigran.demo_software_patterns.creational.prototype;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:04 PM
 */
public interface Notification extends Cloneable {
   
    Notification clone();

    void setMessage(String message);

    String getMessage();
}
