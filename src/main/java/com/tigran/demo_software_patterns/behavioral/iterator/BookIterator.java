package com.tigran.demo_software_patterns.behavioral.iterator;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:11 PM
 */
public interface BookIterator {

    boolean hasNext();

    Book next();
}
