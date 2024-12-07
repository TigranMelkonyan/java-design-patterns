package com.tigran.demo_software_patterns.architectural.behavioral.iterator;

import com.tigran.demo_software_patterns.behavioral.iterator.Book;
import com.tigran.demo_software_patterns.behavioral.iterator.BookCollection;
import com.tigran.demo_software_patterns.behavioral.iterator.BookCollectionImpl;
import com.tigran.demo_software_patterns.behavioral.iterator.BookIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:32 PM
 */
public class IteratorTest {

    private BookCollection bookCollection;

    @BeforeEach
    void setUp() {
        bookCollection = new BookCollectionImpl();
    }

    @Test
    void testAddAndIterateBooks() {
        bookCollection.addBook(new Book("Head First Java"));
        bookCollection.addBook(new Book("Clean Code"));
        bookCollection.addBook(new Book("Effective Java"));

        BookIterator iterator = bookCollection.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Head First Java", iterator.next().title());
        assertTrue(iterator.hasNext());
        assertEquals("Clean Code", iterator.next().title());
        assertTrue(iterator.hasNext());
        assertEquals("Effective Java", iterator.next().title());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testRemoveBookAndIterate() {
        Book book1 = new Book("Clean Code");
        Book book2 = new Book("Effective Java");

        bookCollection.addBook(book1);
        bookCollection.addBook(book2);

        bookCollection.removeBook(book1);

        BookIterator iterator = bookCollection.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Effective Java", iterator.next().title());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testEmptyCollection() {
        BookIterator iterator = bookCollection.iterator();
        assertFalse(iterator.hasNext());
    }
}
