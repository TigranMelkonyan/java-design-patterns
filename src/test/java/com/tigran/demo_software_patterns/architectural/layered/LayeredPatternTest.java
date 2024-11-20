package com.tigran.demo_software_patterns.architectural.layered;

import com.tigran.demo_software_patterns.architectural.layered.model.entity.Book;
import com.tigran.demo_software_patterns.architectural.layered.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Tigran Melkonyan
 * Date: 11/20/24
 * Time: 5:33 PM
 */
@SpringBootTest
@AutoConfigureMockMvc
public class LayeredPatternTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCreateBook() throws Exception {
        // Given: a new book to be created
        String bookJson = "{"
                + "\"title\": \"The Great Gatsby\","
                + "\"author\": \"F. Scott Fitzgerald\","
                + "\"publisher\": \"Charles Scribner's Sons\","
                + "\"content\": \"The content of the book goes here...\""
                + "}";

        // When: making a POST request to create the book
        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("The Great Gatsby"))
                .andExpect(jsonPath("$.author").value("F. Scott Fitzgerald"))
                .andExpect(jsonPath("$.publisher").value("Charles Scribner's Sons"))
                .andExpect(jsonPath("$.content").value("The content of the book goes here..."));

        // Then: the book should be saved in the database
        Book savedBook = bookRepository.findAll().getFirst();
        assertEquals("The Great Gatsby", savedBook.getTitle());
        assertEquals("F. Scott Fitzgerald", savedBook.getAuthor());
        assertEquals("Charles Scribner's Sons", savedBook.getPublisher());
        assertEquals("The content of the book goes here...", savedBook.getContent());
    }
}
