package com.tigran.demo_software_patterns.architectural.layered.service;

import com.tigran.demo_software_patterns.architectural.layered.model.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/20/24
 * Time: 5:28 PM
 */
public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBookById(UUID id);

    Book saveBook(Book book);

    void deleteBook(UUID id);
}
