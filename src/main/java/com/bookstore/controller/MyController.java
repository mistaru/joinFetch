package com.bookstore.controller;

import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public MyController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/list1")
    List<Author> authors() {
        return authorRepository.findAll();
    }

    @GetMapping("/list2")
    List<Book> books() {
        return bookRepository.findAll();
    }

    @GetMapping("/author/{id}")
    public Author author(@PathVariable Long id) {
        return authorRepository.findById(id).get();
    }

    @GetMapping("/book/{id}")
    public Book book(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

}
