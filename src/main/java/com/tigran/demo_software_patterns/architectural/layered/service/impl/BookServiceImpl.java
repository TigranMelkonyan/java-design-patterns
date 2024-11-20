package com.tigran.demo_software_patterns.architectural.layered.service.impl;

import com.tigran.demo_software_patterns.architectural.layered.model.entity.Book;
import com.tigran.demo_software_patterns.architectural.layered.repository.BookRepository;
import com.tigran.demo_software_patterns.architectural.layered.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/20/24
 * Time: 5:18 PM
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Book> getBookById(UUID id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
