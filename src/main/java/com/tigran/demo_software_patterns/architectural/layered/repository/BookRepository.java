package com.tigran.demo_software_patterns.architectural.layered.repository;

import com.tigran.demo_software_patterns.architectural.layered.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/20/24
 * Time: 5:16 PM
 */
public interface BookRepository extends JpaRepository<Book, UUID> {
}
