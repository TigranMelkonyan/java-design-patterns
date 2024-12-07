package com.tigran.demo_software_patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 6:31 PM
 */
public class BookCollectionImpl implements BookCollection {
    
    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public BookIterator iterator() {
        return new BookIteratorImpl(books);
    }

    private static class BookIteratorImpl implements BookIterator {
        private final List<Book> books;
        private int position = 0;

        public BookIteratorImpl(List<Book> books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return position < books.size();
        }

        @Override
        public Book next() {
            return hasNext() ? books.get(position++) : null;
        }
    }
}
