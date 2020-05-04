package com.example.app.controllers;

import com.example.app.models.Book;
import com.example.app.repositories.BookRepository;
import com.example.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping//create a book
    public Book saveOrUpdate(@RequestBody Book book) { return bookService.saveOrUpdate(book);}

    @GetMapping//read all books
    public List<Book> findAll() { return bookService.findAll(); }

    @GetMapping("{id}")//read the single book
    public Book findById(@PathVariable String id) {
        return bookService.findById(id);
    }

    @DeleteMapping("{id}")//delete the book
    public void deleteById(@PathVariable String id) {bookService.deleteById(id);}

}
