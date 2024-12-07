package com.tigran.demo_software_patterns.behavioral.iterator;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:12 PM
 */
public interface BookCollection {

    void addBook(Book book);

    void removeBook(Book book);

    BookIterator iterator();
}
